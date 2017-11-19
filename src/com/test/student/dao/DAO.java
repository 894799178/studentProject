package com.test.student.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.util.Iterator;
import java.util.List;

import javax.enterprise.inject.New;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.test.student.db.JDBCUtils;

/**
 * 
 * 封装了基本的CRUD的方法,以供子类使用
 * 当前DAO直接在方法中获取数据库连接
 * 整个DAO采取DBUtils解决方案
 * @author 007
 * @param <T>当前DAO处理的实体类的类型是什么
 */
public class DAO<T>{
	
	private QueryRunner queryRunner = new QueryRunner();
	private Class<T> clazz;
	
	public DAO() {
		Type superClass = getClass() .getGenericSuperclass();
		if(superClass instanceof ParameterizedType){
			ParameterizedType parameterizedType = (ParameterizedType)superClass;
			Type [] typeArgs = parameterizedType.getActualTypeArguments();
			if(typeArgs != null && typeArgs.length > 0){
				if(typeArgs[0] instanceof Class){
					clazz = (Class<T>)typeArgs[0];
				}
				
			}
		}
	}
	/**
	 * 返回 一个字段的值,例如返回某一个纪录的studen的name或返回查询有多少学生
	 * @param sql
	 * @param args
	 * @return
	 */
	public <E> E getForValue(String sql,Object...args){
		Connection connection = null;
		try {
			connection = JDBCUtils.getConnection();
			return (E) queryRunner.query(connection, sql, new ScalarHandler(), args);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.releaseConnection(connection);
		}
		return null;
	}
	/**
	 * 返回T所对应的List
	 * @param sql
	 * @param args
	 * @return
	 */
	public List<T> getForList(String sql,Object ...args){
		Connection connection = null;
		try {
			connection = JDBCUtils.getConnection();
			return  queryRunner.query(connection, sql, new BeanListHandler<T>(clazz), args);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.releaseConnection(connection);
		}
		
		return null;
	}
	/**
	 * 返回对应的T的一个实例类对象
	 * @param sql
	 * @param args
	 * @return
	 */
	public T get(String sql,Object ...args ){
		Connection connection = null;
		try {
			connection = JDBCUtils.getConnection();
			return queryRunner.query(connection, sql, new BeanHandler<T>(clazz), args);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.releaseConnection(connection);
		}
		return null;
	}
	/**
	 * 该方法封装了 Insert,delete,updata 操作	 * 
	 * @param sql  SQL语句
	 * @param args  填充sql语句的占位符
	 */
	public void update(String sql,Object ... args){
		Connection connection = null;
		try {
			connection = JDBCUtils.getConnection();
			queryRunner.update(connection, sql, args);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.releaseConnection(connection);
		}
	}
	
}
