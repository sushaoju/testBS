package com.testbs.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

import com.testbs.dao.BaseDao;

import com.testbs.entity.OverWorkInfo;

public class OverWorkInfoService extends BaseDao {
	// 分页
	public List<OverWorkInfo> getOverWorkInfoForPage(String stuffID,
			Integer pageNo, Integer pageSize) {
		String query = "select *  from overworkinfo where 1=1";
		List<Object> params = new ArrayList<Object>();
		// 搜索的条件
		if (stuffID != null && !"".equals(stuffID)) {
			query = query + " and stuffID like ?";
			params.add("%" + stuffID + "%");
		}

		params.add((pageNo - 1) * pageSize);
		params.add(pageSize);
		List<OverWorkInfo> overworkInfos = new ArrayList<OverWorkInfo>();
		ResultSet rs = this.executeQueryForPages(query, params);
		try {
			while (rs.next()) {
				int id = rs.getInt("id");
				String stuffID1 = rs.getString("stuffID");
				String stuffName = rs.getString("stuffName");
				String stuffDepart = rs.getString("stuffDepart");

				String overworkStart = rs.getString("overworkStart");
				String overworkEnd = rs.getString("overworkEnd");
				double overworkHours = rs.getDouble("overworkHours");
				String overworkReason = rs.getString("overworkReason");
				double overworkMoney = rs.getDouble("overworkMoney");
				String overworkApprover = rs.getString("overworkApprover");
				OverWorkInfo overworkInfo = new OverWorkInfo(id, stuffID1,
						stuffName, stuffDepart, overworkStart, overworkEnd,
						overworkHours, overworkReason, overworkMoney,
						overworkApprover);
				overworkInfos.add(overworkInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close();
		}
		return overworkInfos;
	}

	public int getTotalCount(String stuffID) {
		String sql = "select *  from overworkinfo where 1=1";
		List<Object> params = new ArrayList<Object>();
		if (stuffID != null && !"".equals(stuffID)) {
			sql = sql + " and stuffID like ?";
			params.add("%" + stuffID + "%");
		}

		int result = executeTotalCountForPages(sql, params);
		return this.executeTotalCountForPages(sql, params);
	}

	// 找所有部门信息
	public List<OverWorkInfo> findAllOverWorkInfos() {
		List<OverWorkInfo> overworkInfos = new ArrayList<OverWorkInfo>();
		String query = "select *  from overworkinfo";
		ResultSet rs = this.executeQuery(query, null);
		// 将数据从rs中取出并封装成User对象
		try {
			while (rs.next()) {
				int id = rs.getInt("id");
				String stuffID1 = rs.getString("stuffID");
				String stuffName = rs.getString("stuffName");
				String stuffDepart = rs.getString("stuffDepart");
				String overworkStart = rs.getString("overworkStart");
				String overworkEnd = rs.getString("overworkEnd");
				double overworkHours = rs.getDouble("overworkHours");
				String overworkReason = rs.getString("overworkReason");
				double overworkMoney = rs.getDouble("overworkMoney");
				String overworkApprover = rs.getString("overworkApprover");

				OverWorkInfo overworkInfo = new OverWorkInfo(id, stuffID1,
						stuffName, stuffDepart, overworkStart, overworkEnd,
						overworkHours, overworkReason, overworkMoney,
						overworkApprover);
				overworkInfos.add(overworkInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close();
		}
		return overworkInfos;
	}

	// 根据id返数据
	public OverWorkInfo findOverWorkInfoById(String stuffID) {

		List<Object> params = new ArrayList<Object>();
		params.add(stuffID);

		String query = " select *  from  overworkinfo where stuffID = ?";
		ResultSet rs = this.executeQuery(query, params);

		try {
			if (rs.next()) {
				int id = rs.getInt("id");
				String stuffID1 = rs.getString("stuffID");
				String stuffName = rs.getString("stuffName");
				String stuffDepart = rs.getString("stuffDepart");
				String overworkStart = rs.getString("overworkStart");
				String overworkEnd = rs.getString("overworkEnd");
				double overworkHours = rs.getDouble("overworkHours");
				String overworkReason = rs.getString("overworkReason");
				double overworkMoney = rs.getDouble("overworkMoney");
				String overworkApprover = rs.getString("overworkApprover");

				OverWorkInfo overworkInfo = new OverWorkInfo(id, stuffID1,
						stuffName, stuffDepart, overworkStart, overworkEnd,
						overworkHours, overworkReason, overworkMoney,
						overworkApprover);
				return overworkInfo;
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
	public int updateOverWorkInfo(OverWorkInfo overworkInfo) {
		String update = " update overworkinfo set stuffName = ?,stuffDepart = ?,"
				+ "overworkStart=?,overworkEnd=?,overworkHours=?,overworkReason=?,overworkMoney=?,overworkApprover=? where stuffID = ? ";
		List<Object> params = new ArrayList<Object>();
		// params.add(departmentInfo.getId());

		params.add(overworkInfo.getStuffName());
		params.add(overworkInfo.getStuffDepart());
		params.add(overworkInfo.getOverworkStart());
		params.add(overworkInfo.getOverworkEnd());
		params.add(overworkInfo.getOverworkHours());
		params.add(overworkInfo.getOverworkReason());
		params.add(overworkInfo.getOverworkMoney());
		params.add(overworkInfo.getOverworkApprover());
		return this.executeUpdate(update, params);
	}

	// 删除部门
	public int delOverWorkInfoId(String stuffID) {

		String sql = "delete from overworkinfo where stuffID= ?";
		List<Object> params = new ArrayList<Object>();
		params.add(stuffID);
		return this.executeUpdate(sql, params);
	}

	// 增加部门
	public int addOverWorkInfo(OverWorkInfo overworkInfo) {
		int result = 0;
		String sql = " insert into overworktinfo(stuffID,stuffName,stuffDepart,overworkStart,overworkEnd,"
				+ "overworkHours,overworkReason,overworkMoney,overworkApprover) values (?,?,?,?,?,?,?,?,?)";
		List<Object> params = new ArrayList<Object>();
		params.add(overworkInfo.getStuffID());
		params.add(overworkInfo.getStuffName());
		params.add(overworkInfo.getStuffDepart());
		params.add(overworkInfo.getOverworkStart());
		params.add(overworkInfo.getOverworkEnd());
		params.add(overworkInfo.getOverworkHours());
		params.add(overworkInfo.getOverworkReason());
		params.add(overworkInfo.getOverworkMoney());
		params.add(overworkInfo.getOverworkApprover());
		result = this.executeUpdate(sql, params);
		return result;
	}

}