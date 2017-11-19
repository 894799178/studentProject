package com.test.student.test;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;

import com.test.student.dao.StudentDAO;
import com.test.student.dao.impl.StudentDAOJDBCImpl;
import com.test.student.db.JDBCUtils;
import com.test.student.domain.Student;

public class jdbcUtilsTest {
	
	@Test
	public void testGetConnection() throws SQLException{
		Connection connection = JDBCUtils.getConnection();
		
		System.out.println(connection);
	}
	
}
