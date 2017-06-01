package com.testbs.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.testbs.dao.BaseDao;

import com.testbs.entity.SalaryInfo;


public class SalaryInfoService extends BaseDao {
	//分页	
	public List<SalaryInfo> getSalaryInfoForPage(String stuffID,String stuffName,Integer pageNo,Integer pageSize) {
		String query="select * from salaryinfo where 1=1";
		List<Object> params =new ArrayList<Object>();
        //搜索的条件
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
		List<SalaryInfo> salaryInfos = new ArrayList<SalaryInfo>();
		ResultSet rs= this.executeQueryForPages(query, params);
		try {
			while(rs.next()){
				int id= rs.getInt("id");
				String stuffID1 = rs.getString("stuffID");
				String stuffName1 = rs.getString("stuffName");
				String stuffDepart = rs.getString("stuffDepart");
				String stuffDuty=rs.getString("stuffDuty");
				double basicSalary=rs.getDouble("basicSalary");
				double delSalary=rs.getDouble("delSalary");
				double addSalary=rs.getDouble("addSalary");
				double accountAwce=rs.getDouble("accountAwce");
				double fSalary=rs.getDouble("fSalary");
				
				
				SalaryInfo salaryInfo = new SalaryInfo(id,stuffID1,stuffName1,stuffDepart,stuffDuty,basicSalary,
						delSalary,addSalary,accountAwce,fSalary);
				salaryInfos.add(salaryInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.close();
		}
		return salaryInfos;
	}
	
	public int getTotalCount(String stuffID) {
		String sql = "select * from salaryinfo where 1=1";
		List<Object> params =new ArrayList<Object>();
		if(stuffID!=null && !"".equals(stuffID)){
			sql =sql +" and stuffID like ?";
			params.add("%"+stuffID+"%");
		}

		int result = executeTotalCountForPages(sql,params);
		return this.executeTotalCountForPages(sql,params);
	}

	
	
	//找所有部门信息
	public List<SalaryInfo> findAllSalaryInfos(){
		List<SalaryInfo> salaryInfos = new ArrayList<SalaryInfo>();
		String query = "select * from salaryinfo";
		ResultSet rs = this.executeQuery(query, null);
		//将数据从rs中取出并封装成User对象
		try {
			while(rs.next()){                            
				int  id= rs.getInt("id");
				String stuffID1 = rs.getString("stuffID");
				String stuffName = rs.getString("stuffName");
				String stuffDepart = rs.getString("stuffDepart");
				String stuffDuty=rs.getString("stuffDuty");
				double basicSalary=rs.getDouble("basicSalary");
				double delSalary=rs.getDouble("delSalary");
				double addSalary=rs.getDouble("addSalary");
				double accountAwce=rs.getDouble("accountAwce");
                double fSalary=rs.getDouble("fSalary");
				
				
				SalaryInfo salaryInfo = new SalaryInfo(id,stuffID1,stuffName,stuffDepart,stuffDuty,basicSalary,
						delSalary,addSalary,accountAwce,fSalary);
				salaryInfos.add(salaryInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.close();
		}
		return salaryInfos;
	}
	//根据条件返数据
		public List<SalaryInfo> findSalaryInfoByCondition(String stuffID,String stuffName,String stuffDepart) {
			List<SalaryInfo> salaryInfos = new ArrayList<SalaryInfo>();
			List<Object> paramsTemp = new ArrayList<Object>();
			List<Object> params = new ArrayList<Object>();
							 
			 String	query ="";
			 ResultSet rs;
			 
			 if((stuffID!=""&&stuffID!=null)&&(stuffName!=""&&stuffName!=null)&&(stuffDepart!=""&&stuffDepart!=null)){
				 params.add(stuffID);		
				 params.add(stuffName);
				 params.add(stuffDepart);
				 paramsTemp=params;
				 
				 query = " select *  from  salaryinfo  where stuffID = ? and stuffName = ? and stuffDepart =?";			
				
			 }
			 else  if((stuffID==""||stuffID==null)&&(stuffDepart==""||stuffDepart==null)&&(stuffName!=""&&stuffName!=null)){
				
				 params.add(stuffName);
				 paramsTemp=params;		
				 query="select *  from  salaryinfo  where stuffName = ?";
			 }
			 else  if((stuffID==""||stuffID==null)&&(stuffName==""||stuffName==null)&&(stuffDepart!=""&&stuffDepart!=null)){
				
				 params.add(stuffDepart);
				 paramsTemp=params;
				 query="select *  from  salaryinfo  where stuffDepart = ?";
			 }
			 else  if((stuffDepart==""||stuffDepart==null)&&(stuffName==""||stuffName==null)&&(stuffID!=""&&stuffID!=null)){
				 
				 params.add(stuffID);
				 paramsTemp=params;
				 query="select *  from  salaryinfo  where stuffID = ?";
			 }
			 else  if((stuffID!=""||stuffID!=null)&&(stuffName!=""||stuffName!=null)&&(stuffDepart==""&&stuffDepart==null)){
				 params.add(stuffID);
				 params.add(stuffName);
				 paramsTemp=params;
				 query="select *  from  salaryinfo  where stuffID = ? and stuffName = ?";
			 }
			 else  if((stuffID!=""||stuffID!=null)&&(stuffName==""||stuffName==null)&&(stuffDepart!=""&&stuffDepart!=null)){
				 
				 params.add(stuffID);
				 params.add(stuffDepart);
				 paramsTemp=params;
				 query="select *  from  salaryinfo  where stuffID = ? and stuffDepart =?";
			 }
			 else  if((stuffID==""||stuffID==null)&&(stuffName!=""||stuffName!=null)&&(stuffDepart!=""&&stuffDepart!=null)){
				 
				 params.add(stuffName);
				 params.add(stuffDepart);
				 paramsTemp=params;
				 query="select *  from  salaryinfo  where stuffName = ? and stuffDepart =?";
			 }
					 
			 rs = this.executeQuery(query, paramsTemp);
			 
			try {
				while(rs.next()){     
				        String stuffID1 = rs.getString("stuffID");	
						String stuffName1=rs.getString("stuffName");
						String stuffDepart1=rs.getString("stuffDepart");
						String stuffDuty=rs.getString("stuffDuty");
						double basicSalary=rs.getDouble("basicSalary");
						double delSalary=rs.getDouble("delSalary");
						double addSalary=rs.getDouble("addSalary");
						double accountAwce=rs.getDouble("accountAwce");
						double fSalary=rs.getDouble("fSalary");
									
						SalaryInfo salaryInfo = new SalaryInfo(stuffID1,stuffName1,stuffDepart1,stuffDuty,basicSalary,delSalary,addSalary,accountAwce,fSalary);
						salaryInfos.add(salaryInfo);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				this.close();
			}
			return salaryInfos;
		}

	//根据id返数据	
	public SalaryInfo findSalaryInfoById(String stuffID) {
		
		List<Object> params = new ArrayList<Object>();
		 params.add(stuffID);		
		 
		 String	query = " select * from salaryinfo where stuffID=?";			
		ResultSet rs = this.executeQuery(query, params);
		
		try {
			if(rs.next()){
			     int  id= rs.getInt("id");
			     String stuffID1 = rs.getString("stuffID");
					String stuffName = rs.getString("stuffName");
					String stuffDepart = rs.getString("stuffDepart");
					String stuffDuty=rs.getString("stuffDuty");
					double basicSalary=rs.getDouble("basicSalary");
					double delSalary=rs.getDouble("delSalary");
					double addSalary=rs.getDouble("addSalary");
					double accountAwce=rs.getDouble("accountAwce");
					double fSalary=rs.getDouble("fSalary");
					
					
					SalaryInfo salaryInfo = new SalaryInfo(id,stuffID1,stuffName,stuffDepart,stuffDuty,basicSalary,
							delSalary,addSalary,accountAwce,fSalary);
				return salaryInfo;
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
	public int updateSalaryInfo(SalaryInfo salaryInfo) {
		String update =" update salaryinfo set stuffName=?,stuffDepart=?,stuffDuty=?,basicSalary=?,delSalary=?,addSalary=?,fSalary=? where stuffID=? ";
		List<Object> params = new ArrayList<Object>();
//		params.add(departmentInfo.getId());
		params.add(salaryInfo.getStuffID());
		params.add(salaryInfo.getStuffName());
		params.add(salaryInfo.getStuffDepart());
		params.add(salaryInfo.getStuffDuty());
		params.add(salaryInfo.getBasicSalary());
		params.add(salaryInfo.getDelSalary());
		params.add(salaryInfo.getAddSalary());
		params.add(salaryInfo.getfSalary());



		return this.executeUpdate(update, params);
	}

	//删除部门
     public int delSalaryInfoId(String stuffID){
		
		    String sql="delete from salaryinfo where stuffID=?";
		    List<Object> params = new ArrayList<Object>();
		    params.add(stuffID);
		   return this.executeUpdate(sql, params);
	}
	
     //增加部门
	public int addSalaryInfo(SalaryInfo salaryInfo){
		int result = 0;
		String sql = " insert into salaryinfo(stuffID,stuffName,stuffDepart,stuffDuty,basicSalary,delSalary,addSalary,fSalary) values (?,?,?,?,?,?,?,?)";
		List<Object> params = new ArrayList<Object>();
		params.add(salaryInfo.getStuffID());
		params.add(salaryInfo.getStuffName());
		params.add(salaryInfo.getStuffDepart());
		params.add(salaryInfo.getStuffDuty());
		params.add(salaryInfo.getBasicSalary());
		params.add(salaryInfo.getDelSalary());
		params.add(salaryInfo.getAddSalary());
		params.add(salaryInfo.getfSalary());

		result= this.executeUpdate(sql, params);
		return result;
	}
	
}


