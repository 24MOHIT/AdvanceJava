<%@page import="com.rays.Bean.StudentBean"%>
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

	<form action="StudentCtl.do" method="post">

		<%
			StudentBean bean = (StudentBean) request.getAttribute("bean");
		%>
		<center>

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
			<h1>Update Student</h1>
			<%
				} else {
			%>
			<h1>Add Student</h1>
			<%
				}
			%>
			<table>
				<tr>
					<td><input type="hidden" name="id"
						value="<%=bean != null ? bean.getId() : ""%>"></td>

				</tr>

				<tr>
					<th>FirstName :</th>
					<td><input type="text" name="firstname"
						value="<%=bean != null ? bean.getFirstname() : ""%>"
						placeholder="Enter Name"></td>
				</tr>

				<tr>
					<th>LastName :</th>
					<td><input type="text" name="lastname"
						value="<%=bean != null ? bean.getLastname() : ""%>"
						placeholder="Enter Lastname"></td>
				</tr>

				<tr>

					<th>CollageName :</th>
					<td><input type="text" name="collagename"
						value="<%=bean != null ? bean.getCollagename() : ""%>"
						placeholder="Enter Collagename"></td>
				</tr>

				<tr>
					<th>EmailId :</th>
					<td><input type="text" name="emailid"
						value="<%=bean != null ? bean.getEmailid() : ""%>"
						placeholder="Enter Emailid"></td>
				</tr>

				<tr>
					<th>MobileNo :</th>
					<td><input type="text" name="mobileno"
						value="<%=bean != null ? bean.getMobileno() : ""%>"
						placeholder="Enter Mobileno"></td>
				</tr>

				<th>Dob :</th>
				<td><input type="date" name="dob"
					value="<%=bean != null ? bean.getDob() : ""%>"
					placeholder="Enter Dob"></td>

			</table>

			<td><input type="submit" name="operation"
				value="<%=bean != null ? "update" : "save"%>"></td>

		</center>
	</form>
	<%@ include file="Footer.jsp"%>
</body>
</html>