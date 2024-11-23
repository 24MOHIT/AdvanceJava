<%@page import="com.rays.Bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		UserBean userbean = (UserBean) session.getAttribute("user");
	%>
	<%
		if (userbean != null) {
	%>
		<h2><%="Hii," +userbean.getFirstname() %></h2>
		<a href="UserCtl.do">Add User</a>|
		<a href="UserListCtl.do">User List</a>|
		<a href="WelcomeCtl">Welcome</a>|
		
		<a href="MarksheetCtl.do">Add Marksheet</a>|
		<a href="MarksheetListCtl.do">Marksheet List</a>
		
		<a href="LoginCtl?operation=logout">logout</a>
	<%
		} else {
	%>
		<h2>Hii,Friend</h2>
		<a href="UserRegistrationCtl">SignUp</a>|
		<a href="LoginCtl">Login</a>|
		<a href="WelcomeCtl">Welcome</a>|

	<%
		}
	%>

	
	
	<hr>

</body>
</html>