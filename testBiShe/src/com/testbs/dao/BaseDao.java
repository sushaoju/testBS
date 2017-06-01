package com.testbs.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class BaseDao {

	//创建链接
		private final String URL="jdbc:mysql://127.0.0.1:3306/hrs?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull";
		private final String USER_NAME="root";
		private final String USER_PWD="111111";
		
		private Connection conn=null;
		private PreparedStatement pstmt = null;
		private ResultSet rs = null;
		
		static{
			//加载驱动
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}
		}
		
		
		private Connection getConnection(){
			try {
				Connection conn= DriverManager.getConnection(URL,USER_NAME,USER_PWD);
				return conn;
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			return null;
		}
		
		/**
		 * 执行增删改
		 * @return
		 */
		public int executeUpdate(String sql,List<Object> params){
			//
			int result = 0;
			conn = getConnection();
			try {
				pstmt = conn.prepareStatement(sql);
				if(params!=null){
					for(int i=0;i<params.size();i++){
						pstmt.setObject(i+1, params.get(i));
					}
				}
				result =pstmt.executeUpdate();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}finally{
				close();
			}
			return result;
		}
		
		/**
		 * 查询的方法
		 * @param sql
		 * @param params
		 * @return
		 */
		public ResultSet executeQuery(String sql,List<Object> params){
			conn =getConnection();
			try {
				pstmt = conn.prepareStatement(sql);
				if(params!=null){
					for(int i=0;i<params.size();i++){
						pstmt.setObject(i+1, params.get(i));
					}
				}
				rs = pstmt.executeQuery();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return rs;
		}
		
		/**
		 * 主要用于分页
		 * @param sql
		 * @param params
		 * @return
		 */
		public ResultSet executeQueryForPages(String sql,List<Object> params){
			sql="select * from ("+sql+") x limit ?,?";
			return this.executeQuery(sql, params);
		}
		
		/**
		 * 计算符合条件的记录数
		 * @param sql
		 * @param params
		 * @return
		 */
		public int executeTotalCountForPages(String sql,List<Object> params){
			sql="select count(1) as num from("+sql+") x";
			ResultSet rs=this.executeQuery(sql, params);
			try {
				if(rs.next()){
					int result=rs.getInt("num");
					return result;
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}finally{
				this.close();
			}
			return 0;
		}
		
		
		/**
		 * 关闭资源
		 */
		public void close(){
			try {
				if(rs!=null){
					rs.close();
					rs=null;
				}
				if(pstmt!=null){
					pstmt.close();
					pstmt=null;
				}
				if(conn!=null){
					conn.close();
					conn=null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
}
