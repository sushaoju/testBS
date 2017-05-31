package com.testbs.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

import com.testbs.dao.BaseDao;
import com.testbs.entity.AdjustRestInfo;

public class AdjustRestInfoService extends BaseDao {
	// 分页
	public List<AdjustRestInfo> getAdjustRestInfoForPage(String stuffID,
			Integer pageNo, Integer pageSize) {
		String query = "select * from adjustrestinfo where 1=1";
		List<Object> params = new ArrayList<Object>();
		// 搜索的条件
		if (stuffID != null && !"".equals(stuffID)) {
			query = query + " and stuffID like ?";
			params.add("%" + stuffID + "%");
		}

		params.add((pageNo - 1) * pageSize);
		params.add(pageSize);
		List<AdjustRestInfo> adjustrestInfos = new ArrayList<AdjustRestInfo>();
		ResultSet rs = this.executeQueryForPages(query, params);
		try {
			while (rs.next()) {
				int id = rs.getInt("id");
				String stuffID1 = rs.getString("stuffID");
				String stuffName = rs.getString("stuffName");
				String stuffDepart = rs.getString("stuffDepart");
				String adjustType = rs.getString("adjustType");
				String adjustBefore = rs.getString("adjustBefore");
				String adjustAfter = rs.getString("adjustAfter");
				String adjustApprover = rs.getString("adjustApprover");

				AdjustRestInfo adjustrestInfo = new AdjustRestInfo(id,
						stuffID1, stuffName, stuffDepart, adjustType,
						adjustBefore, adjustAfter, adjustApprover);
				adjustrestInfos.add(adjustrestInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close();
		}
		return adjustrestInfos;
	}

	public int getTotalCount(String stuffID) {
		String sql = "select * from adjustrestinfo where 1=1";
		List<Object> params = new ArrayList<Object>();
		if (stuffID != null && !"".equals(stuffID)) {
			sql = sql + " and stuffID like ?";
			params.add("%" + stuffID + "%");
		}

		int result = executeTotalCountForPages(sql, params);
		return this.executeTotalCountForPages(sql, params);
	}

	// 找所有部门信息
	public List<AdjustRestInfo> findAllAdjustRestInfos() {
		List<AdjustRestInfo> adjustrestInfos = new ArrayList<AdjustRestInfo>();
		String query = "select * from adjustrestinfo";
		ResultSet rs = this.executeQuery(query, null);
		// 将数据从rs中取出并封装成User对象
		try {
			while (rs.next()) {
				int id = rs.getInt("id");
				String stuffID1 = rs.getString("stuffID");
				String stuffName = rs.getString("stuffName");
				String stuffDepart = rs.getString("stuffDepart");
				String adjustType = rs.getString("adjustType");
				String adjustBefore = rs.getString("adjustBefore");
				String adjustAfter = rs.getString("adjustAfter");
				String adjustApprover = rs.getString("adjustApprover");

				AdjustRestInfo adjustrestInfo = new AdjustRestInfo(id,
						stuffID1, stuffName, stuffDepart, adjustType,
						adjustBefore, adjustAfter, adjustApprover);
				adjustrestInfos.add(adjustrestInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close();
		}
		return adjustrestInfos;
	}

	// 根据id返数据
	public AdjustRestInfo findAdjustRestInfoById(String stuffID) {

		List<Object> params = new ArrayList<Object>();
		params.add(stuffID);

		String query = " select * from adjustrestinfo where stuffID = ?";
		ResultSet rs = this.executeQuery(query, params);

		try {
			if (rs.next()) {
				int id = rs.getInt("id");
				String stuffID1 = rs.getString("stuffID");
				String stuffName = rs.getString("stuffName");
				String stuffDepart = rs.getString("stuffDepart");
				String adjustType = rs.getString("adjustType");
				String adjustBefore = rs.getString("adjustBefore");
				String adjustAfter = rs.getString("adjustAfter");
				String adjustApprover = rs.getString("adjustApprover");

				AdjustRestInfo adjustrestInfo = new AdjustRestInfo(id,
						stuffID1, stuffName, stuffDepart, adjustType,
						adjustBefore, adjustAfter, adjustApprover);
				return adjustrestInfo;
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
	public int updateAdjustRestInfo(AdjustRestInfo adjustrestInfo) {
		String update = " update adjustrestinfo set stuffName=?,stuffDepart=?,adjustType=?,adjustBefore=?,adjustAfter=?,adjustApprover=? where stuffID=? ";
		List<Object> params = new ArrayList<Object>();
		// params.add(departmentInfo.getId());

		params.add(adjustrestInfo.getStuffName());
		params.add(adjustrestInfo.getStuffDepart());
		params.add(adjustrestInfo.getAdjustType());
		params.add(adjustrestInfo.getAdjustBefore());
		params.add(adjustrestInfo.getAdjustAfter());
		params.add(adjustrestInfo.getAdjustApprover());
		return this.executeUpdate(update, params);
	}

	// 删除部门
	public int delAdjustRestInfoId(String stuffID) {

		String sql = "delete from adjustrestinfo where stuffID=?";
		List<Object> params = new ArrayList<Object>();
		params.add(stuffID);
		return this.executeUpdate(sql, params);
	}

	// 增加部门
	public int addAdjustRestInfo(AdjustRestInfo adjustrestInfo) {
		int result = 0;
		String sql = " insert into adjustrestinfo(stuffID,stuffName,stuffDepart,adjustType,adjustBefore,adjustAfter,adjustApprover) values (?,?,?,?,?,?,?)";
		List<Object> params = new ArrayList<Object>();
		params.add(adjustrestInfo.getStuffID());
		params.add(adjustrestInfo.getStuffName());
		params.add(adjustrestInfo.getStuffDepart());
		params.add(adjustrestInfo.getAdjustType());
		params.add(adjustrestInfo.getAdjustBefore());
		params.add(adjustrestInfo.getAdjustAfter());
		params.add(adjustrestInfo.getAdjustApprover());
		result = this.executeUpdate(sql, params);
		return result;
	}

}
