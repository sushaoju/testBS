package com.testbs.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.testbs.dao.BaseDao;
import com.testbs.entity.ApplicantInfo;

public class ApplicantInfoService extends BaseDao {
	//分页	
	public List<ApplicantInfo> getApplicantInfoForPage(String id,String apName,String apDuty,Integer pageNo,Integer pageSize) {
		String query="select *  from applicantinfo where 1=1";
		List<Object> params =new ArrayList<Object>();
        //搜索的条件
		//if(id!=null && !"".equals(id)){
		//	query =query +" and id like ?";
		//	params.add("%"+id+"%");
		//}
		if(apName!=null && !"".equals(apName)){
			query =query +" and apName like ?";
			params.add("%"+apName+"%");
		}
		if(apDuty!=null && !"".equals(apDuty)){
			query =query +" and apDuty like ?";
			params.add("%"+apDuty+"%");
		}
		

		params.add((pageNo-1)*pageSize);
		params.add(pageSize);
		List<ApplicantInfo> applicantInfos = new ArrayList<ApplicantInfo>();
		ResultSet rs= this.executeQueryForPages(query, params);
		try {
			while(rs.next()){
				int  id1= rs.getInt("id");
			
				String apName1 = rs.getString("apName");	
				String apDuty1=rs.getString("apDuty");
				int  apAge= rs.getInt("apAge");
				String apEdu=rs.getString("apEdu");
				String apSkill=rs.getString("apSkill");
				String apExperience=rs.getString("apExperience");
				
				
				ApplicantInfo applicantInfo = new ApplicantInfo(id1,apName1,apDuty1,apAge,apEdu,apSkill,apExperience);
				applicantInfos.add(applicantInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.close();
		}
		return applicantInfos;
	}
	
	public int getTotalCount(String id) {
		String sql = "select *  from applicantinfo where 1=1";
		List<Object> params =new ArrayList<Object>();
		if(id!=null && !"".equals(id)){
			sql =sql +" and id like ?";
			params.add("%"+id+"%");
		}

		int result = executeTotalCountForPages(sql, params);
		return this.executeTotalCountForPages(sql, params);
	}

	
	
	//找所有应聘人员名单
	public List<ApplicantInfo> findAllApplicantInfos(){
		List<ApplicantInfo> applicantInfos = new ArrayList<ApplicantInfo>();
		String query = "select *  from applicantinfo";
		ResultSet rs = this.executeQuery(query, null);
		//将数据从rs中取出并封装成User对象
		try {
			while(rs.next()){                            
				int  id= rs.getInt("id");
				String apName = rs.getString("apName");	
				String apDuty=rs.getString("apDuty");
				int  apAge= rs.getInt("apAge");
				String apEdu=rs.getString("apEdu");
				String apSkill=rs.getString("apSkill");
				String apExperience=rs.getString("apExperience");	
				ApplicantInfo applicantInfo = new ApplicantInfo(id,apName,apDuty,apAge,apEdu,apSkill,apExperience);
				applicantInfos.add(applicantInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.close();
		}
		return applicantInfos;
	}

	//根据条件返数据
	public List<ApplicantInfo> findApplicantInfoByCondition(String recruitName,String demandJob) {
		List<ApplicantInfo> applicantInfos = new ArrayList<ApplicantInfo>();
		List<Object> paramsTemp = new ArrayList<Object>();
		List<Object> params = new ArrayList<Object>();
		 params.add(recruitName);		
		 params.add(demandJob);	 		 
		 String	query ="";
		 ResultSet rs;
		 
		 if(recruitName!=""&&recruitName!=null&&demandJob!=""&&demandJob!=null){
			 query = " select *  from  applicantinfo where apName = ? and apDuty = ?";			
			 paramsTemp=params;
		 }
		 else  if(recruitName==""||recruitName==null&&demandJob!=""&&demandJob!=null){
			 query = " select *  from  applicantinfo where apDuty ='"+demandJob+"'";	
			 paramsTemp= null;			
		 }
		 else  if(demandJob==""||demandJob==null&&recruitName!=""&&recruitName!=null){
			 query = " select *  from  applicantinfo where apName ='"+recruitName+"'";	
			 paramsTemp= null;	
		 }
		 
		 rs = this.executeQuery(query, paramsTemp);
		 
		try {
			while(rs.next()){           
			     int  id1= rs.getInt("id");
			     String apName = rs.getString("apName");	
					String apDuty=rs.getString("apDuty");
					int  apAge= rs.getInt("apAge");
					String apEdu=rs.getString("apEdu");
					String apSkill=rs.getString("apSkill");
					String apExperience=rs.getString("apExperience");					
					ApplicantInfo applicantInfo = new ApplicantInfo(id1,apName,apDuty,apAge,apEdu,apSkill,apExperience);
					applicantInfos.add(applicantInfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.close();
		}
		return applicantInfos;
	}
	
	//根据id返数据	
	public ApplicantInfo findApplicantInfoById(String id) {
		
		List<Object> params = new ArrayList<Object>();
		 params.add(id);		
		 
		 String	query = " select *  from  applicantinfo where id = ?";			
		ResultSet rs = this.executeQuery(query, params);
		
		try {
			if(rs.next()){
			     int  id1= rs.getInt("id");
			     String apName = rs.getString("apName");	
					String apDuty=rs.getString("apDuty");
					int  apAge= rs.getInt("apAge");
					String apEdu=rs.getString("apEdu");
					String apSkill=rs.getString("apSkill");
					String apExperience=rs.getString("apExperience");					
					ApplicantInfo applicantInfo = new ApplicantInfo(id1,apName,apDuty,apAge,apEdu,apSkill,apExperience);
				return applicantInfo;
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
	public int updateApplicantInfo(ApplicantInfo applicantInfo) {
		String update =" update applicantinfo set apName = ?,apDuty = ?,apAge=?,apEdu=?,apSkill=?,apExperience=? where id = ? ";
		List<Object> params = new ArrayList<Object>();
//		params.add(departmentInfo.getId());
		
		params.add(applicantInfo.getApName());
		params.add(applicantInfo.getApDuty());
		params.add(applicantInfo.getApAge());
		params.add(applicantInfo.getApEdu());
		params.add(applicantInfo.getApSkill());
		params.add(applicantInfo.getApExperience());

		return this.executeUpdate(update, params);
	}

	//删除部门
     public int delApplicantInfoId(String id){
		
		    String sql="delete from applicantinfo where id= ?";
		    List<Object> params = new ArrayList<Object>();
		    params.add(id);
		   return this.executeUpdate(sql, params);
	}
	
     //增加部门
	public int addApplicantInfo(ApplicantInfo applicantInfo){
		int result = 0;
		String sql = " insert into applicantinfo(id,apName,apDuty,apAge,apEdu,apSkill,apExperience) values (?,?,?,?,?,?,?)";
		List<Object> params = new ArrayList<Object>();
		params.add(applicantInfo.getId());
		params.add(applicantInfo.getApName());
		params.add(applicantInfo.getApDuty());
		params.add(applicantInfo.getApAge());
		params.add(applicantInfo.getApEdu());
		params.add(applicantInfo.getApSkill());
		params.add(applicantInfo.getApExperience());
		result= this.executeUpdate(sql, params);
		return result;
	}
	
}
