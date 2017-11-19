<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'newStudent.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	<%
  		Object msg = request.getAttribute("message");
  		if(msg != null){
  	
   	%>
   		<br>
   			<font color="red"><%= msg %></font>
   		<br>
   		<br>
   		
   	<%
   			
   		}
   	 %>
         <form action="add.do" method="post">
        		<table>
        		<tr>
        			<td>学生名称:</td>
        			<td><input type ="text" name = "name" value = "<%=request.getParameter("name") == null? "" : request.getParameter("name") %>"/></td>
        		</tr>
        		<tr>
        			<td>地址:</td>
        			<td><input type ="text" name = "address" value = "<%=request.getParameter("address") == null? "" : request.getParameter("address") %>"/></td>
        		</tr>
        		<tr>
        			<td>电话:</td>
        			<td><input type ="text" name = "phone" value = "<%=request.getParameter("phone") == null? "" : request.getParameter("phone") %>"/></td>
        		</tr>
        		<tr>
        			<td><input type = "submit" value = "添加"/></td>
        		</tr>
        	</table>
        </form>
  </body>
</html>
