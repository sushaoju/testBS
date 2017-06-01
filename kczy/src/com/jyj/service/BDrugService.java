package com.jyj.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.jyj.entity.BDrug;
import com.jyj.dao.BaseDao;

public class BDrugService extends BaseDao{
//分页	
	public List<BDrug> getBDrugsForPage(String ypmc,Integer pageNo,Integer pageSize) {
		String query="select id,ypbh,ypmc,lb,sccs,yptm,ggxh,pzwh,bz,jg,picture from zibubaojian where 1=1";
		List<Object> params =new ArrayList<Object>();
        //搜索的条件
		if(ypmc!=null && !"".equals(ypmc)){
			query =query +" and ypmc like ?";
			params.add("%"+ypmc+"%");
		}

		params.add((pageNo-1)*pageSize);
		params.add(pageSize);
		List<BDrug> bdrugs = new ArrayList<BDrug>();
		ResultSet rs= this.executeQueryForPages(query, params);
		try {
			while(rs.next()){
				int  id= rs.getInt("id");
				String bdrug1 = rs.getString("ypbh");
				String bdrug2 = rs.getString("ypmc");
				String bdrug3 = rs.getString("lb");
				String bdrug4 = rs.getString("sccs");
				String bdrug5 = rs.getString("yptm");
				String bdrug6 = rs.getString("ggxh");
				String bdrug7 = rs.getString("pzwh");
				String bdrug8 = rs.getString("bz");
				double bdrug9 = rs.getDouble("jg");
				String bdrug10 = rs.getString("picture");
				BDrug bdrug = new BDrug(id,bdrug1,bdrug2,bdrug3,bdrug4,bdrug5,bdrug6,bdrug7,bdrug8,bdrug9,bdrug10);
				bdrugs.add(bdrug);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.close();
		}
		return bdrugs;
	}
	
	public int getTotalCount(String ypmc) {
		String sql = "select id,ypbh,ypmc,lb,sccs,yptm,ggxh,pzwh,bz,jg,picture from zibubaojian where 1=1";
		List<Object> params =new ArrayList<Object>();
		if(ypmc!=null && !"".equals(ypmc)){
			sql =sql +" and ypmc like ?";
			params.add("%"+ypmc+"%");
		}

		int result = executeTotalCountForPages(sql, params);
		return this.executeTotalCountForPages(sql, params);
	}
//找所有药	
	public List<BDrug> findAllBDrugs(){
		List<BDrug> bdrugs = new ArrayList<BDrug>();
		String query = "select id,ypbh,ypmc,lb,sccs,yptm,ggxh,pzwh,bz,jg,picture from zibubaojian";
		ResultSet rs = this.executeQuery(query, null);
		//将数据从rs中取出并封装成User对象
		try {
			while(rs.next()){                            
				int  id= rs.getInt("id");
				String bdrug1 = rs.getString("ypbh");
				String bdrug2 = rs.getString("ypmc");
				String bdrug3 = rs.getString("lb");
				String bdrug4 = rs.getString("sccs");
				String bdrug5 = rs.getString("yptm");
				String bdrug6 = rs.getString("ggxh");
				String bdrug7 = rs.getString("pzwh");
				String bdrug8 = rs.getString("bz");
				double bdrug9 = rs.getDouble("jg");
				String bdrug10 = rs.getString("picture");
				BDrug bdrug = new BDrug(id,bdrug1,bdrug2,bdrug3,bdrug4,bdrug5,bdrug6,bdrug7,bdrug8,bdrug9,bdrug10);

				bdrugs.add(bdrug);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.close();
		}
		return bdrugs;
	}
//根据id返数据	
	public BDrug findBDrugById(String id) {
		String query = " select ypbh,ypmc,lb,sccs,yptm,ggxh,pzwh,bz,jg  from zibubaojian where id = ?";
		List<Object> params = new ArrayList<Object>();
		params.add(id);
		ResultSet rs = this.executeQuery(query, params);
		try {
			if(rs.next()){
				String bdrug1 = rs.getString("ypbh");
				String bdrug2 = rs.getString("ypmc");
				String bdrug3 = rs.getString("lb");
				String bdrug4 = rs.getString("sccs");
				String bdrug5 = rs.getString("yptm");
				String bdrug6 = rs.getString("ggxh");
				String bdrug7 = rs.getString("pzwh");
				String bdrug8 = rs.getString("bz");
				double bdrug9 = rs.getDouble("jg");
				BDrug bdrug = new BDrug(bdrug1,bdrug2,bdrug3,bdrug4,bdrug5,bdrug6,bdrug7,bdrug8,bdrug9);
				return bdrug;
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
