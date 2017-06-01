package com.testbs.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.testbs.dao.BaseDao;
import com.testbs.entity.DimissionInfo;
import com.testbs.entity.JobInfo;

public class JobInfoService extends BaseDao{
	//��ҳ	
			public List<JobInfo> getJobInfoForPage(String stuffID,Integer pageNo,Integer pageSize) {
				String query="select *  from jobinfo where 1=1";
				List<Object> params =new ArrayList<Object>();
		        //����������
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
			
			//������Ա����λ��Ϣ
			public List<JobInfo> findAllJobInfos(){
				List<JobInfo> jobInfos = new ArrayList<JobInfo>();
				String query = "select *  from jobinfo";
				ResultSet rs = this.executeQuery(query, null);
				//�����ݴ�rs��ȡ������װ��User����
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
		
			
			//��������������
			public List<JobInfo> findJobInfoByCondition(String stuffID,String stuffName,String stuffDepart) {
				List<JobInfo> jobInfos = new ArrayList<JobInfo>();
				List<Object> paramsTemp = new ArrayList<Object>();
				List<Object> params = new ArrayList<Object>();
								 
				 String	query ="";
				 ResultSet rs;
				 
				 if((stuffID!=""&&stuffID!=null)&&(stuffName!=""&&stuffName!=null)&&(stuffDepart!=""&&stuffDepart!=null)){
					 params.add(stuffID);		
					 params.add(stuffName);
					 params.add(stuffDepart);
					 paramsTemp=params;
					 
					 query = " select *  from  jobinfo  where stuffID = ? and stuffName = ? and stuffDepart =?";			
					
				 }
				 else  if((stuffID==""||stuffID==null)&&(stuffDepart==""||stuffDepart==null)&&(stuffName!=""&&stuffName!=null)){
					
					 params.add(stuffName);
					 paramsTemp=params;		
					 query="select *  from  jobinfo  where stuffName = ?";
				 }
				 else  if((stuffID==""||stuffID==null)&&(stuffName==""||stuffName==null)&&(stuffDepart!=""&&stuffDepart!=null)){
					
					 params.add(stuffDepart);
					 paramsTemp=params;
					 query="select *  from  jobinfo  where stuffDepart = ?";
				 }
				 else  if((stuffDepart==""||stuffDepart==null)&&(stuffName==""||stuffName==null)&&(stuffID!=""&&stuffID!=null)){
					 
					 params.add(stuffID);
					 paramsTemp=params;
					 query="select *  from  jobinfo  where stuffID = ?";
				 }
				 else  if((stuffID!=""||stuffID!=null)&&(stuffName!=""||stuffName!=null)&&(stuffDepart==""&&stuffDepart==null)){
					 params.add(stuffID);
					 params.add(stuffName);
					 paramsTemp=params;
					 query="select *  from  jobinfo  where stuffID = ? and stuffName = ?";
				 }
				 else  if((stuffID!=""||stuffID!=null)&&(stuffName==""||stuffName==null)&&(stuffDepart!=""&&stuffDepart!=null)){
					 
					 params.add(stuffID);
					 params.add(stuffDepart);
					 paramsTemp=params;
					 query="select *  from  jobinfo  where stuffID = ? and stuffDepart =?";
				 }
				 else  if((stuffID==""||stuffID==null)&&(stuffName!=""||stuffName!=null)&&(stuffDepart!=""&&stuffDepart!=null)){
					 
					 params.add(stuffName);
					 params.add(stuffDepart);
					 paramsTemp=params;
					 query="select *  from  jobinfo  where stuffName = ? and stuffDepart =?";
				 }
						 
				 rs = this.executeQuery(query, paramsTemp);
				 
				try {
					while(rs.next()){     
					        String stuffID1 = rs.getString("stuffID");	
							String stuffName1=rs.getString("stuffName");
							String stuffDepart1=rs.getString("stuffDepart");
							String stuffDuty=rs.getString("stuffDuty");	
							
							String stuffStatus = rs.getString("stuffStatus");	
							Double stuffMoney=rs.getDouble("stuffMoney");
							String adjustJob=rs.getString("adjustJob");
							String adjustMoney=rs.getString("adjustMoney");	
										
							JobInfo jobInfo = new JobInfo(stuffID1, stuffName1,stuffDepart1,stuffDuty,stuffStatus,stuffMoney,adjustJob,adjustMoney);
							jobInfos.add(jobInfo);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					this.close();
				}
				return jobInfos;
			}
		
		
			
			
			
			
			
			//����id������	
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
		  		
			//�޸�	
			public int updateJobInfo(JobInfo jobInfo) {
				
				String update =" update jobinfo set stuffID=?, stuffDepart=?,stuffDuty=? , stuffStatus=? ,  "+
				"contractBegin=? ,contractEnd=? ,stuffMoney = ?,adjustJob = ? ,adjustMoney = ? where id = ? ";
				List<Object> params = new ArrayList<Object>();
				
				params.add(jobInfo.getStuffID());
				params.add(jobInfo.getStuffDepart());
				params.add(jobInfo.getStuffDuty());
				params.add(jobInfo.getStuffStatus());
				params.add(jobInfo.getContractBegin());
				params.add(jobInfo.getContractEnd());
				params.add(jobInfo.getStuffMoney());
				params.add(jobInfo.getAdjustJob());
				params.add(jobInfo.getAdjustMoney());
				params.add(jobInfo.getId());
				
				
				
				return this.executeUpdate(update, params);
			}

			//ɾ��
		     public int delJobInfoId(String stuffID){
				
				    String sql="delete from jobinfo where stuffID= ?";
				    List<Object> params = new ArrayList<Object>();
				    params.add(stuffID);
				   return this.executeUpdate(sql, params);
			}
			
		     //����
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
