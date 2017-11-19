package com.test.student.db;

import java.sql.Connection;
import java.sql.SQLException;

import javax.activation.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.DataSources;

/**
 * JDBC �����Ĺ�����
 * @author 007
 *
 */
public class JDBCUtils {
	/**
	 * �ͷ�Connection ����
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
		//����ֻ��Ҫ������һ��.
		dataSource  = new ComboPooledDataSource("studentapp");
	}
	/**
	 * ����һ������Դ��һ��Connection ����
	 * @return
	 * @throws SQLException 
	 */
	public static Connection getConnection() throws SQLException{
		return dataSource.getConnection();
	}
}
