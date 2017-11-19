package com.test.student.dao.impl;

import java.util.List;

import com.test.student.dao.CirteriaStudent;
import com.test.student.dao.DAO;
import com.test.student.dao.StudentDAO;
import com.test.student.domain.Student;

public class StudentDAOJDBCImpl extends DAO<Student> implements StudentDAO{
	
	
	@Override
	public List<Student> getForLsitWithCriteriaStudent(CirteriaStudent cs) {
		String sql = "select id,name,address,phone from students where "
				+ "name like ? and address like ? and phone like ?";
		
		return getForList(sql,cs.getName(),cs.getAddress(),cs.getPhone());
	}
	@Override
	public List<Student> getAll() {
		String sql = "select id,name,address,phone from students";
		return getForList(sql);
	}

	@Override
	public void save(Student student) {
		String sql = "insert into students(name,address,phone) values(?,?,?)";
		update(sql, student.getName(),student.getAddress(),student.getPhone());
	}

	@Override
	public Student get(Integer id) {
		String sql = "select id,name,address,phone from students where id = ?";
		
		return get(sql, id);
	}

	@Override
	public void delete(Integer id) {

			String sql = "delete from students where id = ?";
			update(sql, id);
	}

	@Override
	public long getCountWithName(String name) {
		String sql = "select count(id) from students where name = ?";
		
		return getForValue(sql, name);
	}
	@Override
	public void update(Student student) {
		
		String sql = "update Students set name = ?,address = ?,phone = ? where id = ?";
		
		update(sql,student.getName(),student.getAddress(),student.getPhone(),student.getId());
	}
	@Override
	public Student getStudentWithName(String name) {
		String sql = "select id,name,address,phone from students where name = ?";
		
		return get(sql,name);
	}

}
