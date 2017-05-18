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
		// ��ȡ������
		String reqCode = req.getParameter("reqCode");
		if(reqCode.equals("findOrdersForPages")){
			//��ǰҳ��Drugs
			String pageNo = req.getParameter("page");
			//ҳ���С
			String pageSize= req.getParameter("rows");
			//��ȡ��ѯ����			
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
			//��ȡ�û����
			String  id =req.getParameter("id");
			//����Model����ѯ���û�
			OrderService orderService = new OrderService();
			Order cart = orderService.findOrderById(id);
			
			JSONObject json=JSONObject.fromObject(cart);
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.write(json.toString());
			out.close();
			}else if (reqCode.equals("addOrder")) {
					// Ҫ�������û�����
					addOrder(req, resp);
			}else if (reqCode.equals("delOrder")) {
					delOrder(req, resp);
				   } 
				
	}

		private void addOrder(HttpServletRequest req, HttpServletResponse resp)
				throws IOException {
			// ��ȡ����	
			String ypbh = req.getParameter("ypbh");	
			String ypmc = req.getParameter("ypmc");	
			
			String jg =req.getParameter("jg");
			
			
			// ����ȡ�Ĳ�����װ��User
			Order o = new Order();
			o.setYpbh(ypbh);
            o.setYpmc(ypmc);
           
            o.setJg(jg);
         

			// ����Modelִ�����ݴ������뵽���ݿ�)
            OrderService orderService = new OrderService();
			int result = orderService.addOrder(o);

			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();

			if (result > 0) {
				out.write("����ɹ����뵽���ҵĶ������в鿴~~");
			} else {
				out.write("����ʧ�ܣ�");
			}
			out.close();
		}
		  
		private void delOrder(HttpServletRequest req, HttpServletResponse resp) throws IOException {
			// ��ȡ����
			String ypmc =req.getParameter("ypmc");
			 
			// ����Model������ɾ��
			OrderService orderService = new OrderService();
			int result = orderService.delOrderByYpmc(ypmc);
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();

			if (result > 0) {
				out.write("����ɾ���ɹ���");
			} else {
				out.write("����ɾ��ʧ�ܣ�");
			}
			out.close();
		}

}
 