package com.jyj.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.jyj.entity.XHDrug;
import com.jyj.dao.BaseDao;

public class XHDrugService extends BaseDao{
//分页	
	public List<XHDrug> getXHDrugsForPage(String ypmc,Integer pageNo,Integer pageSize) {
		String query="select id,ypbh,ypmc,lb,sccs,yptm,ggxh,pzwh,bz,jg  from xiaohuaxitong where 1=1";
		List<Object> params =new ArrayList<Object>();
        //搜索的条件
		if(ypmc!=null && !"".equals(ypmc)){
			query =query +" and ypmc like ?";
			params.add("%"+ypmc+"%");
		}

		params.add((pageNo-1)*pageSize);
		params.add(pageSize);
		List<XHDrug> xhdrugs = new ArrayList<XHDrug>();
		ResultSet rs= this.executeQueryForPages(query, params);
		try {
			while(rs.next()){
				int  id= rs.getInt("id");
				String xhdrug1 = rs.getString("ypbh");
				String xhdrug2 = rs.getString("ypmc");
				String xhdrug3 = rs.getString("lb");
				String xhdrug4 = rs.getString("sccs");
				String xhdrug5 = rs.getString("yptm");
				String xhdrug6 = rs.getString("ggxh");
				String xhdrug7 = rs.getString("pzwh");
				String xhdrug8 = rs.getString("bz");
				double xhdrug9 = rs.getDouble("jg");
				XHDrug xhdrug = new XHDrug(id,xhdrug1,xhdrug2,xhdrug3,xhdrug4,xhdrug5,xhdrug6,xhdrug7,xhdrug8,xhdrug9);
				xhdrugs.add(xhdrug);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.close();
		}
		return xhdrugs;
	}
	
	public int getTotalCount(String ypmc) {
		String sql = "select id,ypbh,ypmc,lb,sccs,yptm,ggxh,pzwh,bz,jg  from xiaohuaxitong where 1=1";
		List<Object> params =new ArrayList<Object>();
		if(ypmc!=null && !"".equals(ypmc)){
			sql =sql +" and ypmc like ?";
			params.add("%"+ypmc+"%");
		}

		int result = executeTotalCountForPages(sql, params);
		return this.executeTotalCountForPages(sql, params);
	}
//找所有药	
	public List<XHDrug> findAllXHDrugs(){
		List<XHDrug> xhdrugs = new ArrayList<XHDrug>();
		String query = "select id,ypbh,ypmc,lb,sccs,yptm,ggxh,pzwh,bz,jg  from xiaohuaxitong";
		ResultSet rs = this.executeQuery(query, null);
		//将数据从rs中取出并封装成User对象
		try {
			while(rs.next()){                            
				int  id= rs.getInt("id");
				String xhdrug1 = rs.getString("ypbh");
				String xhdrug2 = rs.getString("ypmc");
				String xhdrug3 = rs.getString("lb");
				String xhdrug4 = rs.getString("sccs");
				String xhdrug5 = rs.getString("yptm");
				String xhdrug6 = rs.getString("ggxh");
				String xhdrug7 = rs.getString("pzwh");
				String xhdrug8 = rs.getString("bz");
				double xhdrug9 = rs.getDouble("jg");
				XHDrug xhdrug = new XHDrug(id,xhdrug1,xhdrug2,xhdrug3,xhdrug4,xhdrug5,xhdrug6,xhdrug7,xhdrug8,xhdrug9);

				xhdrugs.add(xhdrug);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.close();
		}
		return xhdrugs;
	}
//根据id返数据	
	public XHDrug findXHDrugById(String id) {
		String query = " select ypbh,ypmc,lb,sccs,yptm,ggxh,pzwh,bz,jg  from xiaohuaxitong where id = ?";
		List<Object> params = new ArrayList<Object>();
		params.add(id);
		ResultSet rs = this.executeQuery(query, params);
		try {
			if(rs.next()){
				String xhdrug1 = rs.getString("ypbh");
				String xhdrug2 = rs.getString("ypmc");
				String xhdrug3 = rs.getString("lb");
				String xhdrug4 = rs.getString("sccs");
				String xhdrug5 = rs.getString("yptm");
				String xhdrug6 = rs.getString("ggxh");
				String xhdrug7 = rs.getString("pzwh");
				String xhdrug8 = rs.getString("bz");
				double xhdrug9 = rs.getDouble("jg");
				XHDrug xhdrug = new XHDrug(xhdrug1,xhdrug2,xhdrug3,xhdrug4,xhdrug5,xhdrug6,xhdrug7,xhdrug8,xhdrug9);
				return xhdrug;
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
