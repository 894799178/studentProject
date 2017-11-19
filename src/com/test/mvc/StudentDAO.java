package com.test.mvc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
	
	/**
	 * 更新数据库中的数据
	 * @param id 来用查找所要修改的ID
	 * @param name
	 * @param age
	 * @param emill
	 */
	
	public void updataStudent(int id,String name,int age,String emill){
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			String driverClas = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql:///user_test";
			String user = "root";
			String password = "2098231.xzm";		
			Class.forName(driverClas);
			connection = DriverManager.getConnection(url, user, password);
			String sql = "update students set name=?, age= ?, emill=? where id = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			preparedStatement.setInt(2, age);
			preparedStatement.setString(3,emill);
			preparedStatement.setInt(4, id);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			if(preparedStatement != null){
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(connection != null){
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	/**
	 *  向user_test表中插入数据
	 * @param name
	 * @param age
	 * @param emill
	 */
	public void insterStudent(String name,int age,String emill){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			String driverClas = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql:///user_test";
			String user = "root";
			String password = "2098231.xzm";		
			Class.forName(driverClas);
			connection = DriverManager.getConnection(url, user, password);
			String sql = "insert into students (name,age,emill) values(?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			preparedStatement.setInt(2, age);
			preparedStatement.setString(3,emill);
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			if(preparedStatement != null){
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(connection != null){
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	
	/**
	 * 通过id 删除对应的数据
	 * @param id
	 */
	public void deleteById(int id){
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			String driverClas = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql:///user_test";
			String user = "root";
			String password = "2098231.xzm";
			
			Class.forName(driverClas);
			connection = DriverManager.getConnection(url, user, password);
			String sql = "delete FROM students where id = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			if(preparedStatement != null){
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(connection != null){
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	/**
	 *  查询出所有的数据
	 * @return 返回一个list 集合 <Student>
	 */
	public List<Student> getAll(){
		List<Student> students = new ArrayList<Student>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			String driverClas = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql:///user_test";
			String user = "root";
			String password = "2098231.xzm";
			
			Class.forName(driverClas);
			connection = DriverManager.getConnection(url, user, password);
			String sql = "SELECT id,name, age,emill FROM students";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				int id = resultSet.getInt(1);
				String name = resultSet.getString(2);
				int age = resultSet.getInt(3);
				String emill = resultSet.getString(4);
				Student student = new Student(id,name, age, emill);
				students.add(student);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(resultSet != null){
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(preparedStatement != null){
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(connection != null){
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return students;
	}
	                               
}
