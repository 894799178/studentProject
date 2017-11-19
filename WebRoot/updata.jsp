<%@page import="com.test.mvc.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


	<form action="UpdataStudentServlet" method="get">
		ID: <input type="text" name="id" value =<%= request.getParameter("id")%>></br> 
		姓名:<input type="text"name="name"></br> 
		年龄:<input type="text" name="age"></br>
		邮箱:<input type="text" name="emill "></br> 
		<input type="submit"name="submit" value="提交">
	</form>
</body>
</html>