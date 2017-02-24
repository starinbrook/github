package com.zhuyca.util;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class JdbcUtils {
	
	/*
	 * 获取数据库连接
	 */
	public static Connection getConnection(){
		DriverManagerDataSource ds = new DriverManagerDataSource ();         
		ds.setDriverClassName("com.mysql.jdbc.Driver");         
		ds.setUrl("jdbc:mysql://localhost:3306/test");    
		ds.setUsername("root");         
		ds.setPassword("root");         
		Connection con = null;
		try {
			con = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return con;
	}
	
	/*
	 * 关闭数据库连接
	 */
	public static void closeConnection(Connection con){
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
