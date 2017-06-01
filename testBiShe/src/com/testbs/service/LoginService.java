package com.testbs.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.testbs.dao.BaseDao;
import com.testbs.entity.AdminInfo;

public class LoginService extends BaseDao {
	public AdminInfo login(String account, String password) {
		AdminInfo adminInfo=null;
		String sql1= "select * from admininfo where account=? and password=? ";
         List<Object> params=new ArrayList<Object>();
         params.add(account);
         params.add(password);
         ResultSet rs=this.executeQuery(sql1, params);
         try{
	           if(rs.next()){  
	           adminInfo =new AdminInfo();
	           adminInfo.setStuffID(rs.getString("stuffID"));
	           adminInfo.setStuffName(rs.getString("stuffName"));
	           adminInfo.setResignDate(rs.getString("resignDate"));
	           adminInfo.setAccount(rs.getString("account"));
	           adminInfo.setPassword(rs.getString("password"));
		       
		
	          }
         }catch(SQLException e){
	            e.printStackTrace();
         }finally{
	      this.close();
          }
      return adminInfo;
	}
}
