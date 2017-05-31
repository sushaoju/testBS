package com.testbs.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.testbs.dao.BaseDao;
import com.testbs.entity.JobInfo;

public class JobInfoService extends BaseDao{
	//分页	
			public List<JobInfo> getJobInfoForPage(String stuffID,Integer pageNo,Integer pageSize) {
				String query="select *  from jobinfo where 1=1";
				List<Object> params =new ArrayList<Object>();
		        //搜索的条件
				if(stuffID!=null && !"".equals(stuffID)){
					query =query +" and stuffID like ?";
					params.add("%"+stuffID+"%");
				}

				params.add((pageNo-1)*pageSize);
				params.add(pageSize);
				List<JobInfo> jobInfos = new ArrayList<JobInfo>();
				ResultSet rs= this.executeQueryForPages(query, params);
				try {
					while(rs.next()){
						int  id= rs.getInt("id");
						String stuffID1 = rs.getString("stuffID");
						String stuffName = rs.getString("stuffName");
						String stuffDepart = rs.getString("stuffDepart");	
						String stuffDuty = rs.getString("stuffDuty");
						String stuffStatus = rs.getString("stuffStatus");
						String stuffEntryDate = rs.getString("stuffEntryDate");
						String contractBegin = rs.getString("contractBegin");
						String contractEnd = rs.getString("contractEnd");
						Double stuffMoney = rs.getDouble("stuffMoney");
						String adjustJob = rs.getString("adjustJob");
						String adjustMoney = rs.getString("adjustMoney");
						
						
						JobInfo jobInfo = new JobInfo( id,  stuffID1, stuffName,stuffDepart, stuffDuty,stuffStatus,
								stuffEntryDate, contractBegin,contractEnd,stuffMoney, adjustJob, adjustMoney);
						
						jobInfos.add(jobInfo);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}finally{
					this.close();
				}
				return jobInfos;
			}
			
			public int getTotalCount(String stuffID) {
				String sql = "select *  from jobinfo where 1=1";
				List<Object> params =new ArrayList<Object>();
				if(stuffID!=null && !"".equals(stuffID)){
					sql =sql +" and stuffID like ?";
					params.add("%"+stuffID+"%");
				}

				int result = executeTotalCountForPages(sql, params);
				return this.executeTotalCountForPages(sql, params);
			}
			
			//找所有员工岗位信息
			public List<JobInfo> findAllJobInfos(){
				List<JobInfo> jobInfos = new ArrayList<JobInfo>();
				String query = "select *  from jobinfo";
				ResultSet rs = this.executeQuery(query, null);
				//将数据从rs中取出并封装成User对象
				try {
					while(rs.next()){                            
						int  id= rs.getInt("id");
						String stuffID1 = rs.getString("stuffID");
						String stuffName = rs.getString("stuffName");
						String stuffDepart = rs.getString("stuffDepart");	
						String stuffDuty = rs.getString("stuffDuty");
						String stuffStatus = rs.getString("stuffStatus");
						String stuffEntryDate = rs.getString("stuffEntryDate");
						String contractBegin = rs.getString("contractBegin");
						String contractEnd = rs.getString("contractEnd");
						Double stuffMoney = rs.getDouble("stuffMoney");
						String adjustJob = rs.getString("adjustJob");
						String adjustMoney = rs.getString("adjustMoney");
									
						JobInfo jobInfo = new JobInfo( id,  stuffID1, stuffName,stuffDepart, stuffDuty,stuffStatus,stuffEntryDate, contractBegin,contractEnd,stuffMoney, adjustJob, adjustMoney);
						jobInfos.add(jobInfo);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}finally{
					this.close();
				}
				return jobInfos;
			}
		
			//根据id返数据	
			public JobInfo findJobInfoById(String stuffID) {
				
				List<Object> params = new ArrayList<Object>();
				 params.add(stuffID);		
				 
				 String	query = " select *  from  jobinfo where stuffID = ?";			
				ResultSet rs = this.executeQuery(query, params);
				
				try {
					if(rs.next()){
						int  id= rs.getInt("id");
						String stuffID1 = rs.getString("stuffID");
						String stuffName = rs.getString("stuffName");
						String stuffDepart = rs.getString("stuffDepart");	
						String stuffDuty = rs.getString("stuffDuty");
						String stuffStatus = rs.getString("stuffStatus");
						String stuffEntryDate = rs.getString("stuffEntryDate");
						String contractBegin = rs.getString("contractBegin");
						String contractEnd = rs.getString("contractEnd");
						Double stuffMoney = rs.getDouble("stuffMoney");
						String adjustJob = rs.getString("adjustJob");
						String adjustMoney = rs.getString("adjustMoney");
						
						
						JobInfo jobInfo = new JobInfo( id,  stuffID1, stuffName,stuffDepart, stuffDuty,stuffStatus,
								stuffEntryDate, contractBegin,contractEnd,stuffMoney, adjustJob, adjustMoney);
						return jobInfo;
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
			public int updateJobInfo(JobInfo jobInfo) {
				String update =" update jobinfo set adjustJob = ?,adjustMoney = ? where stuffID = ? ";
				List<Object> params = new ArrayList<Object>();
//				params.add(departmentInfo.getId());
				
				params.add(jobInfo.getAdjustJob());
				params.add(jobInfo.getAdjustMoney());
				params.add(jobInfo.getStuffID());
		
				return this.executeUpdate(update, params);
			}

			//删除
		     public int delJobInfoId(String stuffID){
				
				    String sql="delete from jobinfo where stuffID= ?";
				    List<Object> params = new ArrayList<Object>();
				    params.add(stuffID);
				   return this.executeUpdate(sql, params);
			}
			
		     //增加
			public int addJobInfo(JobInfo jobInfo){
				int result = 0;
				String sql = " insert into jobinfo(stuffID,stuffName,stuffDepart,stuffDuty,stuffStatus,stuffEntryDate,contractBegin,contractEnd,stuffMoney,adjustJob,adjustMoney) values (?,?,?,?,?,?,?,?,?,?,?)";
				List<Object> params = new ArrayList<Object>(15);
				params.add(jobInfo.getStuffID());
				params.add(jobInfo.getStuffName());
				params.add(jobInfo.getStuffDepart());
				params.add(jobInfo.getStuffDuty());
				params.add(jobInfo.getStuffStatus());
				params.add(jobInfo.getStuffEntryDate());
				params.add(jobInfo.getContractBegin());
				params.add(jobInfo.getContractEnd());
				params.add(jobInfo.getStuffMoney());
				params.add(jobInfo.getAdjustMoney());
				params.add(jobInfo.getAdjustJob());
				result= this.executeUpdate(sql, params);
				return result;
			}
			
	}
