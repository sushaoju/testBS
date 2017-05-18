package com.jyj.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jyj.dao.BaseDao;
import com.jyj.entity.HDrug;

public class HDrugService extends BaseDao{

	public List<HDrug> getHDrugsForPage(String ypmc,Integer pageNo,Integer pageSize) {
		String query="select id,ypbh,ypmc,lb,sccs,yptm,ggxh,pzwh,bz,jg  from huxixitong where 1=1";
		List<Object> params =new ArrayList<Object>();
        //搜索的条件
		if(ypmc!=null && !"".equals(ypmc)){
			query =query +" and ypmc like ?";
			params.add("%"+ypmc+"%");
		}

		params.add((pageNo-1)*pageSize);
		params.add(pageSize);
		List<HDrug> hdrugs = new ArrayList<HDrug>();
		ResultSet rs= this.executeQueryForPages(query, params);
		try {
			while(rs.next()){
				int  id= rs.getInt("id");
				String hdrug1 = rs.getString("ypbh");
				String hdrug2 = rs.getString("ypmc");
				String hdrug3 = rs.getString("lb");
				String hdrug4 = rs.getString("sccs");
				String hdrug5 = rs.getString("yptm");
				String hdrug6 = rs.getString("ggxh");
				String hdrug7 = rs.getString("pzwh");
				String hdrug8 = rs.getString("bz");
				double hdrug9 = rs.getDouble("jg");
				HDrug hdrug = new HDrug(id,hdrug1,hdrug2,hdrug3,hdrug4,hdrug5,hdrug6,hdrug7,hdrug8,hdrug9);
				hdrugs.add(hdrug);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.close();
		}
		return hdrugs;
	}
	
	public int getTotalCount(String ypmc) {
		String sql = "select id,ypbh,ypmc,lb,sccs,yptm,ggxh,pzwh,bz,jg  from huxixitong where 1=1";
		List<Object> params =new ArrayList<Object>();
		if(ypmc!=null && !"".equals(ypmc)){
			sql =sql +" and ypmc like ?";
			params.add("%"+ypmc+"%");
		}

		int result = executeTotalCountForPages(sql, params);
		return this.executeTotalCountForPages(sql, params);
	}
//找所有药	
	public List<HDrug> findAllHDrugs(){
		List<HDrug> hdrugs = new ArrayList<HDrug>();
		String query = "select id,ypbh,ypmc,lb,sccs,yptm,ggxh,pzwh,bz,jg  from huxixitong";
		ResultSet rs = this.executeQuery(query, null);
		//将数据从rs中取出并封装成User对象
		try {
			while(rs.next()){                            
				int  id= rs.getInt("id");
				String hdrug1 = rs.getString("ypbh");
				String hdrug2 = rs.getString("ypmc");
				String hdrug3 = rs.getString("lb");
				String hdrug4 = rs.getString("sccs");
				String hdrug5 = rs.getString("yptm");
				String hdrug6 = rs.getString("ggxh");
				String hdrug7 = rs.getString("pzwh");
				String hdrug8 = rs.getString("bz");
				double hdrug9 = rs.getDouble("jg");
				HDrug hdrug = new HDrug(id,hdrug1,hdrug2,hdrug3,hdrug4,hdrug5,hdrug6,hdrug7,hdrug8,hdrug9);

				hdrugs.add(hdrug);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.close();
		}
		return hdrugs;
	}
//根据id返数据	
	public HDrug findHDrugById(String id) {
		String query = " select ypbh,ypmc,lb,sccs,yptm,ggxh,pzwh,bz,jg  from huxixitong where id = ?";
		List<Object> params = new ArrayList<Object>();
		params.add(id);
		ResultSet rs = this.executeQuery(query, params);
		try {
			if(rs.next()){
				String hdrug1 = rs.getString("ypbh");
				String hdrug2 = rs.getString("ypmc");
				String hdrug3 = rs.getString("lb");
				String hdrug4 = rs.getString("sccs");
				String hdrug5 = rs.getString("yptm");
				String hdrug6 = rs.getString("ggxh");
				String hdrug7 = rs.getString("pzwh");
				String hdrug8 = rs.getString("bz");
				double hdrug9 = rs.getDouble("jg");
				HDrug hdrug = new HDrug(hdrug1,hdrug2,hdrug3,hdrug4,hdrug5,hdrug6,hdrug7,hdrug8,hdrug9);
				return hdrug;
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
