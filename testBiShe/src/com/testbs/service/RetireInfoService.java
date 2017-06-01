package com.testbs.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.testbs.dao.BaseDao;
import com.testbs.entity.RetireInfo;


public class RetireInfoService extends BaseDao {
	// 分页
		public List<RetireInfo> getRetireInfoForPage(String stuffID,String stuffName,
				Integer pageNo, Integer pageSize) {
			String query = "select * from retireinfo where 1=1";
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
			List<RetireInfo> retireInfos = new ArrayList<RetireInfo>();
			ResultSet rs = this.executeQueryForPages(query, params);
			try {
				while (rs.next()) {
					int id = rs.getInt("id");
					String stuffID1 = rs.getString("stuffID");
					String stuffName1 = rs.getString("stuffName");
					String stuffDepart = rs.getString("stuffDepart");
					String stuffDuty = rs.getString("stuffDuty");
					String stuffEntryDate = rs.getString("stuffEntryDate");
					String retireDate = rs.getString("retireDate");
					String retireInterface = rs.getString("retireInterface");
					double retireMoney=rs.getDouble("retireMoney");
              
					RetireInfo retireInfo = new RetireInfo(id,stuffID1,
							stuffName1, stuffDepart, stuffDuty, stuffEntryDate,
							retireDate, retireInterface,retireMoney);
					retireInfos.add(retireInfo);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				this.close();
			}
			return retireInfos;
		}

		public int getTotalCount(String stuffID) {
			String sql = "select *  from retireinfo where 1=1";
			List<Object> params = new ArrayList<Object>();
			if (stuffID != null && !"".equals(stuffID)) {
				sql = sql + " and stuffID like ?";
				params.add("%" + stuffID + "%");
			}

			int result = executeTotalCountForPages(sql, params);
			return this.executeTotalCountForPages(sql, params);
		}

		// 找所有部门信息
		public List<RetireInfo> findAllRetireInfos() {
			List<RetireInfo> retireInfos = new ArrayList<RetireInfo>();
			String query = "select *  from retireinfo";
			ResultSet rs = this.executeQuery(query, null);
			// 将数据从rs中取出并封装成User对象
			try {
				while (rs.next()) {
					int id = rs.getInt("id");
					String stuffID1 = rs.getString("stuffID");
					String stuffName = rs.getString("stuffName");
					String stuffDepart = rs.getString("stuffDepart");
					String stuffDuty = rs.getString("stuffDuty");
					String stuffEntryDate = rs.getString("stuffEntryDate");
					String retireDate = rs.getString("retireDate");
					String retireInterface = rs.getString("retireInterface");
					double retireMoney=rs.getDouble("retireMoney");

					RetireInfo retireInfo = new RetireInfo(id, stuffID1,
							stuffName, stuffDepart, stuffDuty,stuffEntryDate,
							retireDate, retireInterface,retireMoney);
					retireInfos.add(retireInfo);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				this.close();
			}
			return retireInfos;
		}

		//根据条件返数据
		public List<RetireInfo> findRetireInfoByCondition(String stuffID,String stuffName) {
			List<RetireInfo> retireInfos = new ArrayList<RetireInfo>();
			List<Object> paramsTemp = new ArrayList<Object>();
			List<Object> params = new ArrayList<Object>();
							 
			 String	query ="";
			 ResultSet rs;
			 
			 if((stuffID!=""&&stuffID!=null)&&(stuffName!=""&&stuffName!=null)){
				 params.add(stuffID);		
				 params.add(stuffName);
			
				 paramsTemp=params;
				 
				 query = " select *  from  retireinfo  where stuffID = ? and stuffName = ? ";			
				
			 }
			 else  if((stuffID==""||stuffID==null)&&(stuffName!=""&&stuffName!=null)){
				
				 params.add(stuffName);
				 paramsTemp=params;		
				 query="select *  from  retireinfo  where stuffName = ?";
			 }
			 else  if((stuffName==""||stuffName==null)&&(stuffID!=""&&stuffID!=null)){
				 
				 params.add(stuffID);
				 paramsTemp=params;
				 query="select *  from  retireinfo  where stuffID = ?";
			 }
							 
			 rs = this.executeQuery(query, paramsTemp);
			 
			try {
				while(rs.next()){     
				        String stuffID1 = rs.getString("stuffID");	
						String stuffName1=rs.getString("stuffName");
						String stuffDepart=rs.getString("stuffDepart");
						String stuffDuty=rs.getString("stuffDuty");	
						String stuffEntryDate=rs.getString("stuffEntryDate");
						String retireDate=rs.getString("retireDate");
						String retireInterface=rs.getString("retireInterface");
						double retireMoney=rs.getDouble("retireMoney");
									
						RetireInfo retireInfo = new RetireInfo(stuffID1, stuffName1,stuffDepart,stuffDuty,stuffEntryDate,
								retireDate, retireInterface,retireMoney);
						retireInfos.add(retireInfo);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				this.close();
			}
			return retireInfos;
		}
		// 根据id返数据
		public RetireInfo findRetireInfoById(String stuffID) {

			List<Object> params = new ArrayList<Object>();
			params.add(stuffID);

			String query = " select * from retireinfo where stuffID = ?";
			ResultSet rs = this.executeQuery(query, params);

			try {
				if (rs.next()) {
					int id = rs.getInt("id");
					String stuffID1 = rs.getString("stuffID");
					String stuffName = rs.getString("stuffName");
					String stuffDepart = rs.getString("stuffDepart");
					String stuffDuty = rs.getString("stuffDuty");
					String stuffEntryDate = rs.getString("stuffEntryDate");
					String retireDate = rs.getString("retireDate");
					String retireInterface = rs.getString("retireInterface");
					double retireMoney=rs.getDouble("retireMoney");
					RetireInfo retireInfo = new RetireInfo(id, stuffID1,
							stuffName, stuffDepart, stuffDuty, stuffEntryDate,
							retireDate, retireInterface,retireMoney);
					return retireInfo;
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
		public int updateRetireInfo(RetireInfo retireInfo) {
			String update = " update retireinfo set stuffName = ?,stuffDepart = ?,stuffDuty=?,"
					+ "stuffEntryDate=?,retireDate=?,retireInterface=?,retireMoney=? where stuffID = ? ";
			List<Object> params = new ArrayList<Object>();
			// params.add(departmentInfo.getId());
			
			params.add(retireInfo.getStuffName());
			params.add(retireInfo.getStuffDepart());
			params.add(retireInfo.getStuffDuty());
			params.add(retireInfo.getStuffEntryDate());
			params.add(retireInfo.getRetireDate());
			params.add(retireInfo.getRetireInterface());
			params.add(retireInfo.getRetireMoney());
			params.add(retireInfo.getStuffID());

			return this.executeUpdate(update, params);
		}

		// 删除部门
		public int delRetireInfoId(String stuffID) {

			String sql = "delete from retireinfo where stuffID= ?";
			List<Object> params = new ArrayList<Object>();
			params.add(stuffID);
			return this.executeUpdate(sql, params);
		}

		// 增加部门
		public int addRetireInfo(RetireInfo retireInfo) {
			int result = 0;
			String sql = " insert into retireinfo(stuffID,stuffName,stuffDepart,stuffDuty,stuffEntryDate,retireDate,retireInterface,retireMoney) values (?,?,?,?,?,?,?,?)";
			List<Object> params = new ArrayList<Object>();
			params.add(retireInfo.getStuffID());
			params.add(retireInfo.getStuffName());
			params.add(retireInfo.getStuffDepart());
			params.add(retireInfo.getStuffDuty());
			params.add(retireInfo.getStuffEntryDate());
			params.add(retireInfo.getRetireDate());
			params.add(retireInfo.getRetireInterface());
			params.add(retireInfo.getRetireMoney());
			result = this.executeUpdate(sql, params);
			return result;
		}

	}
