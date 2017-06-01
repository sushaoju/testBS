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
		// ��ȡ������
		String reqCode = req.getParameter("reqCode");
		if(reqCode.equals("findCartsForPages")){
			//��ǰҳ��Drugs
			String pageNo = req.getParameter("page");
			//ҳ���С
			String pageSize= req.getParameter("rows");
			//��ȡ��ѯ����			
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
			//��ȡ�û����
			String  id =req.getParameter("id");
			//����Model����ѯ���û�
			CartService cartService = new CartService();
			Cart cart = cartService.findCartById(id);
			
			JSONObject json=JSONObject.fromObject(cart);
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.write(json.toString());
			out.close();
			}else if(reqCode.equals("updateCart")){
				//��ȡ����
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
				//����Model
				CartService cartService =new CartService();
				int result= cartService.updateCart(cart);
				resp.setContentType("text/html;charset=utf-8");
				PrintWriter out = resp.getWriter();

				if (result > 0) {
					out.write("���ﳵ�޸ĳɹ���");
				} else {
					out.write("���ﳵ�޸�ʧ�ܣ�");
				}
				out.close();
				}else if (reqCode.equals("addCart")) {
					// Ҫ�������û�����
					addCart(req, resp);
				}else if (reqCode.equals("delCart")) {
					delCart(req, resp);
				   } 
				
	}

		private void addCart(HttpServletRequest req, HttpServletResponse resp)
				throws IOException {
			// ��ȡ����	
			String ypbh = req.getParameter("ypbh");	
			String ypmc = req.getParameter("ypmc");	
			String lb = req.getParameter("lb");	
			String sccs = req.getParameter("sccs");
			String ggxh =req.getParameter("ggxh");
			String jg =req.getParameter("jg");
			String sl =req.getParameter("sl");
			String bz =req.getParameter("bz");
			
			// ����ȡ�Ĳ�����װ��User
			Cart c = new Cart();
			c.setYpbh(ypbh);
            c.setYpmc(ypmc);
            c.setLb(lb);
            c.setSccs(sccs);
            c.setGgxh(ggxh);
            c.setJg(jg);
            c.setSl(sl);
            c.setBz(bz);

			// ����Modelִ�����ݴ������뵽���ݿ⣩s
			CartService cartService = new CartService();
			int result = cartService.addCart(c);

			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();

			if (result > 0) {
				out.write("���ӹ��ﳵ�ɹ���");
			} else {
				out.write("���ӹ��ﳵʧ�ܣ�");
			}
			out.close();
		}
		  
		private void delCart(HttpServletRequest req, HttpServletResponse resp) throws IOException {
			// ��ȡ����
			String id =req.getParameter("id");
			 
			// ����Model������ɾ��
			CartService cartService = new CartService();
			int result = cartService.delCartById(id);
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();

			if (result > 0) {
				out.write("ɾ���ɹ���");
			} else {
				out.write("ɾ��ʧ�ܣ�");
			}
			out.close();
		}

}
