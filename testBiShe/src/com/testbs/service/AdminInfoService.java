package com.testbs.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;


import com.testbs.dao.BaseDao;
import com.testbs.entity.AdminInfo;
import com.testbs.entity.TrainInfo;

public class AdminInfoService extends BaseDao {
	//��ҳ	
			public List<AdminInfo> getAdminInfoForPage(String stuffID,String stuffName,Integer pageNo,Integer pageSize) {
				String query="select * from admininfo where 1=1";
				List<Object> params =new ArrayList<Object>();
		        //����������
				if(stuffID!=null && !"".equals(stuffID)){
					query =query +" and stuffID like ?";
					params.add("%"+stuffID+"%");
				}
				if(stuffName!=null && !"".equals(stuffName)){
					query =query +" and stuffName like ?";
					params.add("%"+stuffName+"%");
				}

				params.add((pageNo-1)*pageSize);
				params.add(pageSize);
				List<AdminInfo> adminInfos = new ArrayList<AdminInfo>();
				ResultSet rs= this.executeQueryForPages(query, params);
				try {
					while(rs.next()){
						int id= rs.getInt("id");
						String stuffID1 = rs.getString("stuffID");
						String stuffName1 = rs.getString("stuffName");
						String reginDate = rs.getString("reginDate");
						String account=rs.getString("account");
						String password=rs.getString("password");
						
						AdminInfo adminInfo = new AdminInfo(id,stuffID1,stuffName1,reginDate,account,password);
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

			
			
			//�����в�����Ϣ
			public List<AdminInfo> findAllAdminInfos(){
				List<AdminInfo> adminInfos = new ArrayList<AdminInfo>();
				String query = "select * from admininfo";
				ResultSet rs = this.executeQuery(query, null);
				//�����ݴ�rs��ȡ������װ��User����
				try {
					while(rs.next()){                            
						int  id= rs.getInt("id");
						String stuffID1 = rs.getString("stuffID");
						String stuffName = rs.getString("stuffName");
						String reginDate = rs.getString("resignDate");	
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
			
			
			//��������������
			public List<AdminInfo> findAdminInfoByCondition(String stuffID,String stuffName) {
				List<AdminInfo> adminInfos = new ArrayList<AdminInfo>();
				List<Object> paramsTemp = new ArrayList<Object>();
				List<Object> params = new ArrayList<Object>();
								 
				 String	query ="";
				 ResultSet rs;
				 
				 if((stuffID!=""&&stuffID!=null)&&(stuffName!=""&&stuffName!=null)){
					 params.add(stuffID);		
					 params.add(stuffName);
					 paramsTemp=params;
					 
					 query = " select *  from  admininfo  where stuffID = ? and stuffName = ?";			
				 }
				 else  if((stuffID==""||stuffID==null)&&(stuffName!=""&&stuffName!=null)){
					
					 params.add(stuffName);
					 paramsTemp=params;		
					 query="select *  from  admininfo  where stuffName = ?";
				 }
				 else  if((stuffName==""||stuffName==null)&&(stuffID!=""&&stuffID!=null)){
					 
					 params.add(stuffID);
					 paramsTemp=params;
					 query="select *  from  admininfo  where stuffID = ?";
				 }
				 
				 rs = this.executeQuery(query, paramsTemp);
				 
				try {
					while(rs.next()){     
						String stuffID1 = rs.getString("stuffID");
						String stuffName1 = rs.getString("stuffName");
						String resignDate = rs.getString("resignDate");	
						String account=rs.getString("account");
						String password=rs.getString("password");	
										
						AdminInfo adminInfo = new AdminInfo(stuffID1,stuffName1,resignDate,account,password);
						adminInfos.add(adminInfo);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					this.close();
				}
				return adminInfos;
			}

			
			
			
		
			//����id������	
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
		  
			
			//�޸�	
			public int updateAdminInfo(AdminInfo adminInfo) {
				String update =" update admininfo set  account=?,password=? where stuffID=? ";
				List<Object> params = new ArrayList<Object>();
//				params.add(departmentInfo.getId());
				
				params.add(adminInfo.getAccount());
				params.add(adminInfo.getPassword());
				params.add(adminInfo.getStuffID());
				
				return this.executeUpdate(update, params);
			}

			//ɾ������
		     public int delAdminInfoId(String stuffID){
				
				    String sql="delete from admininfo where stuffID=?";
				    List<Object> params = new ArrayList<Object>();
				    params.add(stuffID);
				   return this.executeUpdate(sql, params);
			}
			
		     //���Ӳ���
			public int addAdminInfo(AdminInfo adminInfo){
				int result = 0;
				String sql = " insert into admininfo(stuffID,stuffName,resignDate,account,password) values (?,?,?,?,?)";
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

