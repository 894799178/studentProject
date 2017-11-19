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
 * ��װ�˻�����CRUD�ķ���,�Թ�����ʹ��
 * ��ǰDAOֱ���ڷ����л�ȡ���ݿ�����
 * ����DAO��ȡDBUtils�������
 * @author 007
 * @param <T>��ǰDAO�����ʵ�����������ʲô
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
	 * ���� һ���ֶε�ֵ,���緵��ĳһ����¼��studen��name�򷵻ز�ѯ�ж���ѧ��
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
	 * ����T����Ӧ��List
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
	 * ���ض�Ӧ��T��һ��ʵ�������
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
	 * �÷�����װ�� Insert,delete,updata ����	 * 
	 * @param sql  SQL���
	 * @param args  ���sql����ռλ��
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
