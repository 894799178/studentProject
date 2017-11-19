package com.test.mvc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteStudentServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentDAO studentDAO = new StudentDAO();
		String str = request.getParameter("id");
		studentDAO.deleteById(Integer.parseInt(str));
		request.getRequestDispatcher("/ListAllStudentsServlet").forward(request, response);
	}

}
