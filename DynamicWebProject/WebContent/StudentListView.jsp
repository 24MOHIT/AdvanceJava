<%@page import="com.rays.Bean.StudentBean"%>
<%@page import="com.rays.Bean.MarksheetBean"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
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
		List list = (List) request.getAttribute("list");

		int pageNo = 1;
	%>
	<%
		if (request.getAttribute("pageNo") != null) {
	%>

	<%
		pageNo = (int) request.getAttribute("pageNo");
	%>
	<%
		}
	%>


	<form action="StudentListCtl.do" method="post">


		<h1 align="center">Student List</h1>
		<table>
			<th>FirstName :</th>
			<td><input type="text" name="firstname" placeholder="Enter Name"></td>

			<th>LastName :</th>
			<td><input type="text" name="lastname" placeholder="Enter Name"></td>

			<th>DOB :</th>
			<td><input type="date" name="dob" placeholder="Enter Dob"></td>

			<td><input type="submit" name="operation" value="search">
			</td>

		</table>
		<br>
		<table border="1pxl" width="100%">
			<tr align="center" bgcolor="skyblue">
				<td>Delete</td>
				<td>FirstName</td>
				<td>LastName</td>
				<td>CollageName</td>
				<td>EmailId</td>
				<td>MobileNo.</td>
				<td>DOB</td>
				<th>Edit</th>
			</tr>


			<%
				Iterator it = list.iterator();
				while (it.hasNext()) {
					StudentBean bean = (StudentBean) it.next();
			%>
			<tr align="center">
				<td><input type="checkbox" name="ids" value="<%=bean.getId()%>"></td>
				<td><%=bean.getFirstname()%></td>
				<td><%=bean.getLastname()%></td>
				<td><%=bean.getCollagename()%></td>
				<td><%=bean.getEmailid()%></td>
				<td><%=bean.getMobileno()%></td>
				<td><%=bean.getDob()%></td>
				<td><a href="StudentCtl.do?id=<%=bean.getId()%>">Edit</a></td>

			</tr>

			<%
				}
			%>
		</table>
		<br>
		<table width="100%">
			<td align="left"><input type="submit" name="operation"
				value="previous" <%=pageNo == 1 ? "disabled" : ""%>></td>

			<td><input type="submit" name="operation" value="delete"></td>

			<td align="right"><input type="submit" name="operation"
				value="next" <%=list.size() == 0 ? "disabled" : ""%>></td>
		</table>
		<input type="hidden" name="pageNo" value="<%=pageNo%>">
	</form>
	<%@ include file="Footer.jsp"%>
</body>
</html>