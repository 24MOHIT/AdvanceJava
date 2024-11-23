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
		<form action="MarksheetCtl.do" method="post">
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

			<table>
				<h1>Add Marksheet</h1>
				<tr>
					<th>Rollno :</th>
					<td><input type="text" name="rollno"
						placeholder="Enter rollno"></td>
				</tr>

				<tr>
					<th>Name :</th>
					<td><input type="text" name="name" placeholder="Enter name"></td>
				</tr>

				<tr>
					<th>Maths No :</th>
					<td><input type="text" name="maths" placeholder="Enter number"></td>
				</tr>

				<tr>
					<th>Physics No :</th>
					<td><input type="text" name="physics"
						placeholder="Enter number"></td>
				</tr>

				<tr>
					<th>Chemistry No :</th>
					<td><input type="text" name="chemistry"
						placeholder="Enter number"></td>
				</tr>
				<th></th>
				<td><input type="submit" name="operation" placeholder="submit"></td>

			</table>

		</form>
	</center>
	<%@ include file="Footer.jsp"%>

</body>
</html>