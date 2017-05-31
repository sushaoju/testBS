package com.testbs.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;


import com.testbs.dao.BaseDao;
import com.testbs.entity.AdminInfo;

public class AdminInfoService extends BaseDao {
	//分页	
			public List<AdminInfo> getAdminInfoForPage(String stuffID,Integer pageNo,Integer pageSize) {
				String query="select * from admininfo where 1=1";
				List<Object> params =new ArrayList<Object>();
		        //搜索的条件
				if(stuffID!=null && !"".equals(stuffID)){
					query =query +" and stuffID like ?";
					params.add("%"+stuffID+"%");
				}

				params.add((pageNo-1)*pageSize);
				params.add(pageSize);
				List<AdminInfo> adminInfos = new ArrayList<AdminInfo>();
				ResultSet rs= this.executeQueryForPages(query, params);
				try {
					while(rs.next()){
						int id= rs.getInt("id");
						String stuffID1 = rs.getString("stuffID");
						String stuffName = rs.getString("stuffName");
						String reginDate = rs.getString("reginDate");
						String account=rs.getString("account");
						String password=rs.getString("password");
						
						AdminInfo adminInfo = new AdminInfo(id,stuffID1,stuffName,reginDate,account,password);
						adminInfos.add(adminInfo);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}finally{
					this.close();
				}
				return adminInfos;
			}
			
			public int getTotalCount(String stuffID) {
				String sql = "select * from admininfo where 1=1";
				List<Object> params =new ArrayList<Object>();
				if(stuffID!=null && !"".equals(stuffID)){
					sql =sql +" and stuffID like ?";
					params.add("%"+stuffID+"%");
				}

				int result = executeTotalCountForPages(sql,params);
				return this.executeTotalCountForPages(sql,params);
			}

			
			
			//找所有部门信息
			public List<AdminInfo> findAllAdminInfos(){
				List<AdminInfo> adminInfos = new ArrayList<AdminInfo>();
				String query = "select * from admininfo";
				ResultSet rs = this.executeQuery(query, null);
				//将数据从rs中取出并封装成User对象
				try {
					while(rs.next()){                            
						int  id= rs.getInt("id");
						String stuffID1 = rs.getString("stuffID");
						String stuffName = rs.getString("stuffName");
						String reginDate = rs.getString("reginDate");	
						String account=rs.getString("account");
						String password=rs.getString("password");	
						AdminInfo adminInfo = new AdminInfo(id,stuffID1,stuffName,reginDate,account,password);
						adminInfos.add(adminInfo);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}finally{
					this.close();
				}
				return adminInfos;
			}
		
			//根据id返数据	
			public AdminInfo findAdminInfoById(String stuffID) {
				
				List<Object> params = new ArrayList<Object>();
				 params.add(stuffID);		
				 
				 String	query = " select * from admininfo where stuffID=?";			
				ResultSet rs = this.executeQuery(query, params);
				
				try {
					if(rs.next()){
					     int  id= rs.getInt("id");
					     String stuffID1 = rs.getString("stuffID");
							String stuffName = rs.getString("stuffName");
							String reginDate = rs.getString("reginDate");
							String account=rs.getString("account");
							String password=rs.getString("password");					
						AdminInfo adminInfo = new AdminInfo(id,stuffID1,stuffName,reginDate,account,password);
						return adminInfo;
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
			public int updateAdminInfo(AdminInfo adminInfo) {
				String update =" update admininfo set stuffName=?,account=?,password=? where stuffID=? ";
				List<Object> params = new ArrayList<Object>();
//				params.add(departmentInfo.getId());
				
				params.add(adminInfo.getStuffName());
				params.add(adminInfo.getAccount());
				params.add(adminInfo.getPassword());
		
				return this.executeUpdate(update, params);
			}

			//删除部门
		     public int delAdminInfoId(String stuffID){
				
				    String sql="delete from admininfo where stuffID=?";
				    List<Object> params = new ArrayList<Object>();
				    params.add(stuffID);
				   return this.executeUpdate(sql, params);
			}
			
		     //增加部门
			public int addAdminInfo(AdminInfo adminInfo){
				int result = 0;
				String sql = " insert into admininfo(stuffID,stuffName,reginDate,account,password) values (?,?,?,?,?)";
				List<Object> params = new ArrayList<Object>();
				params.add(adminInfo.getStuffID());
				params.add(adminInfo.getStuffName());
				params.add(adminInfo.getResignDate());
				params.add(adminInfo.getAccount());
				params.add(adminInfo.getPassword());
				result= this.executeUpdate(sql, params);
				return result;
			}
			
	}

