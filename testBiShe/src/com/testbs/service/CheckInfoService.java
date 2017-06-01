package com.testbs.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

import com.testbs.dao.BaseDao;

import com.testbs.entity.CheckInfo;
import com.testbs.entity.TrainInfo;

public class CheckInfoService extends BaseDao {
	// 分页
	public List<CheckInfo> getCheckInfoForPage(String stuffID, Integer pageNo,
			Integer pageSize) {
		String query = "select *  from checkinfo where 1=1";
		List<Object> params = new ArrayList<Object>();
		// 搜索的条件
		if (stuffID != null && !"".equals(stuffID)) {
			query = query + " and stuffID like ?";
			params.add("%" + stuffID + "%");
		}

		params.add((pageNo - 1) * pageSize);
		params.add(pageSize);
		List<CheckInfo> checkInfos = new ArrayList<CheckInfo>();
		ResultSet rs = this.executeQueryForPages(query, params);
		try {
			while (rs.next()) {
				int id = rs.getInt("id");
				String stuffID1 = rs.getString("stuffID");
				String stuffName = rs.getString("stuffName");
				String stuffDepart = rs.getString("stuffDepart");
				String stuffShift = rs.getString("stuffShift");
				double workHour = rs.getDouble("workHour");
				String workDate = rs.getString("workDate");
				double lateHour = rs.getDouble("lateHour");
				double absentHour = rs.getDouble("absentHour");

				CheckInfo checkInfo = new CheckInfo(id, stuffID1, stuffName,
						stuffDepart, stuffShift, workHour, workDate, lateHour,
						absentHour);
				checkInfos.add(checkInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close();
		}
		return checkInfos;
	}

	public int getTotalCount(String stuffID) {
		String sql = "select *  from checkinfo where 1=1";
		List<Object> params = new ArrayList<Object>();
		if (stuffID != null && !"".equals(stuffID)) {
			sql = sql + " and stuffID like ?";
			params.add("%" + stuffID + "%");
		}

		int result = executeTotalCountForPages(sql, params);
		return this.executeTotalCountForPages(sql, params);
	}

	// 找所有部门信息
	public List<CheckInfo> findAllCheckInfos() {
		List<CheckInfo> checkInfos = new ArrayList<CheckInfo>();
		String query = "select *  from checkinfo";
		ResultSet rs = this.executeQuery(query, null);
		// 将数据从rs中取出并封装成User对象
		try {
			while (rs.next()) {
				int id = rs.getInt("id");
				String stuffID1 = rs.getString("stuffID");
				String stuffName = rs.getString("stuffName");
				String stuffDepart = rs.getString("stuffDepart");
				String stuffShift = rs.getString("stuffShift");
				double workHour = rs.getDouble("workHour");
				String workDate = rs.getString("workDate");
				double lateHour = rs.getDouble("lateHour");
				double absentHour = rs.getDouble("absentHour");
				CheckInfo checkInfo = new CheckInfo(id, stuffID1, stuffName,
						stuffDepart, stuffShift, workHour, workDate, lateHour,
						absentHour);
				checkInfos.add(checkInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close();
		}
		return checkInfos;
	}

	
	//根据条件返数据
		public List<CheckInfo> findCheckInfoByCondition(String stuffID,String stuffName,String stuffDepart) {
			List<CheckInfo>  checkInfos = new ArrayList<CheckInfo>();
			List<Object> paramsTemp = new ArrayList<Object>();
			List<Object> params = new ArrayList<Object>();
							 
			 String	query ="";
			 ResultSet rs;
			 
			 if((stuffID!=""&&stuffID!=null)&&(stuffName!=""&&stuffName!=null)&&(stuffDepart!=""&&stuffDepart!=null)){
				 params.add(stuffID);		
				 params.add(stuffName);
				 params.add(stuffDepart);
				 paramsTemp=params;
				 
				 query = " select *  from  checkinfo  where stuffID = ? and stuffName = ? and stuffDepart =?";			
				
			 }
			 else  if((stuffID==""||stuffID==null)&&(stuffDepart==""||stuffDepart==null)&&(stuffName!=""&&stuffName!=null)){
				
				 params.add(stuffName);
				 paramsTemp=params;		
				 query="select *  from  checkinfo  where stuffName = ?";
			 }
			 else  if((stuffID==""||stuffID==null)&&(stuffName==""||stuffName==null)&&(stuffDepart!=""&&stuffDepart!=null)){
				
				 params.add(stuffDepart);
				 paramsTemp=params;
				 query="select *  from  checkinfo  where stuffDepart = ?";
			 }
			 else  if((stuffDepart==""||stuffDepart==null)&&(stuffName==""||stuffName==null)&&(stuffID!=""&&stuffID!=null)){
				 
				 params.add(stuffID);
				 paramsTemp=params;
				 query="select *  from  checkinfo  where stuffID = ?";
			 }
			 else  if((stuffID!=""||stuffID!=null)&&(stuffName!=""||stuffName!=null)&&(stuffDepart==""&&stuffDepart==null)){
				 params.add(stuffID);
				 params.add(stuffName);
				 paramsTemp=params;
				 query="select *  from  checkinfo  where stuffID = ? and stuffName = ?";
			 }
			 else  if((stuffID!=""||stuffID!=null)&&(stuffName==""||stuffName==null)&&(stuffDepart!=""&&stuffDepart!=null)){
				 
				 params.add(stuffID);
				 params.add(stuffDepart);
				 paramsTemp=params;
				 query="select *  from  checkinfo  where stuffID = ? and stuffDepart =?";
			 }
			 else  if((stuffID==""||stuffID==null)&&(stuffName!=""||stuffName!=null)&&(stuffDepart!=""&&stuffDepart!=null)){
				 
				 params.add(stuffName);
				 params.add(stuffDepart);
				 paramsTemp=params;
				 query="select *  from  checkinfo  where stuffName = ? and stuffDepart =?";
			 }
					 
			 rs = this.executeQuery(query, paramsTemp);
			 
			try {
				while(rs.next()){     
				        String stuffID1 = rs.getString("stuffID");	
						String stuffName1=rs.getString("stuffName");
						String stuffDepart1=rs.getString("stuffDepart");
						String stuffShift=rs.getString("stuffShift");
						Double workHour=rs.getDouble("workHour");
						String workDate=rs.getString("workDate");
						Double lateHour=rs.getDouble("lateHour");
						Double absentHour=rs.getDouble("absentHour");
									
						CheckInfo checkInfo = new CheckInfo(stuffID1,stuffName1,stuffDepart1,stuffShift,workHour,workDate,lateHour,absentHour);
						checkInfos.add(checkInfo);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				this.close();
			}
			return checkInfos;
		}

		
	
	
	
	// 根据id返数据
	public CheckInfo findCheckInfoById(String stuffID) {

		List<Object> params = new ArrayList<Object>();
		params.add(stuffID);

		String query = " select *  from  checkinfo where stuffID = ?";
		ResultSet rs = this.executeQuery(query, params);

		try {
			if (rs.next()) {
				int id = rs.getInt("id");
				String stuffID1 = rs.getString("stuffID");
				String stuffName = rs.getString("stuffName");
				String stuffDepart = rs.getString("stuffDepart");
				String stuffShift = rs.getString("stuffShift");
				double workHour = rs.getDouble("workHour");
				String workDate = rs.getString("workDate");
				double lateHour = rs.getDouble("lateHour");
				double absentHour = rs.getDouble("absentHour");
				CheckInfo checkInfo = new CheckInfo(id, stuffID1, stuffName,
						stuffDepart, stuffShift, workHour, workDate, lateHour,
						absentHour);
				return checkInfo;
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
	public int updateCheckInfo(CheckInfo checkInfo) {
		String update = " update checkinfo set stuffName = ?,stuffDepart = ?,stuffShift=?,workHour=?,workDate=?,lateHour=?,absentHour=? where stuffID = ? ";
		List<Object> params = new ArrayList<Object>();
		// params.add(departmentInfo.getId());

		params.add(checkInfo.getStuffName());
		params.add(checkInfo.getStuffDepart());
		params.add(checkInfo.getStuffShift());
		params.add(checkInfo.getWorkHour());
		params.add(checkInfo.getWorkDate());
		params.add(checkInfo.getLateHour());
		params.add(checkInfo.getAbsentHour());
		params.add(checkInfo.getStuffID());

		return this.executeUpdate(update, params);
	}

	// 删除部门
	public int delCheckInfoId(String stuffID) {

		String sql = "delete from checkinfo where stuffID= ?";
		List<Object> params = new ArrayList<Object>();
		params.add(stuffID);
		return this.executeUpdate(sql, params);
	}

	// 增加部门
	public int addCheckInfo(CheckInfo checkInfo) {
		int result = 0;
		String sql = " insert into checkinfo(stuffID,stuffName,stuffDepart,stuffShift,workHour,workDate,lateHour,absentHour) values (?,?,?,?,?,?,?,?)";
		List<Object> params = new ArrayList<Object>();
		params.add(checkInfo.getStuffID());
		params.add(checkInfo.getStuffName());
		params.add(checkInfo.getStuffDepart());
		params.add(checkInfo.getStuffShift());
		params.add(checkInfo.getWorkHour());
		params.add(checkInfo.getWorkDate());
		params.add(checkInfo.getLateHour());
		params.add(checkInfo.getAbsentHour());
		result = this.executeUpdate(sql, params);
		return result;
	}

}
