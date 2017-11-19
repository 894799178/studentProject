package com.test.student.test;
import java.util.List;

import org.junit.Test;

import com.test.student.dao.CirteriaStudent;
import com.test.student.dao.StudentDAO;
import com.test.student.dao.impl.StudentDAOJDBCImpl;
import com.test.student.domain.Student;
public class StudentDAOJDBCImplTest {
	private StudentDAO studentDAO = new StudentDAOJDBCImpl();
	@Test
	public void testGetInteger(){
		Student student =  studentDAO.get(1);
		System.out.println(student);
		
	}
	@Test
	public void testGetAll(){
		List<Student> students = studentDAO.getAll();
		System.out.println(students);
	}
	
	@Test
	public void testDelete(){
		
		studentDAO.delete(1);
		
		
	}
	@Test
	public void testSave(){
		Student student = new Student();
		student.setAddress("北京");
		student.setName("王俊艺1");
		student.setPhone("12345678911");
		studentDAO.save(student);
	}
	@Test
	public void testGetForListWithCritiaStudent(){
		CirteriaStudent cs = new CirteriaStudent(null,"北","11");
		List<Student> students = studentDAO.getForLsitWithCriteriaStudent(cs);
		System.out.println(students);
		
	}
	
}
