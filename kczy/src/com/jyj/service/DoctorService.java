package com.jyj.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jyj.dao.BaseDao;
import com.jyj.entity.Doctor;
import com.jyj.entity.Patient;

public class DoctorService extends BaseDao{

	public List<Doctor> getDoctorForPage(String id, String account, String pwd,
			String d_name, String jibie, String age, String sex, String phone,
			String address, String ksbh, String szks, String zc, String szyy,
			Integer pageNo,Integer pageSize) {
		String query="select id,account,pwd,d_name,jibie,age,sex,phone,address,ksbh,szks,zc,szyy from doctor where 1=1";
		List<Object> params=new ArrayList<Object>();
		if(id!=null && !"".equals(id)){
			query=query +" and id like ?";
			params.add("%"+id+"%");
		}	
		params.add((pageNo-1)*pageSize);
		params.add(pageSize);
		List<Doctor> doctors=new ArrayList<Doctor>();
		ResultSet rs=this.executeQueryForPages(query,params);
		try {
			while(rs.next()){
				String d_id=rs.getString("id");
				String d_account=rs.getString("account");
				String d_pwd=rs.getString("pwd");
				String d_d_name=rs.getString("d_name");
				String d_jibie=rs.getString("jibie");
				String d_age=rs.getString("age");
				String d_sex=rs.getString("sex");
				String d_phone=rs.getString("phone");
				String d_address=rs.getString("address");
				String d_ksbh=rs.getString("ksbh");
				String d_szks=rs.getString("szks");
				String d_zc=rs.getString("zc");
				String d_szyy=rs.getString("szyy");
				
				Doctor doctor=new Doctor(d_id,d_account,d_pwd,d_d_name,d_jibie,d_age,d_sex,d_phone,d_address,d_ksbh,d_szks,d_zc,d_szyy);
				doctors.add(doctor);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			this.close();
		}
		return doctors;
	}

	public int getTotalCount(String id, String account, String pwd,
			String d_name, String jibie, String age, String sex, String phone,
			String address, String ksbh, String szks, String zc, String szyy) {
		String query="select id,account,pwd,d_name,jibie,age,sex,phone,address,ksbh,szks,zc,szyy from doctor where 1=1";
		List<Object> params=new ArrayList<Object>();
		if(id!=null && !"".equals(id)){
			query=query +" and id like ?";
			params.add("%"+id+"%");
		}		
		return this.executeTotalCountForPages(query, params);
	}

	public int adddoctor(Doctor p) {
		int result=0;
		String sql="insert into doctor(id,account,pwd,d_name,jibie,age,sex,phone,address,ksbh,szks,zc,szyy) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		List<Object> params=new ArrayList<Object>();
		params.add(p.getId());
		params.add(p.getAccount());
		params.add(p.getPwd());
		params.add(p.getD_name());
		params.add(p.getJibie());
		params.add(p.getAge());
		params.add(p.getSex());
		params.add(p.getPhone());
		params.add(p.getAddress());
		params.add(p.getKsbh());
		params.add(p.getSzks());
		params.add(p.getZc());
		params.add(p.getSzyy());
		
		result=this.executeUpdate(sql, params);
		return result;
	}

	public int deletedoctor(Doctor p) {
		int result=0;
		String sql="delete from doctor where id= ?";
		
		List<Object> params=new ArrayList<Object>();
		params.add(p.getId());
		result=this.executeUpdate(sql, params);
	
		return result;
	}

	public Doctor findDoctorByid(String id) {
		List<Object> doctors=new ArrayList<Object>();
		String query="select id,account,pwd,d_name,jibie,age,sex,phone,address,ksbh,szks,zc,szyy from doctor where id=? ";
		doctors.add(id);
		ResultSet rs= this.executeQuery(query,doctors);
		//将数据从rs中取出并封装成对象
		try {
			while(rs.next()){
				String d_id=rs.getString("id");
				String d_account=rs.getString("account");
				String d_pwd=rs.getString("pwd");
				String d_d_name=rs.getString("d_name");
				String d_jibie=rs.getString("jibie");
				String d_age=rs.getString("age");
				String d_sex=rs.getString("sex");
				String d_phone=rs.getString("phone");
				String d_address=rs.getString("address");
				String d_ksbh=rs.getString("ksbh");
				String d_szks=rs.getString("szks");
				String d_zc=rs.getString("zc");
				String d_szyy=rs.getString("szyy");
				
				Doctor doctor=new Doctor(d_id,d_account,d_pwd,d_d_name,d_jibie,d_age,d_sex,d_phone,d_address,d_ksbh,d_szks,d_zc,d_szyy);
				return doctor;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			this.close();
		}
		return null;
	}

	public int updatedoctor(Doctor doctor) {
		String update="update doctor set account=?,pwd=?,d_name=?,jibie=?,age=?,sex=?,phone=?,address=?,ksbh=?,szks=?,zc=?,szyy=?  where id=?";
		List<Object> params=new ArrayList<Object>();
	
		params.add(doctor.getAccount());
		params.add(doctor.getPwd());
		params.add(doctor.getD_name());
		params.add(doctor.getJibie());
		params.add(doctor.getAge());
		params.add(doctor.getSex());
		params.add(doctor.getPhone());
		params.add(doctor.getAddress());
		params.add(doctor.getKsbh());
		params.add(doctor.getSzks());
		params.add(doctor.getZc());
		params.add(doctor.getSzyy());
		params.add(doctor.getId());
		return this.executeUpdate(update, params);
	}

}
