package com.jyj.service;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import com.jyj.dao.BaseDao;
import com.jyj.entity.Ghd;
import com.jyj.entity.Ks;



public class GhglService extends BaseDao {

	

	public List<Ghd> findGhds(Integer pageSize, Integer pageNo, String g_id) {
		String sql = " select g_id,p_account,p_age,p_sex,p_address,d_name,szks,szyy from ghd where 1=1 ";
			List<Object> params = new ArrayList<Object>();
			if(g_id!=null && !"".equals(g_id)){
				sql += " and g_id like ?";
				params.add("%"+g_id+"%");
			}
			params.add((Integer.valueOf(pageNo)-1)*Integer.valueOf(pageSize));
			params.add(Integer.valueOf(pageSize));
			List<Ghd> ghds = new ArrayList<Ghd>();
			ResultSet rs = this.executeQueryForPages(sql, params);
			try {
				while(rs.next()){
					int g_id2 = rs.getInt("g_id");
					String p_account = rs.getString("p_account");
					String p_age = rs.getString("p_age");
					String p_sex = rs.getString("p_sex");
					String p_address = rs.getString("p_address");
					String d_name = rs.getString("d_name");
					String szks = rs.getString("szks");
					String szyy = rs.getString("szyy");
										
					Ghd ghd= new Ghd(g_id2,p_account,p_age,p_sex,p_address,d_name,szks,szyy);
					ghds.add(ghd);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				this.close();
			}
			return ghds;
	}
	public int findGhdsTotalCount(String g_id) {
		String sql = " select g_id,p_account,p_age,p_sex,p_address,d_name,szks,szyy from ghd where 1=1 ";
		List<Object> params = new ArrayList<Object>();
		if(g_id!=null && !"".equals(g_id)){
			sql += " and g_id like ?";
			params.add("%"+g_id+"%");
		}
		 return this.executeTotalCountForPages(sql, params);
	}
		
	
	
	
	
	
	public int addGhd(Ghd ghd){
		int result = 0;
		String sql = " insert into Ghd( p_account,p_age,p_sex,p_address,d_name,szks,szyy) values (?,?,?,?,?,?,?)";
		List<Object> params = new ArrayList<Object>();
		//params.add(ghd.getG_id());
		params.add(ghd.getP_account());
		
		//params.add(ghd.getId());
		params.add(ghd.getP_age());
		params.add(ghd.getP_sex());
		params.add(ghd.getP_address());
		params.add(ghd.getD_name());
		params.add(ghd.getSzks());
		params.add(ghd.getSzyy());
		
		
		
		
		result= this.executeUpdate(sql, params);
		return result;
	}


	

	
}
