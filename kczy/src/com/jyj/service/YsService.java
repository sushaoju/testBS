
	package com.jyj.service;

	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.ArrayList;
	import java.util.List;


	import com.jyj.dao.BaseDao;
import com.jyj.entity.Ks;
	import com.jyj.entity.Patient;
import com.jyj.entity.Ys;

	public class YsService extends BaseDao{
			
		public List<Ys> findYsByKsbh( String ksbh,Integer pageSize, Integer pageNo) {
			String query = " select id,d_name,age,sex,phone,address,ksbh,szks,zc,szyy from doctor  where ksbh= ?";
			List<Object> params = new ArrayList<Object>();
			params.add(ksbh);
			params.add((Integer.valueOf(pageNo)-1)*Integer.valueOf(pageSize));
			params.add(Integer.valueOf(pageSize));
			
			List<Ys> yss = new ArrayList<Ys>();
			ResultSet rs = this.executeQueryForPages(query, params);
			try {
				while(rs.next()){
				
					String id = rs.getString("id");
					String d_name = rs.getString("d_name");

					String age = rs.getString("age");
					String sex = rs.getString("sex");
					String phone=rs.getString("phone");
					
					String address=rs.getString("address");
					String ksbh2=rs.getString("ksbh");
					String szks=rs.getString("szks");
					String zc=rs.getString("zc");
					String szyy=rs.getString("szyy");
					
					Ys ys=new Ys(id,d_name,age,sex,phone,address,ksbh2,szks,zc,szyy);
					yss.add(ys);
					}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				this.close();
			}
			return yss;
	
		}

		public int findyssTotalCount(String ksbh) {
			
				String sql = "select id,d_name,age,sex,phone,address,ksbh,szks,zc,szyy from doctor  where ksbh= ?";
				List<Object> params = new ArrayList<Object>();
				params.add(ksbh);
				 return this.executeTotalCountForPages(sql, params);
			
			// TODO Auto-generated method stub
		
		}

		public Ys findysById(String id) {
			String query = " select id,d_name,szks,szyy from doctor  where id = ?";
			List<Object> params = new ArrayList<Object>();
			params.add(id);
			ResultSet rs = this.executeQuery(query, params);
			try {
				if(rs.next()){
					String id2 = rs.getString("id");
					String d_name = rs.getString("d_name");

					String szks = rs.getString("szks");
					String szyy = rs.getString("szyy");
					
					
					
					Ys ys = new Ys();
					ys.setId(id);
					ys.setD_name(d_name);
					
					ys.setSzks(szks);
					ys.setSzyy(szyy);
					
					
					
					return ys;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				this.close();
			}
			return null;
		
			// TODO Auto-generated method stub
			
		}

		
					
					//Ys ys = new Ys();
					//ys.setId(id);
					//ys.setName(name);
					
					//ys.setAge(age);
					//ys.setSex(sex);
					
		
					//ys.setNumber(number);
					//ys.setAddress(address);
					//ys.setKsbh2(ksbh2);
					//ys.setSzks(szks);
					
					//ys.setZc(zc);
					
					//ys.setSzyy(szyy);
					//xtyh.setBmmc(bmmc);
					
					//return ys;
			
		
	}


