<%@page import="com.test.student.dao.StudentDAO"%>
<%@page import="com.test.student.domain.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生管理系统</title>
<script type="text/javascript" src = "script/jquery-3.2.1.js"></script>
<script type="text/javascript">
	$(function(){
		$(".delete").click(function(){
			var content = $(this).parent().parent().find("td:eq(1)").text(); 
			var flag = confirm("你确定要删除"+content+"吗?");
			return flag;
		});
	});
		
</script>
</head>
<body>
        <form action="query.do" method="post">
        		<table>
        		<tr>
        			<td>学生名称:</td>
        			<td><input type ="text" name = "name"/></td>
        		</tr>
        		<tr>
        			<td>地址:</td>
        			<td><input type ="text" name = "address"/></td>
        		</tr>
        		<tr>
        			<td>电话:</td>
        			<td><input type ="text" name = "phone"/></td>
        		</tr>
        		<tr>
        		<td><input type = "submit" value = "query"/></td>
        		<td><a href = "newStudent.jsp">创建一个新学生</a> </td>
        		</tr>
        	</table>
        	<br><br>
        		<% 
        			List<Student> students  = (List<Student>)request.getAttribute("students");
        			if(students != null && students.size() > 0){
        			
         		 %>
         		 <hr>
         		 <br><br>
         		 	<table border="1" cellpadding="10" cellspacing="0">
         		 		<tr>
         		 			<th>ID</th>
         		 			<th>Name</th>
         		 			<th>Address</th>
         		 			<th>Phone</th>
         		 			<th>Update\Delete</th>
         		 		</tr>
         		 		<%
         		 			for(Student student : students){
         		 		 %>
         		 		 	<tr>
         		 		 		<td><%=	student.getId() %></td>
         		 		 		<td><%= student.getName() %></td>
         		 		 		<td><%= student.getAddress() %></td>
         		 		 		<td><%=student.getPhone() %></td>
         		 		 		<td>
         		 		 			<a href="edit.do?id=<%=student.getId() %>">修改</a>
         		 		 			<a href="delete.do?id=<%=student.getId()%>" class = "delete">删除</a>
         		 		 		</td>
         		 		 		
         		 		 	</tr>
         		 		 <%} %>
         		 	</table>
         		 <%
         		 	}
         		  %>
        	
        </form>
</body>
</html>