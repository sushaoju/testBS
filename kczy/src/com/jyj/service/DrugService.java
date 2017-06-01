package com.jyj.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.jyj.entity.Drug;
import com.jyj.dao.BaseDao;

public class DrugService extends BaseDao{
//分页	
	public List<Drug> getDrugsForPage(String ypmc,Integer pageNo,Integer pageSize) {
		String query="select id,ypbh,ypmc,lb,sccs,yptm,ggxh,pzwh,bz,jg  from ganmaofashao where 1=1";
		List<Object> params =new ArrayList<Object>();
        //搜索的条件
		if(ypmc!=null && !"".equals(ypmc)){
			query =query +" and ypmc like ?";
			params.add("%"+ypmc+"%");
		}

		params.add((pageNo-1)*pageSize);
		params.add(pageSize);
		List<Drug> drugs = new ArrayList<Drug>();
		ResultSet rs= this.executeQueryForPages(query, params);
		try {
			while(rs.next()){
				int  id= rs.getInt("id");
				String drug1 = rs.getString("ypbh");
				String drug2 = rs.getString("ypmc");
				String drug3 = rs.getString("lb");
				String drug4 = rs.getString("sccs");
				String drug5 = rs.getString("yptm");
				String drug6 = rs.getString("ggxh");
				String drug7 = rs.getString("pzwh");
				String drug8 = rs.getString("bz");
				double drug9 = rs.getDouble("jg");
				Drug drug = new Drug(id,drug1,drug2,drug3,drug4,drug5,drug6,drug7,drug8,drug9);
				drugs.add(drug);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.close();
		}
		return drugs;
	}
	
	public int getTotalCount(String ypmc) {
		String sql = "select id,ypbh,ypmc,lb,sccs,yptm,ggxh,pzwh,bz,jg  from ganmaofashao where 1=1";
		List<Object> params =new ArrayList<Object>();
		if(ypmc!=null && !"".equals(ypmc)){
			sql =sql +" and zdmc like ?";
			params.add("%"+ypmc+"%");
		}

		int result = executeTotalCountForPages(sql, params);
		return this.executeTotalCountForPages(sql, params);
	}
//找所有药	
	public List<Drug> findAllDrugs(){
		List<Drug> drugs = new ArrayList<Drug>();
		String query = "select id,ypbh,ypmc,lb,sccs,yptm,ggxh,pzwh,bz,jg  from ganmaofashao";
		ResultSet rs = this.executeQuery(query, null);
		//将数据从rs中取出并封装成User对象
		try {
			while(rs.next()){                            
				int  id= rs.getInt("id");
				String drug1 = rs.getString("ypbh");
				String drug2 = rs.getString("ypmc");
				String drug3 = rs.getString("lb");
				String drug4 = rs.getString("sccs");
				String drug5 = rs.getString("yptm");
				String drug6 = rs.getString("ggxh");
				String drug7 = rs.getString("pzwh");
				String drug8 = rs.getString("bz");
				double drug9 = rs.getDouble("jg");
				Drug drug = new Drug(id,drug1,drug2,drug3,drug4,drug5,drug6,drug7,drug8,drug9);

				drugs.add(drug);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.close();
		}
		return drugs;
	}
//根据id返数据	
	public Drug findDrugById(String id) {
		String query = " select ypbh,ypmc,lb,sccs,yptm,ggxh,pzwh,bz,jg  from ganmaofashao where id = ?";
		List<Object> params = new ArrayList<Object>();
		params.add(id);
		ResultSet rs = this.executeQuery(query, params);
		try {
			if(rs.next()){
				String drug1 = rs.getString("ypbh");
				String drug2 = rs.getString("ypmc");
				String drug3 = rs.getString("lb");
				String drug4 = rs.getString("sccs");
				String drug5 = rs.getString("yptm");
				String drug6 = rs.getString("ggxh");
				String drug7 = rs.getString("pzwh");
				String drug8 = rs.getString("bz");
				double drug9 = rs.getDouble("jg");
				Drug drug = new Drug(drug1,drug2,drug3,drug4,drug5,drug6,drug7,drug8,drug9);
				return drug;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.close();
		}
		return null;
	}
	
	
	
}
