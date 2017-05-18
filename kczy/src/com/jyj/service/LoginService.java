package com.jyj.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jyj.dao.BaseDao;
import com.jyj.entity.Patient;

public class LoginService extends BaseDao{

	public Patient login(String account, String pwd) {
		Patient patient = null;
		String sql1= "SELECT id,account,pwd,name,jibie,age,sex,number,address FROM patient "
					+" where account = ? and pwd = ?";
		List<Object> params = new ArrayList<Object>();
		params.add(account);
		params.add(pwd);
		ResultSet rs = this.executeQuery(sql1, params);
		try {
			if(rs.next()){
				patient = new Patient();
				patient.setId(rs.getString("id"));
				patient.setAccount(rs.getString("account"));
				patient.setPwd(rs.getString("pwd"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.close();
		}
		return patient;
	}

}
