package com.testbs.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.testbs.dao.BaseDao;
import com.testbs.entity.WorkLeaveInfo;


public class WorkLeaveInfoService extends BaseDao {
	// 分页
		public List<WorkLeaveInfo> getWorkLeaveInfoForPage(String stuffID,String stuffName,
				Integer pageNo, Integer pageSize) {
			String query = "select * from workleaveinfo where 1=1";
			List<Object> params = new ArrayList<Object>();
			// 搜索的条件
			if (stuffID != null && !"".equals(stuffID)) {
				query = query + " and stuffID like ?";
				params.add("%" + stuffID + "%");
			}
			if (stuffName != null && !"".equals(stuffName)) {
				query = query + " and stuffName like ?";
				params.add("%" + stuffName + "%");
			}
			params.add((pageNo - 1) * pageSize);
			params.add(pageSize);
			List<WorkLeaveInfo> workleaveInfos = new ArrayList<WorkLeaveInfo>();
			ResultSet rs = this.executeQueryForPages(query, params);
			try {
				while (rs.next()) {
					int id = rs.getInt("id");
					String stuffID1 = rs.getString("stuffID");
					String stuffName1 = rs.getString("stuffName");
					String stuffDepart = rs.getString("stuffDepart");
					String leaveBegin = rs.getString("leaveBegin");
					String leaveEnd = rs.getString("leaveEnd");
					double leaveHours=rs.getDouble("leaveHours");
					String leaveType = rs.getString("leaveType");
					String leaveReason = rs.getString("leaveReason");
					String approver = rs.getString("approver");
					double leaveMoney=rs.getDouble("leaveMoney");
					
					WorkLeaveInfo workleaveInfo = new WorkLeaveInfo(id,
							stuffID1, stuffName1, stuffDepart, leaveBegin,
							leaveEnd, leaveHours, leaveType,leaveReason,approver,leaveMoney);
					workleaveInfos.add(workleaveInfo);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				this.close();
			}
			return workleaveInfos;
		}

		public int getTotalCount(String stuffID) {
			String sql = "select * from workleaveinfo where 1=1";
			List<Object> params = new ArrayList<Object>();
			if (stuffID != null && !"".equals(stuffID)) {
				sql = sql + " and stuffID like ?";
				params.add("%" + stuffID + "%");
			}

			int result = executeTotalCountForPages(sql, params);
			return this.executeTotalCountForPages(sql, params);
		}

		// 找所有部门信息
		public List<WorkLeaveInfo> findAllWorkLeaveInfos() {
			List<WorkLeaveInfo> workleaveInfos = new ArrayList<WorkLeaveInfo>();
			String query = "select * from workleaveinfo";
			ResultSet rs = this.executeQuery(query, null);
			// 将数据从rs中取出并封装成User对象
			try {
				while (rs.next()) {
					int id = rs.getInt("id");
					String stuffID1 = rs.getString("stuffID");
					String stuffName = rs.getString("stuffName");
					String stuffDepart = rs.getString("stuffDepart");
					String leaveBegin = rs.getString("leaveBegin");
					String leaveEnd = rs.getString("leaveEnd");
					double leaveHours=rs.getDouble("leaveHours");
					String leaveType = rs.getString("leaveType");
					String leaveReason = rs.getString("leaveReason");
					String approver = rs.getString("approver");
					double leaveMoney=rs.getDouble("leaveMoney");

					WorkLeaveInfo workleaveInfo = new WorkLeaveInfo(id,
							stuffID1, stuffName, stuffDepart, leaveBegin,
							leaveEnd, leaveHours, leaveType,leaveReason,approver,leaveMoney);
					workleaveInfos.add(workleaveInfo);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				this.close();
			}
			return workleaveInfos;
		}
		//根据条件返数据
				public List<WorkLeaveInfo> findWorkLeaveInfoByCondition(String stuffID,String stuffName,String stuffDepart) {
					List<WorkLeaveInfo> workleaveInfos = new ArrayList<WorkLeaveInfo>();
					List<Object> paramsTemp = new ArrayList<Object>();
					List<Object> params = new ArrayList<Object>();
									 
					 String	query ="";
					 ResultSet rs;
					 
					 if((stuffID!=""&&stuffID!=null)&&(stuffName!=""&&stuffName!=null)&&(stuffDepart!=""&&stuffDepart!=null)){
						 params.add(stuffID);		
						 params.add(stuffName);
						 params.add(stuffDepart);
						 paramsTemp=params;
						 
						 query = " select *  from  workleaveinfo  where stuffID = ? and stuffName = ? and stuffDepart =?";			
						
					 }
					 else  if((stuffID==""||stuffID==null)&&(stuffDepart==""||stuffDepart==null)&&(stuffName!=""&&stuffName!=null)){
						
						 params.add(stuffName);
						 paramsTemp=params;		
						 query="select *  from  workleaveinfo  where stuffName = ?";
					 }
					 else  if((stuffID==""||stuffID==null)&&(stuffName==""||stuffName==null)&&(stuffDepart!=""&&stuffDepart!=null)){
						
						 params.add(stuffDepart);
						 paramsTemp=params;
						 query="select *  from  workleaveinfo  where stuffDepart = ?";
					 }
					 else  if((stuffDepart==""||stuffDepart==null)&&(stuffName==""||stuffName==null)&&(stuffID!=""&&stuffID!=null)){
						 
						 params.add(stuffID);
						 paramsTemp=params;
						 query="select *  from  workleaveinfo  where stuffID = ?";
					 }
					 else  if((stuffID!=""||stuffID!=null)&&(stuffName!=""||stuffName!=null)&&(stuffDepart==""&&stuffDepart==null)){
						 params.add(stuffID);
						 params.add(stuffName);
						 paramsTemp=params;
						 query="select *  from  workleaveinfo  where stuffID = ? and stuffName = ?";
					 }
					 else  if((stuffID!=""||stuffID!=null)&&(stuffName==""||stuffName==null)&&(stuffDepart!=""&&stuffDepart!=null)){
						 
						 params.add(stuffID);
						 params.add(stuffDepart);
						 paramsTemp=params;
						 query="select *  from  workleaveinfo  where stuffID = ? and stuffDepart =?";
					 }
					 else  if((stuffID==""||stuffID==null)&&(stuffName!=""||stuffName!=null)&&(stuffDepart!=""&&stuffDepart!=null)){
						 
						 params.add(stuffName);
						 params.add(stuffDepart);
						 paramsTemp=params;
						 query="select *  from  workleaveinfo  where stuffName = ? and stuffDepart =?";
					 }
							 
					 rs = this.executeQuery(query, paramsTemp);
					 
					try {
						while(rs.next()){     
							String stuffID1 = rs.getString("stuffID");
							String stuffName1 = rs.getString("stuffName");
							String stuffDepart1= rs.getString("stuffDepart");
							String leaveBegin = rs.getString("leaveBegin");
							String leaveEnd = rs.getString("leaveEnd");
							double leaveHours=rs.getDouble("leaveHours");
							String leaveReason = rs.getString("leaveReason");
							String approver = rs.getString("approver");
							double leaveMoney = rs.getDouble("leaveMoney");
											
							WorkLeaveInfo workleaveInfo = new WorkLeaveInfo(stuffID1,stuffName1,stuffDepart1,leaveBegin,leaveEnd,leaveHours,leaveReason,approver,leaveMoney);
							workleaveInfos.add(workleaveInfo);
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally{
						this.close();
					}
					return workleaveInfos;
				}

			
		// 根据id返数据
		public WorkLeaveInfo findWorkLeaveInfoById(String stuffID) {

			List<Object> params = new ArrayList<Object>();
			params.add(stuffID);

			String query = " select * from workleaveinfo where stuffID = ?";
			ResultSet rs = this.executeQuery(query, params);

			try {
				if (rs.next()) {
					int id = rs.getInt("id");
					String stuffID1 = rs.getString("stuffID");
					String stuffName = rs.getString("stuffName");
					String stuffDepart = rs.getString("stuffDepart");
					String leaveBegin = rs.getString("leaveBegin");
					String leaveEnd = rs.getString("leaveEnd");
					double leaveHours=rs.getDouble("leaveHours");
					String leaveType = rs.getString("leaveType");
					String leaveReason = rs.getString("leaveReason");
					String approver = rs.getString("approver");
					double leaveMoney=rs.getDouble("leaveMoney");

					WorkLeaveInfo workleaveInfo = new WorkLeaveInfo(id,
							stuffID1, stuffName, stuffDepart, leaveBegin,
							leaveEnd, leaveHours, leaveType,leaveReason,approver,leaveMoney);
					return workleaveInfo;
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
		public int updateWorkLeaveInfo(WorkLeaveInfo workleaveInfo) {
			String update = " update workleaveinfo set stuffName=?,stuffDepart=?,leaveBegin=?,leaveEnd=?,leaveHours=?,leaveType=?,leaveReason=?,approver=?,leaveMoney=? where stuffID=? ";
			List<Object> params = new ArrayList<Object>();
			// params.add(departmentInfo.getId());
			
			params.add(workleaveInfo.getStuffName());
			params.add(workleaveInfo.getStuffDepart());
			params.add(workleaveInfo.getLeaveBegin());
			params.add(workleaveInfo.getLeaveEnd());
			params.add(workleaveInfo.getLeaveHours());
			params.add(workleaveInfo.getLeaveType());
			params.add(workleaveInfo.getLeaveReason());
			params.add(workleaveInfo.getApprover());
			params.add(workleaveInfo.getLeaveMoney());
			params.add(workleaveInfo.getStuffID());
			return this.executeUpdate(update, params);
		}

		// 删除部门
		public int delWorkLeaveInfoId(String stuffID) {

			String sql = "delete from workleaveinfo where stuffID=?";
			List<Object> params = new ArrayList<Object>();
			params.add(stuffID);
			return this.executeUpdate(sql, params);
		}

		// 增加部门
		public int addWorkLeaveInfo(WorkLeaveInfo workleaveInfo) {
			int result = 0;
			String sql = " insert into workleaveinfo(stuffID,stuffName,stuffDepart,leaveBegin,leaveEnd,leaveHours,leaveType,leaveReason,approver,leaveMoney) values (?,?,?,?,?,?,?,?,?,?)";
			List<Object> params = new ArrayList<Object>();
			params.add(workleaveInfo.getStuffID());
			params.add(workleaveInfo.getStuffName());
			params.add(workleaveInfo.getStuffDepart());
			params.add(workleaveInfo.getLeaveBegin());
			params.add(workleaveInfo.getLeaveEnd());
			params.add(workleaveInfo.getLeaveHours());
			params.add(workleaveInfo.getLeaveType());
			params.add(workleaveInfo.getLeaveReason());
			params.add(workleaveInfo.getApprover());
			params.add(workleaveInfo.getLeaveMoney());
			result = this.executeUpdate(sql, params);
			return result;
		}

	}
