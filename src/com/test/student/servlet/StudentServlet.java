package com.test.student.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.student.dao.CirteriaStudent;
import com.test.student.dao.StudentDAO;
import com.test.student.dao.impl.StudentDAOJDBCImpl;
import com.test.student.domain.Student;

public class StudentServlet extends HttpServlet {
	private  StudentDAO  studentDao = new StudentDAOJDBCImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String servletPath=request.getServletPath();
		String methodName =servletPath.substring(1);
		 methodName=methodName.substring(0, methodName.length() - 3);
		 try {
			 //利用反射原理,执行对应方法.
			Method method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
			 method.invoke(this, request,response);
		} catch (Exception e) {
			response.sendRedirect("error.jsp");
			e.printStackTrace();
		}
		 
	}
//		String method = request.getParameter("method");	
//		switch (method) {
//		case "add":
//			add(request,response);
//			break;
//		case "query":
//			query(request,response);
//			break;
//		case "delete":
//			delete(request,response);
//			break;
//
//		default:
//			break;
//		}
	/**
	 * 删除功能
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String idStr =  request.getParameter("id");
		int id = 0;
		
		try {
			id = Integer.parseInt(idStr);
			studentDao.delete(id);
		} catch (Exception e) {
		}
		response.sendRedirect("query.do");
		
		
	}
	/**
	 * 查询功能
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		CirteriaStudent cs  = new CirteriaStudent(name, address, phone);
		List<Student> students = studentDao.getForLsitWithCriteriaStudent(cs);
	 	request.setAttribute("students", students);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
		
	}
	/**
	 * 添加功能
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");

		long count = studentDao.getCountWithName(name);
		if(count > 0){
			request.setAttribute("message", "用户名"+name+"已被占用.");
			request.getRequestDispatcher("/newStudent.jsp").forward(request, response);
			return;
		}
		Student student = new Student(name,address,phone);
		
		studentDao.save(student);
		
		response.sendRedirect("success.jsp");
	}
	/**
	 * 编辑修改功能
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void edit(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		String forwardPath = "/error.jsp";
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);
		
		try {
			Student student	= studentDao.get(id);
			if(student != null){
				forwardPath = "/updateStudent.jsp";
				request.setAttribute("student", student);
				
			}
		} catch (Exception e) {
		}
		
		
		request.getRequestDispatcher(forwardPath).forward(request, response);
		
		
	}
	/**
	 * 更新功能
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void update(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		String idStr  = request.getParameter("id");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String oldName = request.getParameter("oldName");
		int id  = Integer.parseInt(idStr);
		Student student = new Student(id,name, address, phone);
		request.setAttribute("student", student);
		request.setAttribute("oldName", oldName);
		if(!oldName.equalsIgnoreCase(name)){
			long flag =studentDao.getCountWithName(name);
			if(flag >0){
				request.setAttribute("message", "用户名"+name+"已被占用.");
				request.getRequestDispatcher("/updateStudent.jsp").forward(request, response);
				return;
			}
		}
		studentDao.update(student);
		response.sendRedirect("query.do");
	}
}
