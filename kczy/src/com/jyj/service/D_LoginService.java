package com.jyj.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jyj.dao.BaseDao;
import com.jyj.entity.Doctor;


public class D_LoginService extends BaseDao{

	public Doctor login(String account, String pwd) {
		Doctor doctor = null;
		String sql1= "SELECT id,account,pwd,d_name,jibie,age,sex,phone,address,ksbh,szks,zc,szyy FROM doctor "
					+" where account = ? and pwd = ?";
		List<Object> params = new ArrayList<Object>();
		params.add(account);
		params.add(pwd);
		ResultSet rs = this.executeQuery(sql1, params);
		try {
			if(rs.next()){
				doctor = new Doctor();
				doctor.setId(rs.getString("id"));
				doctor.setAccount(rs.getString("account"));
				doctor.setPwd(rs.getString("pwd"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.close();
		}
		return doctor;
	}

}
