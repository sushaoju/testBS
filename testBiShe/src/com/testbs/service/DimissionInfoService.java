package com.testbs.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

import com.testbs.dao.BaseDao;

import com.testbs.entity.DimissionInfo;
import com.testbs.entity.stuffJob;

public class DimissionInfoService extends BaseDao {
	// 分页
	public List<DimissionInfo> getDimissionInfoForPage(String stuffID,
			Integer pageNo, Integer pageSize) {
		String query = "select * from dimissioninfo where 1=1";
		List<Object> params = new ArrayList<Object>();
		// 搜索的条件
		if (stuffID != null && !"".equals(stuffID)) {
			query = query + " and stuffID like ?";
			params.add("%" + stuffID + "%");
		}

		params.add((pageNo - 1) * pageSize);
		params.add(pageSize);
		List<DimissionInfo> dimissionInfos = new ArrayList<DimissionInfo>();
		ResultSet rs = this.executeQueryForPages(query, params);
		try {
			while (rs.next()) {
				int id = rs.getInt("id");
				String stuffID1 = rs.getString("stuffID");
				String stuffName = rs.getString("stuffName");
				String stuffDepart = rs.getString("stuffDepart");
				String stuffDuty = rs.getString("stuffDuty");
				String dimissInterface = rs.getString("dimissInterface");
				String dimissReason = rs.getString("dimissReason");
				String dimissDate = rs.getString("dimissDate");

				DimissionInfo dimissionInfo = new DimissionInfo(id, stuffID1,
						stuffName, stuffDepart, stuffDuty, dimissInterface,
						dimissReason, dimissDate);
				dimissionInfos.add(dimissionInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close();
		}
		return dimissionInfos;
	}

	public int getTotalCount(String stuffID) {
		String sql = "select * from dimissioninfo where 1=1";
		List<Object> params = new ArrayList<Object>();
		if (stuffID != null && !"".equals(stuffID)) {
			sql = sql + " and stuffID like ?";
			params.add("%" + stuffID + "%");
		}

		int result = executeTotalCountForPages(sql, params);
		return this.executeTotalCountForPages(sql, params);
	}

	// 找所有部门信息
	public List<DimissionInfo> findAllDimissionInfos() {
		List<DimissionInfo> dimissionInfos = new ArrayList<DimissionInfo>();
		String query = "select * from dimissioninfo";
		ResultSet rs = this.executeQuery(query, null);
		// 将数据从rs中取出并封装成User对象
		try {
			while (rs.next()) {
				int id = rs.getInt("id");
				String stuffID1 = rs.getString("stuffID");
				String stuffName = rs.getString("stuffName");
				String stuffDepart = rs.getString("stuffDepart");
				String stuffDuty = rs.getString("stuffDuty");
				String dimissInterface = rs.getString("dimissInterface");
				String dimissReason = rs.getString("dimissReason");
				String dimissDate = rs.getString("dimissDate");

				DimissionInfo dimissionInfo = new DimissionInfo(id, stuffID1,
						stuffName, stuffDepart, stuffDuty, dimissInterface,
						dimissReason, dimissDate);
				dimissionInfos.add(dimissionInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close();
		}
		return dimissionInfos;
	}

	
	//根据条件返数据
			public List<DimissionInfo> findDimissionInfoByCondition(String stuffID,String stuffName,String stuffDepart) {
				List<DimissionInfo>dimissionInfos = new ArrayList<DimissionInfo>();
				List<Object> paramsTemp = new ArrayList<Object>();
				List<Object> params = new ArrayList<Object>();
								 
				 String	query ="";
				 ResultSet rs;
				 
				 if((stuffID!=""&&stuffID!=null)&&(stuffName!=""&&stuffName!=null)&&(stuffDepart!=""&&stuffDepart!=null)){
					 params.add(stuffID);		
					 params.add(stuffName);
					 params.add(stuffDepart);
					 paramsTemp=params;
					 
					 query = " select *  from  dimissioninfo  where stuffID = ? and stuffName = ? and stuffDepart =?";			
					
				 }
				 else  if((stuffID==""||stuffID==null)&&(stuffDepart==""||stuffDepart==null)&&(stuffName!=""&&stuffName!=null)){
					
					 params.add(stuffName);
					 paramsTemp=params;		
					 query="select *  from  dimissioninfo  where stuffName = ?";
				 }
				 else  if((stuffID==""||stuffID==null)&&(stuffName==""||stuffName==null)&&(stuffDepart!=""&&stuffDepart!=null)){
					
					 params.add(stuffDepart);
					 paramsTemp=params;
					 query="select *  from  dimissioninfo  where stuffDepart = ?";
				 }
				 else  if((stuffDepart==""||stuffDepart==null)&&(stuffName==""||stuffName==null)&&(stuffID!=""&&stuffID!=null)){
					 
					 params.add(stuffID);
					 paramsTemp=params;
					 query="select *  from  dimissioninfo  where stuffID = ?";
				 }
				 else  if((stuffID!=""||stuffID!=null)&&(stuffName!=""||stuffName!=null)&&(stuffDepart==""&&stuffDepart==null)){
					 params.add(stuffID);
					 params.add(stuffName);
					 paramsTemp=params;
					 query="select *  from  dimissioninfo  where stuffID = ? and stuffName = ?";
				 }
				 else  if((stuffID!=""||stuffID!=null)&&(stuffName==""||stuffName==null)&&(stuffDepart!=""&&stuffDepart!=null)){
					 
					 params.add(stuffID);
					 params.add(stuffDepart);
					 paramsTemp=params;
					 query="select *  from  dimissioninfo  where stuffID = ? and stuffDepart =?";
				 }
				 else  if((stuffID==""||stuffID==null)&&(stuffName!=""||stuffName!=null)&&(stuffDepart!=""&&stuffDepart!=null)){
					 
					 params.add(stuffName);
					 params.add(stuffDepart);
					 paramsTemp=params;
					 query="select *  from  dimissioninfo  where stuffName = ? and stuffDepart =?";
				 }
						 
				 rs = this.executeQuery(query, paramsTemp);
				 
				try {
					while(rs.next()){     
					        String stuffID1 = rs.getString("stuffID");	
							String stuffName1=rs.getString("stuffName");
							String stuffDepart1=rs.getString("stuffDepart");
							String stuffDuty=rs.getString("stuffDuty");	
							String dimissInterface=rs.getString("dimissInterface");
							String dimissDate=rs.getString("dimissDate");
							String dimissReason=rs.getString("dimissReason");
										
							DimissionInfo dimissionInfo = new DimissionInfo(stuffID1, stuffName1,stuffDepart1,stuffDuty,dimissInterface, dimissReason,dimissDate);
							dimissionInfos.add(dimissionInfo);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					this.close();
				}
				return dimissionInfos;
			}
		
		
		
		
	
	
	
	
	// 根据id返数据
	public DimissionInfo findDimissionInfoById(String stuffID) {

		List<Object> params = new ArrayList<Object>();
		params.add(stuffID);

		String query = " select * from dimissioninfo where stuffID=?";
		ResultSet rs = this.executeQuery(query, params);

		try {
			if (rs.next()) {
				int id = rs.getInt("id");
				String stuffID1 = rs.getString("stuffID");
				String stuffName = rs.getString("stuffName");
				String stuffDepart = rs.getString("stuffDepart");
				String stuffDuty = rs.getString("stuffDuty");
				String dimissInterface = rs.getString("dimissInterface");
				String dimissReason = rs.getString("dimissReason");
				String dimissDate = rs.getString("dimissDate");

				DimissionInfo dimissionInfo = new DimissionInfo(id, stuffID1,
						stuffName, stuffDepart, stuffDuty, dimissInterface,
						dimissReason, dimissDate);
				return dimissionInfo;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.close();
		}
		return null;
	}

	// 修改
	public int updateDimissionInfo(DimissionInfo dimissionInfo) {
		String update = " update dimissioninfo set stuffName=?,stuffDepart=?,stuffDuty=?,"
				+ "dimissInterface=?,dimissReason=?,dimissDate=? where stuffID=? ";
		List<Object> params = new ArrayList<Object>();
		// params.add(departmentInfo.getId());

		params.add(dimissionInfo.getStuffName());
		params.add(dimissionInfo.getStuffDepart());
		params.add(dimissionInfo.getStuffDuty());
		params.add(dimissionInfo.getDimissInterface());
		params.add(dimissionInfo.getDimissReason());
		params.add(dimissionInfo.getDimissDate());

		return this.executeUpdate(update, params);
	}

	// 删除部门
	public int delDimissionInfoId(String stuffID) {

		String sql = "delete from dimissioninfo where stuffID=?";
		List<Object> params = new ArrayList<Object>();
		params.add(stuffID);
		return this.executeUpdate(sql, params);
	}

	// 增加部门
	public int addDimissionInfo(DimissionInfo dimissionInfo) {
		int result = 0;
		String sql = " insert into dimissioninfo(stuffID,stuffName,stuffDepart,stuffDuty,dimissInterface,dimissReason,dimissDate) values (?,?,?,?,?,?,?)";
		List<Object> params = new ArrayList<Object>();
		params.add(dimissionInfo.getStuffID());
		params.add(dimissionInfo.getStuffName());
		params.add(dimissionInfo.getStuffDepart());
		params.add(dimissionInfo.getStuffDuty());
		params.add(dimissionInfo.getDimissInterface());
		params.add(dimissionInfo.getDimissReason());
		params.add(dimissionInfo.getDimissDate());
		result = this.executeUpdate(sql, params);
		return result;
	}

}
