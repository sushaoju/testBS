package com.jyj.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.jyj.entity.WDrug;
import com.jyj.dao.BaseDao;

public class WDrugService extends BaseDao{
//分页	
	public List<WDrug> getWDrugsForPage(String ypmc,Integer pageNo,Integer pageSize) {
		String query="select id,ypbh,ypmc,lb,sccs,yptm,ggxh,pzwh,bz,jg  from waiyongchangbei where 1=1";
		List<Object> params =new ArrayList<Object>();
        //搜索的条件
		if(ypmc!=null && !"".equals(ypmc)){
			query =query +" and ypmc like ?";
			params.add("%"+ypmc+"%");
		}

		params.add((pageNo-1)*pageSize);
		params.add(pageSize);
		List<WDrug> wdrugs = new ArrayList<WDrug>();
		ResultSet rs= this.executeQueryForPages(query, params);
		try {
			while(rs.next()){
				int  id= rs.getInt("id");
				String wdrug1 = rs.getString("ypbh");
				String wdrug2 = rs.getString("ypmc");
				String wdrug3 = rs.getString("lb");
				String wdrug4 = rs.getString("sccs");
				String wdrug5 = rs.getString("yptm");
				String wdrug6 = rs.getString("ggxh");
				String wdrug7 = rs.getString("pzwh");
				String wdrug8 = rs.getString("bz");
				double wdrug9 = rs.getDouble("jg");
				WDrug wdrug = new WDrug(id,wdrug1,wdrug2,wdrug3,wdrug4,wdrug5,wdrug6,wdrug7,wdrug8,wdrug9);
				wdrugs.add(wdrug);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.close();
		}
		return wdrugs;
	}
	
	public int getTotalCount(String ypmc) {
		String sql = "select id,ypbh,ypmc,lb,sccs,yptm,ggxh,pzwh,bz,jg  from waiyongchangbei where 1=1";
		List<Object> params =new ArrayList<Object>();
		if(ypmc!=null && !"".equals(ypmc)){
			sql =sql +" and ypmc like ?";
			params.add("%"+ypmc+"%");
		}

		int result = executeTotalCountForPages(sql, params);
		return this.executeTotalCountForPages(sql, params);
	}
//找所有药	
	public List<WDrug> findAllWDrugs(){
		List<WDrug> wdrugs = new ArrayList<WDrug>();
		String query = "select id,ypbh,ypmc,lb,sccs,yptm,ggxh,pzwh,bz,jg  from waiyongchangbei";
		ResultSet rs = this.executeQuery(query, null);
		//将数据从rs中取出并封装成User对象
		try {
			while(rs.next()){                            
				int  id= rs.getInt("id");
				String wdrug1 = rs.getString("ypbh");
				String wdrug2 = rs.getString("ypmc");
				String wdrug3 = rs.getString("lb");
				String wdrug4 = rs.getString("sccs");
				String wdrug5 = rs.getString("yptm");
				String wdrug6 = rs.getString("ggxh");
				String wdrug7 = rs.getString("pzwh");
				String wdrug8 = rs.getString("bz");
				double wdrug9 = rs.getDouble("jg");
				WDrug wdrug = new WDrug(id,wdrug1,wdrug2,wdrug3,wdrug4,wdrug5,wdrug6,wdrug7,wdrug8,wdrug9);

				wdrugs.add(wdrug);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.close();
		}
		return wdrugs;
	}
//根据id返数据	
	public WDrug findWDrugById(String id) {
		String query = " select ypbh,ypmc,lb,sccs,yptm,ggxh,pzwh,bz,jg  from waiyongchangbei where id = ?";
		List<Object> params = new ArrayList<Object>();
		params.add(id);
		ResultSet rs = this.executeQuery(query, params);
		try {
			if(rs.next()){
				String wdrug1 = rs.getString("ypbh");
				String wdrug2 = rs.getString("ypmc");
				String wdrug3 = rs.getString("lb");
				String wdrug4 = rs.getString("sccs");
				String wdrug5 = rs.getString("yptm");
				String wdrug6 = rs.getString("ggxh");
				String wdrug7 = rs.getString("pzwh");
				String wdrug8 = rs.getString("bz");
				double wdrug9 = rs.getDouble("jg");
				WDrug wdrug = new WDrug(wdrug1,wdrug2,wdrug3,wdrug4,wdrug5,wdrug6,wdrug7,wdrug8,wdrug9);
				return wdrug;
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
