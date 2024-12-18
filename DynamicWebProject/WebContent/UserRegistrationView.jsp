<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%@ include file="Header.jsp"%>
	<center>
		<form action="UserRegistrationCtl" method="post">

			<%
				String msg = (String) request.getAttribute("msg");
			%>
			<%
				String err = (String) request.getAttribute("err");
			%>

			<%
				if (msg != null) {
			%>

			<span style="color : green"><%=msg%></span>

			<%
				}
			%>

			<%
				if (err != null) {
			%>

			<span style="color: red"><%=err%></span>
			<%
				}
			%>



			<h1>User Registration</h1>
			<table>
				<tr>
					<th>FirstName :</th>
					<td><input type="text" name="firstname"
						placeholder="Enter Firstname"></td>
				</tr>

				<tr>
					<th>lastName :</th>
					<td><input type="text" name="lastname"
						placeholder="Enter Lastname"></td>
				</tr>

				<tr>
					<th>LoginId :</th>
					<td><input type="text" name="loginid"
						placeholder="Enter LoginId"></td>
				</tr>

				<tr>
					<th>Password :</th>
					<td><input type="password" name="password"
						placeholder="Enter Password"></td>
				</tr>

				<tr>
					<th>Address :</th>
					<td><input type="text" name="address"
						placeholder="Enter Address"></td>
				</tr>

				<tr>
					<th>DOB :</th>
					<td><input type="date" name="dob" placeholder="Enter DOB"></td>
				</tr>

				<tr>
					<td><input type="submit"></td>
				</tr>


			</table>
		</form>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br> <br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>

		<%@ include file="Footer.jsp"%>
	</center>

</body>
</html>