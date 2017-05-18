package com.jyj.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jyj.dao.BaseDao;
import com.jyj.entity.Patient;
import com.jyj.entity.Question;

public class PatientService extends BaseDao{

	public List<Patient> getPatientForPage(String id,String account, String pwd, String name,String jibie, String age, String sex,
			String number, String address, Integer pageNo,Integer pageSize) {
		String query="select id,account,pwd,name,jibie,age,sex,number,address from patient where 1=1";
		List<Object> params=new ArrayList<Object>();
		if(id!=null && !"".equals(id)){
			query=query +" and id like ?";
			params.add("%"+id+"%");
		}	
		params.add((pageNo-1)*pageSize);
		params.add(pageSize);
		List<Patient> patients=new ArrayList<Patient>();
		ResultSet rs=this.executeQueryForPages(query,params);
		try {
			while(rs.next()){
				String p_id=rs.getString("id");
				String p_account=rs.getString("account");
				String p_pwd=rs.getString("pwd");
				String p_name=rs.getString("name");
				String p_jibie=rs.getString("jibie");
				String p_age=rs.getString("age");
				String p_sex=rs.getString("sex");
				String p_number=rs.getString("number");
				String p_address=rs.getString("address");
				
				Patient patient=new Patient(p_id,p_account,p_pwd,p_name,p_jibie,p_age,p_sex,p_number,p_address);
				patients.add(patient);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			this.close();
		}
		return patients;
	}

	public int getTotalCount(String id, String account,String pwd, String name, 
			String jibie,String patient_age, String sex, String number,String address) {
		String query="select id,account,pwd,name,jibie,age,sex,number,address from patient where 1=1";
		List<Object> params=new ArrayList<Object>();
		if(id!=null && !"".equals(id)){
			query=query +" and id like ?";
			params.add("%"+id+"%");
		}		
		return this.executeTotalCountForPages(query, params);
	}

	public int addpatient(Patient p) {
		int result=0;
		String sql="insert into patient(account,pwd,name,jibie,age,sex,number,address) values(?,?,?,?,?,?,?,?)";
		
		List<Object> params=new ArrayList<Object>();
		//params.add(p.getId());
		params.add(p.getAccount());
		params.add(p.getPwd());
		params.add(p.getName());
		params.add(p.getJibie());
		params.add(p.getAge());
		params.add(p.getSex());
		params.add(p.getNumber());
		params.add(p.getAddress());
		
		result=this.executeUpdate(sql, params);
		return result;
	}

	public int deletepatient(Patient p) {
		int result=0;
		String sql="delete from patient where id= ?";
		
		List<Object> params=new ArrayList<Object>();
		params.add(p.getId());
		result=this.executeUpdate(sql, params);
	
		return result;
	}

	public Patient findPatientByid(String id) {
		List<Object> patients=new ArrayList<Object>();
		String query="select id,account,pwd,name,jibie,age,sex,number,address from patient where id=? ";
		patients.add(id);
		ResultSet rs= this.executeQuery(query,patients);
		//将数据从rs中取出并封装成对象
		try {
			while(rs.next()){
				String p_id=rs.getString("id");
				String p_account=rs.getString("account");
				String p_pwd=rs.getString("pwd");
				String p_name=rs.getString("name");
				String p_jibie=rs.getString("jibie");
				String p_age=rs.getString("age");
				String p_sex=rs.getString("sex");
				String p_number=rs.getString("number");
				String p_address=rs.getString("address");
				
				Patient patient=new Patient(p_id,p_account,p_pwd,p_name,p_jibie,p_age,p_sex,p_number,p_address);
				return patient;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			this.close();
		}
		return null;
	}

	public int updatepatient(Patient patient) {
		String update="update patient set account=?,pwd=?,name=?,jibie=?,age=?,sex=?,number=?,address=?  where id=?";
		List<Object> params=new ArrayList<Object>();
		params.add(patient.getAccount());
		params.add(patient.getPwd());
		params.add(patient.getName());
		params.add(patient.getJibie());
		params.add(patient.getAge());
		params.add(patient.getSex());
		params.add(patient.getNumber());
		params.add(patient.getAddress());
		params.add(patient.getId());
		return this.executeUpdate(update, params);
	}

}
