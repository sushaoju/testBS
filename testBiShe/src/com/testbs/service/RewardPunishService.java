package com.testbs.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.testbs.dao.BaseDao;
import com.testbs.entity.RewardPunish;


public class RewardPunishService extends BaseDao {
	//分页	
	public List<RewardPunish> getRewardPunishForPage(String stuffID,String stuffName,Integer pageNo,Integer pageSize) {
		String query="select * from rewardpunish where 1=1";
		List<Object> params =new ArrayList<Object>();
        //搜索的条件
		if(stuffID!=null && !"".equals(stuffID)){
			query =query +" and stuffID like ?";
			params.add("%"+stuffID+"%");
		}
		if(stuffName!=null && !"".equals(stuffName)){
			query =query +" and stuffName like ?";
			params.add("%"+stuffName+"%");
		}

		params.add((pageNo-1)*pageSize);
		params.add(pageSize);
		List<RewardPunish> rewardPunishs = new ArrayList<RewardPunish>();
		ResultSet rs= this.executeQueryForPages(query, params);
		try {
			while(rs.next()){
				int id= rs.getInt("id");
				String stuffID1 = rs.getString("stuffID");
				String stuffName1 = rs.getString("stuffName");
				String stuffDepart = rs.getString("stuffDepart");
				String happenDate=rs.getString("happenDate");
				String happenType=rs.getString("happenType");
				String happenReason=rs.getString("happenReason");
				double changeMoney=rs.getDouble("changeMoney");
				
				RewardPunish rewardPunish = new RewardPunish(id,stuffID1,stuffName1,
						stuffDepart,happenDate,happenType,happenReason,changeMoney);
				rewardPunishs.add(rewardPunish);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.close();
		}
		return rewardPunishs;
	}
	
	public int getTotalCount(String stuffID) {
		String sql = "select * from rewardpunish where 1=1";
		List<Object> params =new ArrayList<Object>();
		if(stuffID!=null && !"".equals(stuffID)){
			sql =sql +" and stuffID like ?";
			params.add("%"+stuffID+"%");
		}

		int result = executeTotalCountForPages(sql,params);
		return this.executeTotalCountForPages(sql,params);
	}
	
	//根据条件返数据
	public List<RewardPunish> findRewardPunishByCondition(String stuffID,String stuffName,String stuffDepart) {
		List<RewardPunish> rewardPunishs = new ArrayList<RewardPunish>();
		List<Object> paramsTemp = new ArrayList<Object>();
		List<Object> params = new ArrayList<Object>();
						 
		 String	query ="";
		 ResultSet rs;
		 
		 if((stuffID!=""&&stuffID!=null)&&(stuffName!=""&&stuffName!=null)&&(stuffDepart!=""&&stuffDepart!=null)){
			 params.add(stuffID);		
			 params.add(stuffName);
			 params.add(stuffDepart);
			 paramsTemp=params;
			 
			 query = " select *  from  rewardpunish  where stuffID = ? and stuffName = ? and stuffDepart =?";			
			
		 }
		 else  if((stuffID==""||stuffID==null)&&(stuffDepart==""||stuffDepart==null)&&(stuffName!=""&&stuffName!=null)){
			
			 params.add(stuffName);
			 paramsTemp=params;		
			 query="select *  from  rewardpunish  where stuffName = ?";
		 }
		 else  if((stuffID==""||stuffID==null)&&(stuffName==""||stuffName==null)&&(stuffDepart!=""&&stuffDepart!=null)){
			
			 params.add(stuffDepart);
			 paramsTemp=params;
			 query="select *  from  rewardpunish  where stuffDepart = ?";
		 }
		 else  if((stuffDepart==""||stuffDepart==null)&&(stuffName==""||stuffName==null)&&(stuffID!=""&&stuffID!=null)){
			 
			 params.add(stuffID);
			 paramsTemp=params;
			 query="select *  from  rewardpunish  where stuffID = ?";
		 }
		 else  if((stuffID!=""||stuffID!=null)&&(stuffName!=""||stuffName!=null)&&(stuffDepart==""&&stuffDepart==null)){
			 params.add(stuffID);
			 params.add(stuffName);
			 paramsTemp=params;
			 query="select *  from  rewardpunish  where stuffID = ? and stuffName = ?";
		 }
		 else  if((stuffID!=""||stuffID!=null)&&(stuffName==""||stuffName==null)&&(stuffDepart!=""&&stuffDepart!=null)){
			 
			 params.add(stuffID);
			 params.add(stuffDepart);
			 paramsTemp=params;
			 query="select *  from  rewardpunish  where stuffID = ? and stuffDepart =?";
		 }
		 else  if((stuffID==""||stuffID==null)&&(stuffName!=""||stuffName!=null)&&(stuffDepart!=""&&stuffDepart!=null)){
			 
			 params.add(stuffName);
			 params.add(stuffDepart);
			 paramsTemp=params;
			 query="select *  from  rewardpunish  where stuffName = ? and stuffDepart =?";
		 }
				 
		 rs = this.executeQuery(query, paramsTemp);
		 
		try {
			while(rs.next()){     
			        String stuffID1 = rs.getString("stuffID");	
					String stuffName1=rs.getString("stuffName");
					String stuffDepart1=rs.getString("stuffDepart");
					String happenDate=rs.getString("happenDate");
					String happenType=rs.getString("happenType");
					String happenReason=rs.getString("happenReason");
					double changeMoney=rs.getDouble("changeMoney");
								
					RewardPunish rewardPunish = new RewardPunish(stuffID1,stuffName1,stuffDepart1,happenDate,happenType,happenReason,changeMoney);
					rewardPunishs.add(rewardPunish);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.close();
		}
		return rewardPunishs;
	}

	
	
	//找所有部门信息
	public List<RewardPunish> findAllRewardPunishs(){
		List<RewardPunish> rewardPunishs = new ArrayList<RewardPunish>();
		String query = "select * from rewardpunish";
		ResultSet rs = this.executeQuery(query, null);
		//将数据从rs中取出并封装成User对象
		try {
			while(rs.next()){                            
				int  id= rs.getInt("id");
				String stuffID1 = rs.getString("stuffID");
				String stuffName = rs.getString("stuffName");
				String stuffDepart = rs.getString("stuffDepart");
				String happenDate=rs.getString("happenDate");
				String happenType=rs.getString("happenType");
				String happenReason=rs.getString("happenReason");
				double changeMoney=rs.getDouble("changeMoney");
				
				RewardPunish rewardPunish = new RewardPunish(id,stuffID1,stuffName,
						stuffDepart,happenDate,happenType,happenReason,changeMoney);
				rewardPunishs.add(rewardPunish);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.close();
		}
		return rewardPunishs;
	}

	//根据id返数据	
	public RewardPunish findRewardPunishById(String stuffID) {
		
		List<Object> params = new ArrayList<Object>();
		 params.add(stuffID);		
		 
		 String	query = " select * from rewardpunish where stuffID=?";			
		ResultSet rs = this.executeQuery(query, params);
		
		try {
			if(rs.next()){
			     int  id= rs.getInt("id");
			     String stuffID1 = rs.getString("stuffID");
					String stuffName = rs.getString("stuffName");
					String stuffDepart = rs.getString("stuffDepart");
					String happenDate=rs.getString("happenDate");
					String happenType=rs.getString("happenType");
					String happenReason=rs.getString("happenReason");
					double changeMoney=rs.getDouble("changeMoney");
					
					RewardPunish rewardPunish = new RewardPunish(id,stuffID1,stuffName,
							stuffDepart,happenDate,happenType,happenReason,changeMoney);
				return rewardPunish;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.close();
		}
		return null;
	}
  
	
	//修改	
	public int updateRewardPunish(RewardPunish rewardPunish) {
		String update =" update rewardpunish set stuffName=?,stuffDepart=?,happenDate=?,happenType=?,happenReason=?,changeMoney=? where stuffID=? ";
		List<Object> params = new ArrayList<Object>();
//		params.add(departmentInfo.getId());
		
		params.add(rewardPunish.getStuffName());
		params.add(rewardPunish.getStuffDepart());
		params.add(rewardPunish.getHappenDate());
		params.add(rewardPunish.getHappenType());
		params.add(rewardPunish.getHappenReason());
		params.add(rewardPunish.getChangeMoney());
		params.add(rewardPunish.getStuffID());

		return this.executeUpdate(update, params);
	}

	//删除部门
     public int delRewardPunishId(String stuffID){
		
		    String sql="delete from rewardpunish where stuffID=?";
		    List<Object> params = new ArrayList<Object>();
		    params.add(stuffID);
		   return this.executeUpdate(sql, params);
	}
	
     //增加部门
	public int addRewardPunish(RewardPunish rewardPunish){
		int result = 0;
		String sql = " insert into rewardpunish(stuffID,stuffName,stuffDepart,happenDate,happenType,happenReason,changeMoney) values (?,?,?,?,?,?,?)";
		List<Object> params = new ArrayList<Object>();
		params.add(rewardPunish.getStuffID());
		params.add(rewardPunish.getStuffName());
		params.add(rewardPunish.getStuffDepart());
		params.add(rewardPunish.getHappenDate());
		params.add(rewardPunish.getHappenType());
		params.add(rewardPunish.getHappenReason());
		params.add(rewardPunish.getChangeMoney());
		result= this.executeUpdate(sql, params);
		return result;
	}
	
}


