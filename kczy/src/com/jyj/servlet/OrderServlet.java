package com.jyj.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.jyj.entity.Order;
import com.jyj.service.OrderService;


public class OrderServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		    doPost(req, resp);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		// 获取请求码
		String reqCode = req.getParameter("reqCode");
		if(reqCode.equals("findOrdersForPages")){
			//当前页码Drugs
			String pageNo = req.getParameter("page");
			//页面大小
			String pageSize= req.getParameter("rows");
			//获取查询参数			
			String ypmc = req.getParameter("ypmc");
			
			OrderService orderService =new OrderService();
			List<Order> orders =orderService.getOrdersForPage(ypmc,Integer.valueOf(pageNo),Integer.valueOf(pageSize));
			int total = orderService.getTotalCount(ypmc);
			
			JSONObject json = new JSONObject();
			json.put("total", total);
			json.put("rows", orders);
			
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.write(json.toString());
			out.close();
		}else if(reqCode.equals("findAllOrders")){
			OrderService orderService = new OrderService();
			List<Order> orders= orderService.findAllOrders();

			JSONArray array=new JSONArray().fromObject(orders);
//			JSONObject json=new JSONObject();
//			json.put("rows", orders);
//			json.put("total", orders.size());
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.write(array.toString());
			out.close();
			System.out.println(array.toString());
		}else if(reqCode.equals("findOrderById")){
			//获取用户编号
			String  id =req.getParameter("id");
			//调用Model，查询该用户
			OrderService orderService = new OrderService();
			Order cart = orderService.findOrderById(id);
			
			JSONObject json=JSONObject.fromObject(cart);
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.write(json.toString());
			out.close();
			}else if (reqCode.equals("addOrder")) {
					// 要做新增用户操作
					addOrder(req, resp);
			}else if (reqCode.equals("delOrder")) {
					delOrder(req, resp);
				   } 
				
	}

		private void addOrder(HttpServletRequest req, HttpServletResponse resp)
				throws IOException {
			// 获取参数	
			String ypbh = req.getParameter("ypbh");	
			String ypmc = req.getParameter("ypmc");	
			
			String jg =req.getParameter("jg");
			
			
			// 将获取的参数封装成User
			Order o = new Order();
			o.setYpbh(ypbh);
            o.setYpmc(ypmc);
           
            o.setJg(jg);
         

			// 调用Model执行数据处理（插入到数据库)
            OrderService orderService = new OrderService();
			int result = orderService.addOrder(o);

			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();

			if (result > 0) {
				out.write("购买成功！请到“我的订单”中查看~~");
			} else {
				out.write("购买失败！");
			}
			out.close();
		}
		  
		private void delOrder(HttpServletRequest req, HttpServletResponse resp) throws IOException {
			// 读取参数
			String ypmc =req.getParameter("ypmc");
			 
			// 调用Model，进行删除
			OrderService orderService = new OrderService();
			int result = orderService.delOrderByYpmc(ypmc);
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();

			if (result > 0) {
				out.write("订单删除成功！");
			} else {
				out.write("订单删除失败！");
			}
			out.close();
		}

}
 