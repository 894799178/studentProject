package com.test.student.db;

import java.sql.Connection;
import java.sql.SQLException;

import javax.activation.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.DataSources;

/**
 * JDBC 操作的工具类
 * @author 007
 *
 */
public class JDBCUtils {
	/**
	 * 释放Connection 连接
	 * @param connection
	 */
	public static void releaseConnection(Connection connection){
		try {
			if(connection != null){
				connection.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			
		}
	}
	
	private static javax.sql.DataSource dataSource = null;
	
	static{
		//连接只需要被创建一次.
		dataSource  = new ComboPooledDataSource("studentapp");
	}
	/**
	 * 返回一个数据源的一个Connection 对象
	 * @return
	 * @throws SQLException 
	 */
	public static Connection getConnection() throws SQLException{
		return dataSource.getConnection();
	}
}
