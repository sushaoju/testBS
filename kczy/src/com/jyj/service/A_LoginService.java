package com.jyj.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jyj.dao.BaseDao;
import com.jyj.entity.Admin;
import com.jyj.entity.Doctor;

public class A_LoginService extends BaseDao{

	public Admin login(String account, String pwd) {
		Admin admin = null;
		String sql1= "SELECT account,pwd FROM admin "
					+" where account = ? and pwd = ?";
		List<Object> params = new ArrayList<Object>();
		params.add(account);
		params.add(pwd);
		ResultSet rs = this.executeQuery(sql1, params);
		try {
			if(rs.next()){
				admin = new Admin();
				admin.setAccount(rs.getString("account"));
				admin.setPwd(rs.getString("pwd"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.close();
		}
		return admin;
	}

}
