package com.testbs.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.testbs.dao.BaseDao;
import com.testbs.entity.ApplicantInfo;
import com.testbs.entity.StuffInfo;
import com.testbs.entity.stuffJob;

public class StuffInfoService extends BaseDao {
	// 分页
	public List<StuffInfo> getStuffInfoForPage(String stuffID,
			String stuffName, Integer pageNo, Integer pageSize) {
		String query = "select * from stuffinfo where 1=1";
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
		List<StuffInfo> stuffInfos = new ArrayList<StuffInfo>();
		ResultSet rs = this.executeQueryForPages(query, params);
		try {
			while (rs.next()) {
				int id = rs.getInt("id");
				String stuffID1 = rs.getString("stuffID");
				String stuffName1 = rs.getString("stuffName");
				String stuffBirth = rs.getString("stuffBirth");
				String stuffSex = rs.getString("stuffSex");
				String stuffNation = rs.getString("stuffNation");
				String stuffAddress = rs.getString("stuffAddress");
				String stuffTel = rs.getString("stuffTel");
				String stuffEmail = rs.getString("stuffEmail");
				String stuffEdu = rs.getString("stuffEdu");
				String stuffColleage = rs.getString("stuffColleage");
				String stuffProfession = rs.getString("stuffProfession");
				String stuffGrade = rs.getString("stuffGrade");
				String stuffWedding = rs.getString("stuffWedding");
				String stuffSkill = rs.getString("stuffSkill");

				StuffInfo stuffInfo = new StuffInfo(id, stuffID1, stuffName1,
						stuffBirth, stuffSex, stuffNation, stuffAddress,
						stuffTel, stuffEmail, stuffEdu, stuffColleage,
						stuffProfession, stuffGrade, stuffWedding, stuffSkill);
				stuffInfos.add(stuffInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close();
		}
		return stuffInfos;
	}

	public int getTotalCount(String stuffID) {
		String sql = "select * from stuffinfo where 1=1";
		List<Object> params = new ArrayList<Object>();
		if (stuffID != null && !"".equals(stuffID)) {
			sql = sql + " and stuffID like ?";
			params.add("%" + stuffID + "%");
		}

		int result = executeTotalCountForPages(sql, params);
		return this.executeTotalCountForPages(sql, params);
	}

	// 找所有部门信息
	public List<StuffInfo> findAllStuffInfos() {
		List<StuffInfo> stuffInfos = new ArrayList<StuffInfo>();
		String query = "select * from stuffinfo";
		ResultSet rs = this.executeQuery(query, null);
		// 将数据从rs中取出并封装成User对象
		try {
			while (rs.next()) {
				int id = rs.getInt("id");
				String stuffID1 = rs.getString("stuffID");
				String stuffName = rs.getString("stuffName");
				String stuffBirth = rs.getString("stuffBirth");
				String stuffSex = rs.getString("stuffSex");
				String stuffNation = rs.getString("stuffNation");
				String stuffAddress = rs.getString("stuffAddress");
				String stuffTel = rs.getString("stuffTel");
				String stuffEmail = rs.getString("stuffEmail");
				String stuffEdu = rs.getString("stuffEdu");
				String stuffColleage = rs.getString("stuffColleage");
				String stuffProfession = rs.getString("stuffProfession");
				String stuffGrade = rs.getString("stuffGrade");
				String stuffWedding = rs.getString("stuffWedding");
				String stuffSkill = rs.getString("stuffSkill");

				StuffInfo stuffInfo = new StuffInfo(id, stuffID1, stuffName,
						stuffBirth, stuffSex, stuffNation, stuffAddress,
						stuffTel, stuffEmail, stuffEdu, stuffColleage,
						stuffProfession, stuffGrade, stuffWedding, stuffSkill);
				stuffInfos.add(stuffInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close();
		}
		return stuffInfos;
	}
	
	
	
	//根据条件返数据
		public List<stuffJob> findStuffInfoByCondition(String stuffId,String stuffName,String depName) {
			List<stuffJob> stuffJobInfos = new ArrayList<stuffJob>();
			List<Object> paramsTemp = new ArrayList<Object>();
			List<Object> params = new ArrayList<Object>();
			
			 
			 String	query ="";
			 ResultSet rs;
			 
			 if((stuffId!=""&&stuffId!=null)&&(stuffName!=""&&stuffName!=null)&&(depName!=""&&depName!=null)){
				 params.add(stuffId);		
				 params.add(stuffName);
				 params.add(depName);
				 paramsTemp=params;
				 
				 query = " select  stuffinfo.*,jobinfo.*  from  stuffinfo,jobinfo  where stuffinfo.stuffID = jobinfo.stuffID and stuffinfo.stuffName = jobinfo.stuffName and  stuffinfo.stuffID = ? and  stuffinfo.stuffName = ? and jobinfo.stuffDepart=?";			
				
			 }
			 else  if((stuffId==""||stuffId==null)&&(depName==""||depName==null)&&(stuffName!=""&&stuffName!=null)){
				
				 params.add(stuffName);
				 paramsTemp=params;		
				 query="select  stuffinfo.*,jobinfo.*  from  stuffinfo,jobinfo where stuffinfo.stuffID = jobinfo.stuffID and stuffinfo.stuffName = jobinfo.stuffName and  stuffinfo.stuffName = ?";
			 }
			 else  if((stuffId==""||stuffId==null)&&(stuffName==""||stuffName==null)&&(depName!=""&&depName!=null)){
				
				 params.add(depName);
				 paramsTemp=params;
				 query="select  stuffinfo.*,jobinfo.*  from  stuffinfo,jobinfo where stuffinfo.stuffID = jobinfo.stuffID and  jobinfo.stuffDepart = ?";
			 }
			 else  if((depName==""||depName==null)&&(stuffName==""||stuffName==null)&&(stuffId!=""&&stuffId!=null)){
				 
				 params.add(stuffId);
				 paramsTemp=params;
				 query="select  stuffinfo.*,jobinfo.*  from  stuffinfo,jobinfo where stuffinfo.stuffID = jobinfo.stuffID and  jobinfo.stuffId = ?";
			 }
			 else  if((stuffId!=""||stuffId!=null)&&(stuffName!=""||stuffName!=null)&&(depName==""&&depName==null)){
				 params.add(stuffId);
				 params.add(stuffName);
				 paramsTemp=params;
				 query="select  stuffinfo.*,jobinfo.*  from  stuffinfo,jobinfo where stuffinfo.stuffID = jobinfo.stuffID  and  stuffinfo.stuffId = ? and  stuffinfo.stuffName = ?";
			 }
			 else  if((stuffId!=""||stuffId!=null)&&(stuffName==""||stuffName==null)&&(depName!=""&&depName!=null)){
				 
				 params.add(stuffId);
				 params.add(depName);
				 paramsTemp=params;
				 query="select  stuffinfo.*,jobinfo.*  from  stuffinfo,jobinfo where stuffinfo.stuffID = jobinfo.stuffID  and  stuffinfo.stuffId = ? and  jobinfo.stuffDepart = ?";
			 }
			 else  if((stuffId==""||stuffId==null)&&(stuffName!=""||stuffName!=null)&&(depName!=""&&depName!=null)){
				 
				 params.add(stuffName);
				 params.add(depName);
				 paramsTemp=params;
				 query="select  stuffinfo.*,jobinfo.*  from  stuffinfo,jobinfo where stuffinfo.stuffID = jobinfo.stuffID  and  stuffinfo.stuffName = ? and  jobinfo.stuffDepart = ?";
			 }
					 
			 rs = this.executeQuery(query, paramsTemp);
			 
			try {
				while(rs.next()){     
				        String stuffID = rs.getString("stuffID");	
						String stuffName1=rs.getString("stuffName");
						String stuffSex=rs.getString("stuffSex");
						String stuffDepart=rs.getString("stuffDepart");
						String stuffDuty=rs.getString("stuffDuty");	
						String stuffStatus=rs.getString("stuffStatus");
						String stuffTel=rs.getString("stuffTel");
						
						stuffJob stuffJobInfo = new stuffJob(stuffID, stuffName1, stuffSex, stuffDuty, stuffDepart, stuffStatus,stuffTel);
						stuffJobInfos.add(stuffJobInfo);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				this.close();
			}
			return stuffJobInfos;
		}
	
	
	
	
	
	

	// 根据id返数据
	public StuffInfo findStuffInfoById(String stuffID) {

		List<Object> params = new ArrayList<Object>();
		params.add(stuffID);

		String query = " select * from stuffinfo where stuffID=?";
		ResultSet rs = this.executeQuery(query, params);

		try {
			if (rs.next()) {
				int id = rs.getInt("id");
				String stuffID1 = rs.getString("stuffID");
				String stuffName = rs.getString("stuffName");
				String stuffBirth = rs.getString("stuffBirth");
				String stuffSex = rs.getString("stuffSex");
				String stuffNation = rs.getString("stuffNation");
				String stuffAddress = rs.getString("stuffAddress");
				String stuffTel = rs.getString("stuffTel");
				String stuffEmail = rs.getString("stuffEmail");
				String stuffEdu = rs.getString("stuffEdu");
				String stuffColleage = rs.getString("stuffColleage");
				String stuffProfession = rs.getString("stuffProfession");
				String stuffGrade = rs.getString("stuffGrade");
				String stuffWedding = rs.getString("stuffWedding");
				String stuffSkill = rs.getString("stuffSkill");
				StuffInfo stuffInfo = new StuffInfo(id, stuffID1, stuffName,
						stuffBirth, stuffSex, stuffNation, stuffAddress,
						stuffTel, stuffEmail, stuffEdu, stuffColleage,
						stuffProfession, stuffGrade, stuffWedding, stuffSkill);
				return stuffInfo;
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
	public int updateStuffInfo(StuffInfo stuffInfo) {
		String update = " update stuffinfo set stuffName=?,stuffBirth=?,stuffSex=?,stuffNation=?,stuffAddress=?,"
				+ "stuffTel=?,stuffEmail=?,stuffEdu=?,stuffColleage=?,stuffProfession=?, stuffGrade=?, stuffWedding=?, stuffSkill=?where stuffID=? ";
		List<Object> params = new ArrayList<Object>(15);
		// params.add(departmentInfo.getId());

		params.add(stuffInfo.getStuffName());
		params.add(stuffInfo.getStuffBirth());
		params.add(stuffInfo.getStuffSex());
		params.add(stuffInfo.getStuffNation());
		params.add(stuffInfo.getStuffAddress());
		params.add(stuffInfo.getStuffTel());
		params.add(stuffInfo.getStuffEmail());
		params.add(stuffInfo.getStuffEdu());
		params.add(stuffInfo.getStuffColleage());
		params.add(stuffInfo.getStuffProfession());
		params.add(stuffInfo.getStuffGrade());
		params.add(stuffInfo.getStuffWedding());
		params.add(stuffInfo.getStuffSkill());
		params.add(stuffInfo.getStuffID());

		return this.executeUpdate(update, params);
	}

	// 删除部门
	public int delStuffInfoId(String stuffID) {

		String sql = "delete from stuffinfo where stuffID=?";
		List<Object> params = new ArrayList<Object>();
		params.add(stuffID);
		return this.executeUpdate(sql, params);
	}

	// 增加部门
	public int addStuffInfo(StuffInfo stuffInfo) {
		int result = 0;
		String sql = " insert into stuffinfo(stuffID,stuffName,stuffBirth,stuffSex,stuffNation,stuffAddress,stuffTel,stuffEmail,stuffEdu,stuffColleage,stuffProfession,stuffGrade,stuffWedding,stuffSkill) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		List<Object> params = new ArrayList<Object>(15);
	
		params.add(stuffInfo.getStuffID());
		params.add(stuffInfo.getStuffName());
		params.add(stuffInfo.getStuffBirth());
		params.add(stuffInfo.getStuffSex());
		params.add(stuffInfo.getStuffNation());
		params.add(stuffInfo.getStuffAddress());
		params.add(stuffInfo.getStuffTel());
		params.add(stuffInfo.getStuffEmail());
		params.add(stuffInfo.getStuffEdu());
		params.add(stuffInfo.getStuffColleage());
		params.add(stuffInfo.getStuffProfession());
		params.add(stuffInfo.getStuffGrade());
		params.add(stuffInfo.getStuffWedding());
		params.add(stuffInfo.getStuffSkill());		
		result = this.executeUpdate(sql, params);
		return result;
	}

}
