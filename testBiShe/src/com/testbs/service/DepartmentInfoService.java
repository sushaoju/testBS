package com.testbs.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.testbs.dao.BaseDao;
import com.testbs.entity.DepartmentInfo;

public class DepartmentInfoService extends BaseDao{
	//分页	
		public List<DepartmentInfo> getDepartmentInfoForPage(String departID,Integer pageNo,Integer pageSize) {
			String query="select *  from departmentinfo where 1=1";
			List<Object> params =new ArrayList<Object>();
	        //搜索的条件
			if(departID!=null && !"".equals(departID)){
				query =query +" and departID like ?";
				params.add("%"+departID+"%");
			}

			params.add((pageNo-1)*pageSize);
			params.add(pageSize);
			List<DepartmentInfo> departmentInfos = new ArrayList<DepartmentInfo>();
			ResultSet rs= this.executeQueryForPages(query, params);
			try {
				while(rs.next()){
					int  id= rs.getInt("id");
					String departID1 = rs.getString("departID");
					String departName = rs.getString("departName");
					String departPrince = rs.getString("departPrince");		
					DepartmentInfo departmentInfo = new DepartmentInfo(id,departID1,departName,departPrince);
					departmentInfos.add(departmentInfo);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				this.close();
			}
			return departmentInfos;
		}
		
		public int getTotalCount(String departID) {
			String sql = "select *  from departmentinfo where 1=1";
			List<Object> params =new ArrayList<Object>();
			if(departID!=null && !"".equals(departID)){
				sql =sql +" and departID like ?";
				params.add("%"+departID+"%");
			}

			int result = executeTotalCountForPages(sql, params);
			return this.executeTotalCountForPages(sql, params);
		}

		
		
		//找所有部门信息
		public List<DepartmentInfo> findAllDepartmentInfos(){
			List<DepartmentInfo> departmentInfos = new ArrayList<DepartmentInfo>();
			String query = "select *  from departmentinfo";
			ResultSet rs = this.executeQuery(query, null);
			//将数据从rs中取出并封装成User对象
			try {
				while(rs.next()){                            
					int  id= rs.getInt("id");
					String departID1 = rs.getString("departID");
					String departName = rs.getString("departName");
					String departPrince = rs.getString("departPrince");		
					DepartmentInfo departmentInfo = new DepartmentInfo(id,departID1,departName,departPrince);
					departmentInfos.add(departmentInfo);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				this.close();
			}
			return departmentInfos;
		}
	
		//根据id返数据	
		public DepartmentInfo findDepartmentInfoById(String departID) {
			
			List<Object> params = new ArrayList<Object>();
			 params.add(departID);		
			 
			 String	query = " select *  from  departmentinfo where departID = ?";			
			ResultSet rs = this.executeQuery(query, params);
			
			try {
				if(rs.next()){
				     int  id= rs.getInt("id");
					String departID1 = rs.getString("departID");
					String departName = rs.getString("departName");
					String departPrince = rs.getString("departPrince");					
					DepartmentInfo departmentInfo = new DepartmentInfo(id,departID1,departName,departPrince);
					return departmentInfo;
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
		public int updateDepartmentInfo(DepartmentInfo departmentInfo) {
			String update =" update departmentinfo set departName = ?,departPrince = ? where departID = ? ";
			List<Object> params = new ArrayList<Object>();
//			params.add(departmentInfo.getId());
			
			params.add(departmentInfo.getDepartName());
			params.add(departmentInfo.getDepartPrince());
			params.add(departmentInfo.getDepartID());
	
			return this.executeUpdate(update, params);
		}

		//删除部门
	     public int delDepartmentInfoId(String departID){
			
			    String sql="delete from departmentinfo where departID= ?";
			    List<Object> params = new ArrayList<Object>();
			    params.add(departID);
			   return this.executeUpdate(sql, params);
		}
		
	     //增加部门
		public int addDepartmentInfo(DepartmentInfo departmentInfo){
			int result = 0;
			String sql = " insert into departmentinfo(departID,departName,departPrince) values (?,?,?)";
			List<Object> params = new ArrayList<Object>();
			params.add(departmentInfo.getDepartID());
			params.add(departmentInfo.getDepartName());
			params.add(departmentInfo.getDepartPrince());
			result= this.executeUpdate(sql, params);
			return result;
		}
		
}
