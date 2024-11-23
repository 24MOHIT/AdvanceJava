<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%@ include file="Header.jsp" %>

	<form action="LoginCtl" method="post">
	
	<center>
	<% String msg=(String) request.getAttribute("msg"); %>
	<% String err=(String) request.getAttribute("err"); %>
	

	<% if(msg != null){ %>
	<span style="color: green"> <%=msg%></span>
	<%} %>
	
	<% if(err != null){ %>
	<span style="color: red" > <%=err%></span>
	<% } %>
		<h1 align="center">Login</h1>
		
		
			<table>
				<tr>
					<th>LoginId :</th>
					<td><input type="email" name="loginid"
						placeholder="Enter Loginid"></td>
				</tr>

				<tr>
					<th>Password :</th>
					<td><input type="password" name="password"
						placeholder="Enter Password"></td>
				</tr>

				<tr>
					<th></th>
					<td><input type="submit" name="operation" value="Signin"></td>
				</tr>

			</table>
			<br><br><br><br><br><br><br><br><br><br>
			<br><br><br><br><br><br><br><br><br>
			
			<%@ include file="Footer.jsp" %>
		</center>
	</form>
</body>
</html>