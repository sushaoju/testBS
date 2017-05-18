package com.jyj.service;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import com.jyj.dao.BaseDao;
import com.jyj.entity.Ks;



public class KsService extends BaseDao {

	

	public List<Ks> findKs(Integer pageSize, Integer pageNo, String ksbh) {
		String sql = " select id,ksbh,ksmc from ksgl where 1=1";
			List<Object> params = new ArrayList<Object>();
			if(ksbh!=null && !"".equals(ksbh)){
				sql += " and ksbh like ?";
				params.add("%"+ksbh+"%");
			}
			params.add((Integer.valueOf(pageNo)-1)*Integer.valueOf(pageSize));
			params.add(Integer.valueOf(pageSize));
			List<Ks> kss = new ArrayList<Ks>();
			ResultSet rs = this.executeQueryForPages(sql, params);
			try {
				while(rs.next()){
					int id = rs.getInt("id");
					String ksbh2 = rs.getString("ksbh");
					String ksmc = rs.getString("ksmc");
					
					Ks ks= new Ks(id,ksbh2,ksmc);
					kss.add(ks);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				this.close();
			}
			return kss;
	}
	public int findKssTotalCount(String ksbh) {
		String sql = " select id,ksbh,ksmc from ksgl where 1=1";
		List<Object> params = new ArrayList<Object>();
		if(ksbh!=null && !"".equals(ksbh)){
			sql += " and ksbh like ?";
			params.add("%"+ksbh+"%");
		}
		 return this.executeTotalCountForPages(sql, params);
	}
	
	public Ks findKsById(String id) {
		String query = " select id,ksbh,ksmc from ksgl where id = ?";
		List<Object> params = new ArrayList<Object>();
		params.add(id);
		ResultSet rs = this.executeQuery(query, params);
		try {
			if(rs.next()){
				int id2 = rs.getInt("id");
				String ksbh = rs.getString("ksbh");

				String ksmc = rs.getString("ksmc");
				
				
				
				Ks ks = new Ks();
				ks.setId(id2);

				ks.setKsbh(ksbh);
				ks.setKsmc(ksmc);
				
				return ks;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.close();
		}
		return null;
	}
		
		


	public int updateKs(Ks ks) {
		String update="update ksgl set ksmc=?   where ksbh=?";
		List<Object> params=new ArrayList<Object>();
		params.add(ks.getKsmc());
		
		params.add(ks.getKsbh());
		return this.executeUpdate(update, params);
		
	}

	
	


	}

	
	

	

	

	

	

