package com.test.mvc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsterStudentServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		StudentDAO studentDAO = new StudentDAO();
		String name=request.getParameter("name");
		int age=Integer.parseInt(request.getParameter("age"));
		String emill = request.getParameter("emill");
		studentDAO.insterStudent(name, age, emill);
		request.getRequestDispatcher("/ListAllStudentsServlet").forward(request, response);
	}

}
