package com.testbs.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.testbs.dao.BaseDao;
import com.testbs.entity.DimissionInfo;
import com.testbs.entity.TrainInfo;


public class TrainInfoService extends BaseDao {
	//分页	
	public List<TrainInfo> getTrainInfoForPage(String stuffID,String stuffName,Integer pageNo,Integer pageSize) {
		String query="select * from traininfo where 1=1";
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
		List<TrainInfo> trainInfos = new ArrayList<TrainInfo>();
		ResultSet rs= this.executeQueryForPages(query, params);
		try {
			while(rs.next()){
				int id= rs.getInt("id");
				String stuffID1 = rs.getString("stuffID");
				String stuffName1 = rs.getString("stuffName");
				String stuffDepart = rs.getString("stuffDepart");
				String trainType=rs.getString("trainType");
				String trainBegin=rs.getString("trainBegin");
				String trainEnd = rs.getString("trainEnd");
				String trainTeacher=rs.getString("trainTeacher");
				String trainResult=rs.getString("trainResult");
				
				TrainInfo trainInfo = new TrainInfo(id,stuffID1,stuffName1,stuffDepart,trainType,trainBegin,
						trainEnd,trainTeacher,trainResult);
				trainInfos.add(trainInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.close();
		}
		return trainInfos;
	}
	
	public int getTotalCount(String stuffID) {
		String sql = "select * from traininfo where 1=1";
		List<Object> params =new ArrayList<Object>();
		if(stuffID!=null && !"".equals(stuffID)){
			sql =sql +" and stuffID like ?";
			params.add("%"+stuffID+"%");
		}

		int result = executeTotalCountForPages(sql,params);
		return this.executeTotalCountForPages(sql,params);
	}

	
	
	//找所有部门信息
	public List<TrainInfo> findAllTrainInfos(){
		List<TrainInfo> trainInfos = new ArrayList<TrainInfo>();
		String query = "select * from traininfo";
		ResultSet rs = this.executeQuery(query, null);
		//将数据从rs中取出并封装成User对象
		try {
			while(rs.next()){                            
				int  id= rs.getInt("id");
				String stuffID1 = rs.getString("stuffID");
				String stuffName = rs.getString("stuffName");
				String stuffDepart = rs.getString("stuffDepart");	
				String trainType=rs.getString("trainType");
				String trainBegin=rs.getString("trainBegin");
				String trainEnd = rs.getString("trainEnd");	
				String trainTeacher=rs.getString("trainTeacher");
				String trainResult=rs.getString("trainResult");	
				
				TrainInfo trainInfo = new TrainInfo(id,stuffID1,stuffName,stuffDepart,trainType,trainBegin,
						trainEnd,trainTeacher,trainResult);
				trainInfos.add(trainInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.close();
		}
		return trainInfos;
	}

	
	//根据条件返数据
	public List<TrainInfo> findTrainInfoByCondition(String stuffID,String stuffName,String stuffDepart) {
		List<TrainInfo> trainInfos = new ArrayList<TrainInfo>();
		List<Object> paramsTemp = new ArrayList<Object>();
		List<Object> params = new ArrayList<Object>();
						 
		 String	query ="";
		 ResultSet rs;
		 
		 if((stuffID!=""&&stuffID!=null)&&(stuffName!=""&&stuffName!=null)&&(stuffDepart!=""&&stuffDepart!=null)){
			 params.add(stuffID);		
			 params.add(stuffName);
			 params.add(stuffDepart);
			 paramsTemp=params;
			 
			 query = " select *  from  traininfo  where stuffID = ? and stuffName = ? and stuffDepart =?";			
			
		 }
		 else  if((stuffID==""||stuffID==null)&&(stuffDepart==""||stuffDepart==null)&&(stuffName!=""&&stuffName!=null)){
			
			 params.add(stuffName);
			 paramsTemp=params;		
			 query="select *  from  traininfo  where stuffName = ?";
		 }
		 else  if((stuffID==""||stuffID==null)&&(stuffName==""||stuffName==null)&&(stuffDepart!=""&&stuffDepart!=null)){
			
			 params.add(stuffDepart);
			 paramsTemp=params;
			 query="select *  from  traininfo  where stuffDepart = ?";
		 }
		 else  if((stuffDepart==""||stuffDepart==null)&&(stuffName==""||stuffName==null)&&(stuffID!=""&&stuffID!=null)){
			 
			 params.add(stuffID);
			 paramsTemp=params;
			 query="select *  from  traininfo  where stuffID = ?";
		 }
		 else  if((stuffID!=""||stuffID!=null)&&(stuffName!=""||stuffName!=null)&&(stuffDepart==""&&stuffDepart==null)){
			 params.add(stuffID);
			 params.add(stuffName);
			 paramsTemp=params;
			 query="select *  from  traininfo  where stuffID = ? and stuffName = ?";
		 }
		 else  if((stuffID!=""||stuffID!=null)&&(stuffName==""||stuffName==null)&&(stuffDepart!=""&&stuffDepart!=null)){
			 
			 params.add(stuffID);
			 params.add(stuffDepart);
			 paramsTemp=params;
			 query="select *  from  traininfo  where stuffID = ? and stuffDepart =?";
		 }
		 else  if((stuffID==""||stuffID==null)&&(stuffName!=""||stuffName!=null)&&(stuffDepart!=""&&stuffDepart!=null)){
			 
			 params.add(stuffName);
			 params.add(stuffDepart);
			 paramsTemp=params;
			 query="select *  from  traininfo  where stuffName = ? and stuffDepart =?";
		 }
				 
		 rs = this.executeQuery(query, paramsTemp);
		 
		try {
			while(rs.next()){     
			        String stuffID1 = rs.getString("stuffID");	
					String stuffName1=rs.getString("stuffName");
					String stuffDepart1=rs.getString("stuffDepart");
					String trainType=rs.getString("trainType");
					String trainBegin=rs.getString("trainBegin");
					String trainEnd=rs.getString("trainEnd");
					String trainTeacher=rs.getString("trainTeacher");
					String trainResult=rs.getString("trainResult");
								
					TrainInfo trainInfo = new TrainInfo(stuffID1,stuffName1,stuffDepart1,trainType,trainBegin,trainEnd,trainTeacher,trainResult);
					trainInfos.add(trainInfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.close();
		}
		return trainInfos;
	}

	
	
	
	//根据id返数据	
	public TrainInfo findTrainInfoById(String stuffID) {
		
		List<Object> params = new ArrayList<Object>();
		 params.add(stuffID);		
		 
		 String	query = " select * from traininfo where stuffID=?";			
		ResultSet rs = this.executeQuery(query, params);
		
		try {
			if(rs.next()){
			     int  id= rs.getInt("id");
			     String stuffID1 = rs.getString("stuffID");
					String stuffName = rs.getString("stuffName");
					String stuffDepart = rs.getString("stuffDepart");	
					String trainType=rs.getString("trainType");
					String trainBegin=rs.getString("trainBegin");
					String trainEnd = rs.getString("trainEnd");	
					String trainTeacher=rs.getString("trainTeacher");
					String trainResult=rs.getString("trainResult");	
									
					TrainInfo trainInfo = new TrainInfo(id,stuffID1,stuffName,stuffDepart,trainType,trainBegin,
							trainEnd,trainTeacher,trainResult);
				return trainInfo;
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
	public int updateTrainInfo(TrainInfo trainInfo) {
		String update =" update traininfo set stuffName=?,stuffDepart=?,trainType=?,trainBegin=?,trainEnd=?,trainTeacher=?,trainResult=? where stuffID=? ";
		List<Object> params = new ArrayList<Object>();
//		params.add(departmentInfo.getId());
		
		params.add(trainInfo.getStuffName());
		params.add(trainInfo.getStuffDepart());
		params.add(trainInfo.getTrainType());
		params.add(trainInfo.getTrainBegin());
		params.add(trainInfo.getTrainEnd());
		params.add(trainInfo.getTrainTeacher());
		params.add(trainInfo.getTrainResult());
		params.add(trainInfo.getStuffID());

		return this.executeUpdate(update, params);
	}

	//删除部门
     public int delTrainInfoId(String stuffID){
		
		    String sql="delete from traininfo where stuffID=?";
		    List<Object> params = new ArrayList<Object>();
		    params.add(stuffID);
		   return this.executeUpdate(sql, params);
	}
	
     //增加部门
	public int addTrainInfo(TrainInfo trainInfo){
		int result = 0;
		String sql = " insert into traininfo(stuffID,stuffName,stuffDepart,trainType,trainBegin,trainEnd,trainTeacher,trainResult) values (?,?,?,?,?,?,?,?)";
		List<Object> params = new ArrayList<Object>();
		params.add(trainInfo.getStuffID());
		params.add(trainInfo.getStuffName());
		params.add(trainInfo.getStuffDepart());
		params.add(trainInfo.getTrainType());
		params.add(trainInfo.getTrainBegin());
		params.add(trainInfo.getTrainEnd());
		params.add(trainInfo.getTrainTeacher());
		params.add(trainInfo.getTrainResult());
		result= this.executeUpdate(sql, params);
		return result;
	}
	
}


