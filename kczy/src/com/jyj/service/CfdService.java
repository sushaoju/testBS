package com.jyj.service;

import java.util.ArrayList;
import java.util.List;

import com.jyj.entity.Cfd;

import com.jyj.dao.BaseDao;

public class CfdService extends BaseDao{
	public int addCfd(Cfd cfd){
	
		int result = 0;
		String sql = " insert into cfd( d_id,p_account,ypmc,ypsl,zje) values (?,?,?,?,?)";
		List<Object> params = new ArrayList<Object>();
		//params.add(ghd.getG_id());
		params.add(cfd.getD_id());
		
		params.add(cfd.getP_account());
		params.add(cfd.getYpmc());
		params.add(cfd.getYpsl());
		params.add(cfd.getZje());
		result= this.executeUpdate(sql, params);
		return result;
	}

}
