package com.jyj.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.jyj.entity.GDrug;
import com.jyj.dao.BaseDao;

public class GDrugService extends BaseDao{
//分页	
	public List<GDrug> getGDrugsForPage(String ypmc,Integer pageNo,Integer pageSize) {
		String query="select id,ypbh,ypmc,lb,sccs,yptm,ggxh,pzwh,bz,jg,picture from ganmaofashao where 1=1";
		List<Object> params =new ArrayList<Object>();
        //搜索的条件
		if(ypmc!=null && !"".equals(ypmc)){
			query =query +" and ypmc like ?";
			params.add("%"+ypmc+"%");
		}

		params.add((pageNo-1)*pageSize);
		params.add(pageSize);
		List<GDrug> gdrugs = new ArrayList<GDrug>();
		ResultSet rs= this.executeQueryForPages(query, params);
		try {
			while(rs.next()){
				int  id= rs.getInt("id");
				String gdrug1 = rs.getString("ypbh");
				String gdrug2 = rs.getString("ypmc");
				String gdrug3 = rs.getString("lb");
				String gdrug4 = rs.getString("sccs");
				String gdrug5 = rs.getString("yptm");
				String gdrug6 = rs.getString("ggxh");
				String gdrug7 = rs.getString("pzwh");
				String gdrug8 = rs.getString("bz");
				double gdrug9 = rs.getDouble("jg");
				String gdrug10 = rs.getString("picture");
				
				GDrug gdrug = new GDrug(id,gdrug1,gdrug2,gdrug3,gdrug4,gdrug5,gdrug6,gdrug7,gdrug8,gdrug9,gdrug10);
				gdrugs.add(gdrug);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.close();
		}
		return gdrugs;
	}
	
	public int getTotalCount(String ypmc) {
		String sql = "select id,ypbh,ypmc,lb,sccs,yptm,ggxh,pzwh,bz,jg,picture from ganmaofashao where 1=1";
		List<Object> params =new ArrayList<Object>();
		if(ypmc!=null && !"".equals(ypmc)){
			sql =sql +" and ypmc like ?";
			params.add("%"+ypmc+"%");
		}

		int result = executeTotalCountForPages(sql, params);
		return this.executeTotalCountForPages(sql, params);
	}
//找所有药	
	public List<GDrug> findAllGDrugs(){
		List<GDrug> gdrugs = new ArrayList<GDrug>();
		String query = "select id,ypbh,ypmc,lb,sccs,yptm,ggxh,pzwh,bz,jg,picture  from ganmaofashao";
		ResultSet rs = this.executeQuery(query, null);
		//将数据从rs中取出并封装成User对象
		try {
			while(rs.next()){                            
				int  id= rs.getInt("id");
				String gdrug1 = rs.getString("ypbh");
				String gdrug2 = rs.getString("ypmc");
				String gdrug3 = rs.getString("lb");
				String gdrug4 = rs.getString("sccs");
				String gdrug5 = rs.getString("yptm");
				String gdrug6 = rs.getString("ggxh");
				String gdrug7 = rs.getString("pzwh");
				String gdrug8 = rs.getString("bz");
				double gdrug9 = rs.getDouble("jg");
				String gdrug10 = rs.getString("picture");
				GDrug gdrug = new GDrug(id,gdrug1,gdrug2,gdrug3,gdrug4,gdrug5,gdrug6,gdrug7,gdrug8,gdrug9,gdrug10);

				gdrugs.add(gdrug);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.close();
		}
		return gdrugs;
	}
//根据id返数据	
	public GDrug findGDrugById(String id) {
		String query = " select ypbh,ypmc,lb,sccs,yptm,ggxh,pzwh,bz,jg  from ganmaofashao where id = ?";
		List<Object> params = new ArrayList<Object>();
		params.add(id);
		ResultSet rs = this.executeQuery(query, params);
		try {
			if(rs.next()){
				String gdrug1 = rs.getString("ypbh");
				String gdrug2 = rs.getString("ypmc");
				String gdrug3 = rs.getString("lb");
				String gdrug4 = rs.getString("sccs");
				String gdrug5 = rs.getString("yptm");
				String gdrug6 = rs.getString("ggxh");
				String gdrug7 = rs.getString("pzwh");
				String gdrug8 = rs.getString("bz");
				double gdrug9 = rs.getDouble("jg");
				GDrug gdrug = new GDrug(gdrug1,gdrug2,gdrug3,gdrug4,gdrug5,gdrug6,gdrug7,gdrug8,gdrug9);
				return gdrug;
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
