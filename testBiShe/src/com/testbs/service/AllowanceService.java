package com.testbs.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

import com.testbs.dao.BaseDao;

import com.testbs.entity.allowance;

public class AllowanceService extends BaseDao {
	// 分页
	public List<allowance> getAllowanceForPage(String stuffID, Integer pageNo,
			Integer pageSize) {
		String query = "select * from allowance where 1=1";
		List<Object> params = new ArrayList<Object>();
		// 搜索的条件
		if (stuffID != null && !"".equals(stuffID)) {
			query = query + " and stuffID like ?";
			params.add("%" + stuffID + "%");
		}

		params.add((pageNo - 1) * pageSize);
		params.add(pageSize);
		List<allowance> allowanceInfos = new ArrayList<allowance>();
		ResultSet rs = this.executeQueryForPages(query, params);
		try {
			while (rs.next()) {
				int id = rs.getInt("id");
				String stuffID1 = rs.getString("stuffID");
				String stuffName = rs.getString("stuffName");
				String stuffDepart = rs.getString("stuffDepart");
				int allowanceMonth = rs.getInt("allowanceMonth");
				double transAwce = rs.getDouble("transAwce");
				double foodAwce = rs.getDouble("foodAwce");
				double houseAwce = rs.getDouble("houseAwce");
				double cmuAwce = rs.getDouble("cmuAwce");
				double accountAwce = rs.getDouble("accountAwce");

				allowance allowanceInfo = new allowance(id, stuffID1,
						stuffName, stuffDepart, allowanceMonth, transAwce,
						foodAwce, houseAwce, cmuAwce, accountAwce);
				allowanceInfos.add(allowanceInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close();
		}
		return allowanceInfos;
	}

	public int getTotalCount(String stuffID) {
		String sql = "select * from allowance where 1=1";
		List<Object> params = new ArrayList<Object>();
		if (stuffID != null && !"".equals(stuffID)) {
			sql = sql + " and stuffID like ?";
			params.add("%" + stuffID + "%");
		}

		int result = executeTotalCountForPages(sql, params);
		return this.executeTotalCountForPages(sql, params);
	}

	// 找所有部门信息
	public List<allowance> findAllAllowanceInfos() {
		List<allowance> allowanceInfos = new ArrayList<allowance>();
		String query = "select * from allowance";
		ResultSet rs = this.executeQuery(query, null);
		// 将数据从rs中取出并封装成User对象
		try {
			while (rs.next()) {
				int id = rs.getInt("id");
				String stuffID1 = rs.getString("stuffID");
				String stuffName = rs.getString("stuffName");
				String stuffDepart = rs.getString("stuffDepart");
				int allowanceMonth = rs.getInt("allowanceMonth");
				double transAwce = rs.getDouble("transAwce");
				double foodAwce = rs.getDouble("foodAwce");
				double houseAwce = rs.getDouble("houseAwce");
				double cmuAwce = rs.getDouble("cmuAwce");
				double accountAwce = rs.getDouble("accountAwce");

				allowance allowanceInfo = new allowance(id, stuffID1,
						stuffName, stuffDepart, allowanceMonth, transAwce,
						foodAwce, houseAwce, cmuAwce, accountAwce);
				allowanceInfos.add(allowanceInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close();
		}
		return allowanceInfos;
	}

	// 根据id返数据
	public allowance findAllowanceInfoById(String stuffID) {

		List<Object> params = new ArrayList<Object>();
		params.add(stuffID);

		String query = " select * from allowance where stuffID=?";
		ResultSet rs = this.executeQuery(query, params);

		try {
			if (rs.next()) {
				int id = rs.getInt("id");
				String stuffID1 = rs.getString("stuffID");
				String stuffName = rs.getString("stuffName");
				String stuffDepart = rs.getString("stuffDepart");
				int allowanceMonth = rs.getInt("allowanceMonth");
				double tranceAwce = rs.getDouble("tranceAwce");
				double foodAwce = rs.getDouble("foodAwce");
				double houseAwce = rs.getDouble("houseAwce");
				double cmuAwce = rs.getDouble("cmuAwce");
				double accountAwce = rs.getDouble("accountAwce");

				allowance allwanceInfo = new allowance(id, stuffID1, stuffName,
						stuffDepart, allowanceMonth, tranceAwce, foodAwce,
						houseAwce, cmuAwce, accountAwce);
				return allwanceInfo;
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
	public int updateAllowance(allowance allowanceInfo) {
		String update = " update allowance set stuffName=?,stuffDepart=?,allowanceMonth=?,transAwce=?,foodAwce=?,houseAwce=?,cmuAwce=? where stuffID=? ";
		List<Object> params = new ArrayList<Object>();
		// params.add(departmentInfo.getId());

		params.add(allowanceInfo.getStuffName());
		params.add(allowanceInfo.getStuffDepart());
		params.add(allowanceInfo.getAllowanceMonth());
		params.add(allowanceInfo.getTransAwce());
		params.add(allowanceInfo.getFoodAwce());
		params.add(allowanceInfo.getHouseAwce());
		params.add(allowanceInfo.getCmuAwce());
		return this.executeUpdate(update, params);
	}

	// 删除部门
	public int delAllowanceId(String stuffID) {

		String sql = "delete from allowance where stuffID=?";
		List<Object> params = new ArrayList<Object>();
		params.add(stuffID);
		return this.executeUpdate(sql, params);
	}

	// 增加部门
	public int addAllowance(allowance allowanceInfo) {
		int result = 0;
		String sql = " insert into allowance(stuffID,stuffName,stuffDepart,allowanceMonth,tranceAwce,foodAwce,houseAwce,cmuAwce) values (?,?,?,?,?,?,?,?)";
		List<Object> params = new ArrayList<Object>();
		params.add(allowanceInfo.getStuffID());
		params.add(allowanceInfo.getStuffName());
		params.add(allowanceInfo.getStuffDepart());
		params.add(allowanceInfo.getAllowanceMonth());
		params.add(allowanceInfo.getTransAwce());
		params.add(allowanceInfo.getFoodAwce());
		params.add(allowanceInfo.getHouseAwce());
		params.add(allowanceInfo.getCmuAwce());
		result = this.executeUpdate(sql, params);
		return result;
	}

}
