package com.jyj.service;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;




import com.jyj.dao.BaseDao;
import com.jyj.entity.Fkd;
import com.jyj.entity.Ghd;




public class FkdService extends BaseDao {

	

	public List<Fkd> findFkds(Integer pageSize, Integer pageNo, String p_account) {
		String sql = " select id,p_account,ghf,wzfy,cfdje,zje,sgks,d_name,ypmc from fkd where 1=1";
	
			List<Object> params = new ArrayList<Object>();
			if(p_account!=null && !"".equals(p_account)){
				sql += " and p_account like ?";
				params.add("%"+p_account+"%");
			}
			params.add((Integer.valueOf(pageNo)-1)*Integer.valueOf(pageSize));
			params.add(Integer.valueOf(pageSize));
			List<Fkd> fkds = new ArrayList<Fkd>();
			ResultSet rs = this.executeQueryForPages(sql, params);
			try {
				while(rs.next()){
					int id = rs.getInt("id");
					String p_account2 = rs.getString("p_account");
					String ghf = rs.getString("ghf");
					String wzfy = rs.getString("wzfy");
					String cfdje = rs.getString("cfdje");
					String zje = rs.getString("zje");
					String sgks = rs.getString("sgks");
					String d_name = rs.getString("d_name");
					String ypmc = rs.getString("ypmc");
										
					Fkd fkd= new Fkd(id,p_account2,ghf,wzfy,cfdje,zje,sgks,d_name,ypmc);
					fkds.add(fkd);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				this.close();
			}
			return fkds;
	}
	public int findFkdsTotalCount(String p_account) {
		String sql = " select id,p_account,ghf,wzfy,cfdje,zje,sgks,d_name,ypmc from fkd where 1=1";
		List<Object> params = new ArrayList<Object>();
		if(p_account!=null && !"".equals(p_account)){
			sql += " and p_account like ?";
			params.add("%"+p_account+"%");
		}
		 return this.executeTotalCountForPages(sql, params);
	}
	public int addFkd(Fkd fkd) {
			int result = 0;
			String sql = " insert into Fkd(p_account,ghf,wzfy,cfdje,zje) values (?,?,?,?,?)";
			List<Object> params = new ArrayList<Object>();
			//params.add(ghd.getG_id());
			params.add(fkd.getP_account());
			
			//params.add(ghd.getId());
			params.add(fkd.getGhf());
			params.add(fkd.getWzfy());
			params.add(fkd.getCfdje());
			params.add(fkd.getZje());
			result= this.executeUpdate(sql, params);
			return result;
		


		// TODO Auto-generated method stub
		
	}
	public Fkd findfkdById(String id) {
		
			String query = " select id,p_account,ghf,wzfy,cfdje,zje,sgks,d_name,ypmc from fkd where id = ?";
			List<Object> params = new ArrayList<Object>();
			params.add(id);
			ResultSet rs = this.executeQuery(query, params);
			try {
				if(rs.next()){
					int id2 = rs.getInt("id");
					String p_account = rs.getString("p_account");

					String ghf = rs.getString("ghf");
					String wzfy = rs.getString("wzfy");
					String cfdje=rs.getString("cfdje");
					String zje=rs.getString("zje");
					String sgks=rs.getString("sgks");
					String d_name=rs.getString("d_name");
					String ypmc=rs.getString("ypmc");
					
					
					
					Fkd fkd = new Fkd();
					fkd.setId(id2);
					fkd.setP_account(p_account);
					
					fkd.setGhf(ghf);
					fkd.setWzfy(wzfy);
					fkd.setCfdje(cfdje);
					fkd.setZje(zje);
					fkd.setSgks(sgks);
					fkd.setD_name(d_name);
					fkd.setYpmc(ypmc);
					fkd.setId(id2);
					
					
					//xtyh.setBmmc(bmmc);
					
					return fkd;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				this.close();
			}
			return null;
		
		
	}
	public List<Fkd> findFkdsmx(Integer pageNo, Integer pageSize, String id) {
		String sql = " select id,p_account,ghf,wzfy,cfdje,zje,sgks,d_name,ypmc from fkd where id=?";
		
		List<Object> params = new ArrayList<Object>();
		params.add(id);
		//params.add((Integer.valueOf(pageNo)-1)*Integer.valueOf(pageSize));
		//params.add(Integer.valueOf(pageSize));
		List<Fkd> fkdmxs = new ArrayList<Fkd>();
		ResultSet rs = this.executeQuery(sql, params);
		try {
			while(rs.next()){
				int id2 = rs.getInt("id");
				String p_account = rs.getString("p_account");
				String ghf = rs.getString("ghf");
				String wzfy = rs.getString("wzfy");
				String cfdje = rs.getString("cfdje");
				String zje = rs.getString("zje");
				String sgks = rs.getString("sgks");
				String d_name = rs.getString("d_name");
				String ypmc = rs.getString("ypmc");
				
									
				Fkd fkd= new Fkd(id2,p_account,ghf,wzfy,cfdje,zje,sgks,d_name,ypmc);
				fkdmxs.add(fkd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.close();
		}
		return fkdmxs;

		
	}
	
	public int findFkdsTotalCount2(String id) {
		
		String sql = " select id,p_account,ghf,wzfy,cfdje,zje,sgks,d_name,ypmc from fkd where id=?";
		List<Object> params = new ArrayList<Object>();
		params.add(id);
		 return this.executeTotalCountForPages(sql, params);

	

	}

}
	

	

	

	

	

