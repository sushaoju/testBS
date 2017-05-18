package com.jyj.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jyj.dao.BaseDao;
import com.jyj.entity.Order;

public class OrderService extends BaseDao{
//分页	
	public List<Order> getOrdersForPage(String ypmc,Integer pageNo,Integer pageSize) {
		String query="select id,ypbh,ypmc,lb,sccs,yptm,ggxh,pzwh,bz,jg,sl  from orderr where 1=1";
		List<Object> params =new ArrayList<Object>();
        //搜索的条件
		if(ypmc!=null && !"".equals(ypmc)){
			query =query +" and ypmc like ?";
			params.add("%"+ypmc+"%");
		}

		params.add((pageNo-1)*pageSize);
		params.add(pageSize);
		List<Order> orders = new ArrayList<Order>();
		ResultSet rs= this.executeQueryForPages(query, params);
		try {
			while(rs.next()){
				String  id= rs.getString("id");
				String order1 = rs.getString("ypbh");
				String order2 = rs.getString("ypmc");
				String order3 = rs.getString("lb");
				String order4 = rs.getString("sccs");
				String order5 = rs.getString("yptm");
				String order6 = rs.getString("ggxh");
				String order7 = rs.getString("pzwh");
				String order8 = rs.getString("bz");
				String order9 = rs.getString("jg");
				String order10 = rs.getString("sl");
				Order order = new Order(id,order1,order2,order3,order4,order5,order6,order7,order8,order9,order10);
				orders.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.close();
		}
		return orders;
	}
	
	public int getTotalCount(String ypmc) {
		String sql = "select id,ypbh,ypmc,lb,sccs,yptm,ggxh,pzwh,bz,jg,sl  from orderr where 1=1";
		List<Object> params =new ArrayList<Object>();
		if(ypmc!=null && !"".equals(ypmc)){
			sql =sql +" and ypmc like ?";
			params.add("%"+ypmc+"%");
		}

		int result = executeTotalCountForPages(sql, params);
		return this.executeTotalCountForPages(sql, params);
	}
//找所有订单	
	public List<Order> findAllOrders(){
		List<Order> orders = new ArrayList<Order>();
		String query = "select ypmc,jg from orderr";
		ResultSet rs = this.executeQuery(query, null);
		//将数据从rs中取出并封装成User对象
		try {
			while(rs.next()){                            
				//String  id= rs.getString("id");
				/*String order1 = rs.getString("ypbh");*/
				String order2 = rs.getString("ypmc");
				/*String order3 = rs.getString("lb");
				String order4 = rs.getString("sccs");
				String order5 = rs.getString("yptm");
				String order6 = rs.getString("ggxh");
				String order7 = rs.getString("pzwh");
				String order8 = rs.getString("bz");
*/				String order9 = rs.getString("jg");
				/*String order10 = rs.getString("sl");
				String order11 = rs.getString("date");*/
				Order order = new Order(order2,order9);
				orders.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.close();
		}
		return orders;
	}
//根据id返数据	
	public Order findOrderById(String id) {
		String query = " select ypbh,ypmc,lb,sccs,ggxh,jg,sl,bz  from orderr where id = ?";
		List<Object> params = new ArrayList<Object>();
		params.add(id);
		ResultSet rs = this.executeQuery(query, params);
		try {
			if(rs.next()){
				String order1 = rs.getString("ypbh");
				String order2 = rs.getString("ypmc");
				String order3 = rs.getString("lb");
				String order4 = rs.getString("sccs");				
				String order5 = rs.getString("ggxh");
				String order6 = rs.getString("jg");
				String order7 = rs.getString("sl");
				String order8 = rs.getString("bz");				
				Order order = new Order(order1,order2,order3,order4,order5,order6,order7,order8);
				return order;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.close();
		}
		return null;
	}


//删除订单
     public int delOrderByYpmc(String ypmc){
		
		    String sql="delete from orderr where ypmc= ?";
		    List<Object> params = new ArrayList<Object>();
		    params.add(ypmc);
		   return this.executeUpdate(sql, params);
	}
	
//增加订单	
	public int addOrder(Order order){
		int result = 0;
		String sql = " insert into orderr(ypbh,ypmc,jg) values (?,?,?)";
		List<Object> params = new ArrayList<Object>();
		params.add(order.getYpbh());
		params.add(order.getYpmc());
		
		params.add(order.getJg());
		
		result= this.executeUpdate(sql, params);
		return result;
	}

	
}
