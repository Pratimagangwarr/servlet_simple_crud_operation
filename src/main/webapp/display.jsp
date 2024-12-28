<%@page import="com.tcs.servlet_simple_crud_operation.dto.User"%>
<%@page import="java.util.List"%>
<%@page import="com.tcs.servlet_simple_crud_operation.dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"


	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display-Page</title>
</head>
<body>
	<h4>Display-Page</h4> 
	<%
	List<User> users = new UserDao().getAllUserDao();
	%>
	<table border="2">
	<!----row for heading----->
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>EMAIL</th>
			<th>DOB</th>
			<th>GENDER</th>
			<th colspan="2">Action</th>
		</tr>



		<%
		for(User user1 : users) {
		%>
         <!----row for data----->
		<tr>
			<td><%=user1.getId()%></td>
			<td><%=user1.getName()%></td>
			<td><%=user1.getEmail()%></td>
			<td><%=user1.getDob()%></td>
			<td><%=user1.getGender()%></td>
			<td><a href="delete?id=<%=user1.getId()%>">DELETE</a></td>
			<td><a href='#'>Edit </a></td>

		</tr>
		<%
		}
		%>

	</table>
</body>
</html>