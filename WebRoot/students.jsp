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
		<%List<Student> students =(List<Student>)request.getAttribute("students"); %>
		
		<table border="1" cellpadding="10" cellspacing="0">
			<tr>
				<th>ID</th>
				<th>姓名</th>
				<th>年龄</th>
				<th>邮箱</th>
				<th>操作</th>
				<th>操作</th>
				<th>操作</th>
			</tr>
			<%
				for(Student student : students){
			%>	
				<tr>
					<td><%=student.getId()%>
					<td><%=student.getName()%></td>
					<td><%=student.getAge()%></td>
					<td><%=student.getEmill()%></td>
					<td><a href="DeleteStudentServlet?id=<%=student.getId()%>" >删除</a></td>
					<td><a href="inster.jsp" >增加</a></td>
					<td><a href="updata.jsp?id=<%=student.getId()%>" >修改</a></td>
				</tr>
			<%
				}
			 %>
		</table>
			
		
		
</body>
</html>