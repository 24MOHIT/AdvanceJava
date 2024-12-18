<%@page import="com.rays.Bean.MarksheetBean"%>
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
	<%
		MarksheetBean bean = (MarksheetBean) request.getAttribute("bean");
	%>
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

			<%
				if (bean != null) {
			%>

			<h1>Update Marksheet</h1>
			<%
				} else {
			%>
			<h1>Add Marksheet</h1>
			<%
				}
			%>
			<table>

				<td><input type="hidden" name="id"
					value="<%= bean != null ? bean.getId() : ""%>"></td>

				<tr>
					<th>Rollno :</th>
					<td><input type="text" name="rollno"
						value="<%=bean != null ? bean.getRollno() : ""%>"
						placeholder="Enter rollno"></td>
				</tr>

				<tr>
					<th>Name :</th>
					<td><input type="text" name="name"
						value="<%=bean != null ? bean.getName() : ""%>"
						placeholder="Enter name"></td>
				</tr>

				<tr>
					<th>Maths No :</th>
					<td><input type="text" name="maths"
						value="<%=bean != null ? bean.getMaths() : ""%>"
						placeholder="Enter number"></td>
				</tr>

				<tr>
					<th>Physics No :</th>
					<td><input type="text" name="physics"
						value="<%=bean != null ? bean.getPhysics() : ""%>"
						placeholder="Enter number"></td>
				</tr>

				<tr>
					<th>Chemistry No :</th>
					<td><input type="text" name="chemistry"
						value="<%=bean != null ? bean.getChemistry() : ""%>"
						placeholder="Enter number"></td>
				</tr>
				<th></th>
				<td><input type="submit" name="operation"
					value="<%=bean != null ? "update" : "save"%>"></td>

			</table>

		</form>
	</center>
	<%@ include file="Footer.jsp"%>

</body>
</html>