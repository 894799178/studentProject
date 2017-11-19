package com.test.student.dao;

import java.util.List;

import com.test.student.domain.Student;

public interface StudentDAO {
	public List<Student> getAll();
	
	public void save(Student student);
	
	public Student get(Integer id);
	
	public void delete (Integer id);
	/**
	 * ���غ�name ��ȵļ�¼��
	 * @param name
	 * @return
	 */
	public long getCountWithName(String name);
	
	public List<Student> getForLsitWithCriteriaStudent(CirteriaStudent cs);
	
	public void update(Student student);
	
	public Student getStudentWithName(String name);
	
}
