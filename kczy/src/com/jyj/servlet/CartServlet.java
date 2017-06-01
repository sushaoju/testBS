package com.jyj.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.jyj.entity.Cart;
import com.jyj.entity.GDrug;
import com.jyj.service.CartService;


public class CartServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		    doPost(req, resp);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		// 获取请求码
		String reqCode = req.getParameter("reqCode");
		if(reqCode.equals("findCartsForPages")){
			//当前页码Drugs
			String pageNo = req.getParameter("page");
			//页面大小
			String pageSize= req.getParameter("rows");
			//获取查询参数			
			String ypmc = req.getParameter("ypmc");
			
			CartService cartService =new CartService();
			List<Cart> carts = cartService.getCartsForPage(ypmc,Integer.valueOf(pageNo),Integer.valueOf(pageSize));
			int total = cartService.getTotalCount(ypmc);
			
			JSONObject json = new JSONObject();
			json.put("total", total);
			json.put("rows", carts);
			
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.write(json.toString());
			out.close();
		}else if(reqCode.equals("findAllCarts")){
			CartService cartService = new CartService();
			List<Cart> carts= cartService.findAllCarts();

			JSONObject json=new JSONObject();
			json.put("rows", carts);
			json.put("total", carts.size());
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.write(json.toString());
			out.close();
		}else if(reqCode.equals("findCartById")){
			//获取用户编号
			String  id =req.getParameter("id");
			//调用Model，查询该用户
			CartService cartService = new CartService();
			Cart cart = cartService.findCartById(id);
			
			JSONObject json=JSONObject.fromObject(cart);
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.write(json.toString());
			out.close();
			}else if(reqCode.equals("updateCart")){
				//提取数据
				String ypbh = req.getParameter("ypbh");	
				String ypmc = req.getParameter("ypmc");	
				String lb = req.getParameter("lb");	
				String sccs = req.getParameter("sccs");
				String ggxh =req.getParameter("ggxh");
				String jg =req.getParameter("jg");
				String sl =req.getParameter("sl");
				String bz =req.getParameter("bz");
				String id =req.getParameter("id");
				Cart cart = new Cart(ypbh,ypmc,lb,sccs,ggxh,jg,sl,bz,id);
				//调用Model
				CartService cartService =new CartService();
				int result= cartService.updateCart(cart);
				resp.setContentType("text/html;charset=utf-8");
				PrintWriter out = resp.getWriter();

				if (result > 0) {
					out.write("购物车修改成功！");
				} else {
					out.write("购物车修改失败！");
				}
				out.close();
				}else if (reqCode.equals("addCart")) {
					// 要做新增用户操作
					addCart(req, resp);
				}else if (reqCode.equals("delCart")) {
					delCart(req, resp);
				   } 
				
	}

		private void addCart(HttpServletRequest req, HttpServletResponse resp)
				throws IOException {
			// 获取参数	
			String ypbh = req.getParameter("ypbh");	
			String ypmc = req.getParameter("ypmc");	
			String lb = req.getParameter("lb");	
			String sccs = req.getParameter("sccs");
			String ggxh =req.getParameter("ggxh");
			String jg =req.getParameter("jg");
			String sl =req.getParameter("sl");
			String bz =req.getParameter("bz");
			
			// 将获取的参数封装成User
			Cart c = new Cart();
			c.setYpbh(ypbh);
            c.setYpmc(ypmc);
            c.setLb(lb);
            c.setSccs(sccs);
            c.setGgxh(ggxh);
            c.setJg(jg);
            c.setSl(sl);
            c.setBz(bz);

			// 调用Model执行数据处理（插入到数据库）s
			CartService cartService = new CartService();
			int result = cartService.addCart(c);

			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();

			if (result > 0) {
				out.write("增加购物车成功！");
			} else {
				out.write("增加购物车失败！");
			}
			out.close();
		}
		  
		private void delCart(HttpServletRequest req, HttpServletResponse resp) throws IOException {
			// 读取参数
			String id =req.getParameter("id");
			 
			// 调用Model，进行删除
			CartService cartService = new CartService();
			int result = cartService.delCartById(id);
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();

			if (result > 0) {
				out.write("删除成功！");
			} else {
				out.write("删除失败！");
			}
			out.close();
		}

}
