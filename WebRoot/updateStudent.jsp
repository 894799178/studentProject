<%@page import="com.test.student.domain.Student"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'update.jsp' starting page</title>
    
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
   			
   			Student student = (Student)request.getAttribute("student");
   			
   		 %>
         <form action="update.do" method="post">
       			<input type= "hidden" name = "id" value = "<%=student.getId()%>"/>
        		<input type= "hidden" name = "oldName" value = "<%=request.getAttribute("oldName") == null?student.getName():request.getAttribute("oldName")%>"/>
        		<table>
        		<tr>
        			<td>学生名称:</td>
        			<td><input type ="text" name = "name" value = "<%= request.getAttribute("oldName") == null? student.getName() :request.getAttribute("oldName") %>"/></td>
        		</tr>
        		<tr>
        			<td>地址:</td>
        			<td><input type ="text" name = "address" value = "<%=student.getAddress()%>"/></td>
        		</tr>
        		<tr>
        			<td>电话:</td>
        			<td><input type ="text" name = "phone" value = "<%=student.getPhone() %>"/></td>
        		</tr>
        		<tr>
        			<td><input type = "submit" value = "提交修改"/></td>
        		</tr>
        	</table>
        	
        </form>
  </body>
</html>
