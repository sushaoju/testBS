package com.jyj.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.jyj.entity.XNDrug;
import com.jyj.dao.BaseDao;

public class XNDrugService extends BaseDao{
//分页	
	public List<XNDrug> getXNDrugsForPage(String ypmc,Integer pageNo,Integer pageSize) {
		String query="select id,ypbh,ypmc,lb,sccs,yptm,ggxh,pzwh,bz,jg,picture from xinnaoxueguan where 1=1";
		List<Object> params =new ArrayList<Object>();
        //搜索的条件
		if(ypmc!=null && !"".equals(ypmc)){
			query =query +" and ypmc like ?";
			params.add("%"+ypmc+"%");
		}

		params.add((pageNo-1)*pageSize);
		params.add(pageSize);
		List<XNDrug> xndrugs = new ArrayList<XNDrug>();
		ResultSet rs= this.executeQueryForPages(query, params);
		try {
			while(rs.next()){
				int  id= rs.getInt("id");
				String xndrug1 = rs.getString("ypbh");
				String xndrug2 = rs.getString("ypmc");
				String xndrug3 = rs.getString("lb");
				String xndrug4 = rs.getString("sccs");
				String xndrug5 = rs.getString("yptm");
				String xndrug6 = rs.getString("ggxh");
				String xndrug7 = rs.getString("pzwh");
				String xndrug8 = rs.getString("bz");
				double xndrug9 = rs.getDouble("jg");
				String xndrug10 = rs.getString("picture");
				XNDrug xndrug = new XNDrug(id,xndrug1,xndrug2,xndrug3,xndrug4,xndrug5,xndrug6,xndrug7,xndrug8,xndrug9,xndrug10);
				xndrugs.add(xndrug);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.close();
		}
		return xndrugs;
	}
	
	public int getTotalCount(String ypmc) {
		String sql = "select id,ypbh,ypmc,lb,sccs,yptm,ggxh,pzwh,bz,jg,picture from xinnaoxueguan where 1=1";
		List<Object> params =new ArrayList<Object>();
		if(ypmc!=null && !"".equals(ypmc)){
			sql =sql +" and ypmc like ?";
			params.add("%"+ypmc+"%");
		}

		int result = executeTotalCountForPages(sql, params);
		return this.executeTotalCountForPages(sql, params);
	}
//找所有药	
	public List<XNDrug> findAllXNDrugs(){
		List<XNDrug> xndrugs = new ArrayList<XNDrug>();
		String query = "select id,ypbh,ypmc,lb,sccs,yptm,ggxh,pzwh,bz,jg,picture from xinnaoxueguan";
		ResultSet rs = this.executeQuery(query, null);
		//将数据从rs中取出并封装成User对象
		try {
			while(rs.next()){                            
				int  id= rs.getInt("id");
				String xndrug1 = rs.getString("ypbh");
				String xndrug2 = rs.getString("ypmc");
				String xndrug3 = rs.getString("lb");
				String xndrug4 = rs.getString("sccs");
				String xndrug5 = rs.getString("yptm");
				String xndrug6 = rs.getString("ggxh");
				String xndrug7 = rs.getString("pzwh");
				String xndrug8 = rs.getString("bz");
				double xndrug9 = rs.getDouble("jg");
				String xndrug10 = rs.getString("picture");
				XNDrug xndrug = new XNDrug(id,xndrug1,xndrug2,xndrug3,xndrug4,xndrug5,xndrug6,xndrug7,xndrug8,xndrug9,xndrug10);

				xndrugs.add(xndrug);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.close();
		}
		return xndrugs;
	}
//根据id返数据	
	public XNDrug findXNDrugById(String id) {
		String query = " select ypbh,ypmc,lb,sccs,yptm,ggxh,pzwh,bz,jg  from xinnaoxueguan where id = ?";
		List<Object> params = new ArrayList<Object>();
		params.add(id);
		ResultSet rs = this.executeQuery(query, params);
		try {
			if(rs.next()){
				String xndrug1 = rs.getString("ypbh");
				String xndrug2 = rs.getString("ypmc");
				String xndrug3 = rs.getString("lb");
				String xndrug4 = rs.getString("sccs");
				String xndrug5 = rs.getString("yptm");
				String xndrug6 = rs.getString("ggxh");
				String xndrug7 = rs.getString("pzwh");
				String xndrug8 = rs.getString("bz");
				double xndrug9 = rs.getDouble("jg");
				XNDrug xndrug = new XNDrug(xndrug1,xndrug2,xndrug3,xndrug4,xndrug5,xndrug6,xndrug7,xndrug8,xndrug9);
				return xndrug;
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
