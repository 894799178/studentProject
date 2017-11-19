package com.test.mvc;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListAllStudentsServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		StudentDAO studentDAO = new StudentDAO();
		List<Student> students = studentDAO.getAll();
		request.setAttribute("students", students);
		request.getRequestDispatcher("/students.jsp").forward(request, response);
		
		
	}

}
