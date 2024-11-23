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

<%@ include file="Header.jsp" %>
	<%
		UserBean bean = (UserBean) request.getAttribute("bean");
	%>

<center>
	<form action="UserCtl.do" method="post">
		<%
			String msg = (String) request.getAttribute("msg");
		%>

		<%
			if (msg != null) {
		%>

		<span><%=msg%></span>

		<%
			}
		%>

		<%
			if (bean != null) {
		%>

		<h1>Update User</h1>

		<%
			} else {
		%>

		<h1>Add User</h1>
		<%
			}
		%>

		<table>

			<td><input type="hidden" name="id"
				value="<%=bean != null ? bean.getId() : ""%>"></td>
			<tr>
				<th>FirstName :</th>
				<td><input type="text" name="firstname"
					value="<%=bean != null ? bean.getFirstname() : ""%>"
					placeholder="Enter Firstname"></td>
			</tr>

			<tr>
				<th>lastName :</th>
				<td><input type="text" name="lastname"
					value="<%=bean != null ? bean.getLastname() : ""%>"
					placeholder="Enter Lastname"></td>
			</tr>

			<tr>
				<th>LoginId :</th>
				<td><input type="text" name="loginid"
					value="<%=bean != null ? bean.getLoginid() : ""%>"
					placeholder="Enter LoginId"></td>
			</tr>

			<tr>
				<th>Password :</th>
				<td><input type="password" name="password"
					value="<%=bean != null ? bean.getPassword() : ""%>"
					placeholder="Enter Password"></td>
			</tr>

			<tr>
				<th>Address :</th>
				<td><input type="text" name="address"
					value="<%=bean != null ? bean.getAddress() : ""%>"
					placeholder="Enter Address"></td>
			</tr>

			<tr>
				<th>DOB :</th>
				<td><input type="date" name="dob"
					value="<%=bean != null ? bean.getDob() : ""%>"
					placeholder="Enter DOB"></td>
			</tr>

			<tr>
				<td><input type="submit" name="operation" value="<%=bean != null ? "update" : "save"%>"></td>
				
			</tr>


		</table>
	</form>
	<br><br><br><br><br><br><br>
	<br><br><br><br><br><br><br>
	
	<%@ include file="Footer.jsp" %>
	</center>

</body>
</html>