package com.jyj.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jyj.dao.BaseDao;
import com.jyj.entity.Cart;

public class CartService extends BaseDao{
//分页	
	public List<Cart> getCartsForPage(String ypmc,Integer pageNo,Integer pageSize) {
		String query="select id,ypbh,ypmc,lb,sccs,yptm,ggxh,pzwh,bz,jg,sl  from cart where 1=1";
		List<Object> params =new ArrayList<Object>();
        //搜索的条件
		if(ypmc!=null && !"".equals(ypmc)){
			query =query +" and ypmc like ?";
			params.add("%"+ypmc+"%");
		}

		params.add((pageNo-1)*pageSize);
		params.add(pageSize);
		List<Cart> carts = new ArrayList<Cart>();
		ResultSet rs= this.executeQueryForPages(query, params);
		try {
			while(rs.next()){
				String  id= rs.getString("id");
				String cart1 = rs.getString("ypbh");
				String cart2 = rs.getString("ypmc");
				String cart3 = rs.getString("lb");
				String cart4 = rs.getString("sccs");
				String cart5 = rs.getString("yptm");
				String cart6 = rs.getString("ggxh");
				String cart7 = rs.getString("pzwh");
				String cart8 = rs.getString("bz");
				String cart9 = rs.getString("jg");
				String cart10 = rs.getString("sl");
				Cart cart = new Cart(id,cart1,cart2,cart3,cart4,cart5,cart6,cart7,cart8,cart9,cart10);
				carts.add(cart);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.close();
		}
		return carts;
	}
	
	public int getTotalCount(String ypmc) {
		String sql = "select id,ypbh,ypmc,lb,sccs,yptm,ggxh,pzwh,bz,jg,sl  from cart where 1=1";
		List<Object> params =new ArrayList<Object>();
		if(ypmc!=null && !"".equals(ypmc)){
			sql =sql +" and ypmc like ?";
			params.add("%"+ypmc+"%");
		}

		int result = executeTotalCountForPages(sql, params);
		return this.executeTotalCountForPages(sql, params);
	}
//找所有药	
	public List<Cart> findAllCarts(){
		List<Cart> carts = new ArrayList<Cart>();
		String query = "select id,ypbh,ypmc,lb,sccs,yptm,ggxh,pzwh,bz,jg,sl  from cart";
		ResultSet rs = this.executeQuery(query, null);
		//将数据从rs中取出并封装成User对象
		try {
			while(rs.next()){                            
				String  id= rs.getString("id");
				String cart1 = rs.getString("ypbh");
				String cart2 = rs.getString("ypmc");
				String cart3 = rs.getString("lb");
				String cart4 = rs.getString("sccs");
				String cart5 = rs.getString("yptm");
				String cart6 = rs.getString("ggxh");
				String cart7 = rs.getString("pzwh");
				String cart8 = rs.getString("bz");
				String cart9 = rs.getString("jg");
				String cart10 = rs.getString("sl");
				Cart cart = new Cart(id,cart1,cart2,cart3,cart4,cart5,cart6,cart7,cart8,cart9,cart10);
				carts.add(cart);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.close();
		}
		return carts;
	}
//根据id返数据	
	public Cart findCartById(String id) {
		String query = " select ypbh,ypmc,lb,sccs,ggxh,jg,sl,bz  from cart where id = ?";
		List<Object> params = new ArrayList<Object>();
		params.add(id);
		ResultSet rs = this.executeQuery(query, params);
		try {
			if(rs.next()){
				String cart1 = rs.getString("ypbh");
				String cart2 = rs.getString("ypmc");
				String cart3 = rs.getString("lb");
				String cart4 = rs.getString("sccs");				
				String cart5 = rs.getString("ggxh");
				String cart6 = rs.getString("jg");
				String cart7 = rs.getString("sl");
				String cart8 = rs.getString("bz");				
				Cart cart = new Cart(cart1,cart2,cart3,cart4,cart5,cart6,cart7,cart8);
				return cart;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.close();
		}
		return null;
	}
//修改	
	public int updateCart(Cart cart) {
		String update =" update cart set ypbh = ?,ypmc = ?,lb = ?,sccs = ?,ggxh = ?,jg = ?,sl = ?,bz = ? where id = ? ";
		List<Object> params = new ArrayList<Object>();
		params.add(cart.getYpbh());
		params.add(cart.getYpmc());
		params.add(cart.getLb());
		params.add(cart.getSccs());
		params.add(cart.getGgxh());
		params.add(cart.getJg());
		params.add(cart.getSl());
		params.add(cart.getBz());
		params.add(cart.getId());


		return this.executeUpdate(update, params);
	}

//删除购物车
     public int delCartById(String id){
		
		    String sql="delete from cart where id= ?";
		    List<Object> params = new ArrayList<Object>();
		    params.add(id);
		   return this.executeUpdate(sql, params);
	}
	
//增加购物车	
	public int addCart(Cart cart){
		int result = 0;
		String sql = " insert into cart(ypbh,ypmc,lb,sccs,ggxh,jg,sl,bz) values (?,?,?,?,?,?,?,?)";
		List<Object> params = new ArrayList<Object>();
		params.add(cart.getYpbh());
		params.add(cart.getYpmc());
		params.add(cart.getLb());
		params.add(cart.getSccs());
		params.add(cart.getGgxh());
		params.add(cart.getJg());
		params.add(cart.getSl());
		params.add(cart.getBz());
		result= this.executeUpdate(sql, params);
		return result;
	}
	
}
