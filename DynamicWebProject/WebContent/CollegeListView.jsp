<%@page import="com.rays.Bean.CollegeBean"%>
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

	<%@include file="Header.jsp"%>

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

	<form action="CollegeListCtl.do" method="post">

		<h1 align="center">College List</h1>

		<table>
			<th>Name :</th>
			<td><input type="text" name="name" placeholder="Enter Name"></td>

			<td><input type="submit" name="operation" value="search"></td>

		</table>

		<table align="center" width="100%" border="1px">

			<tr style="background-color: skyblue">

				<th>Delete</th>
				<th>Name</th>
				<th>Address</th>
				<th>State</th>
				<th>City</th>
				<th>PhoneNo</th>
				<th>Edit</th>

			</tr>

			<%
				Iterator it = list.iterator();
				while (it.hasNext()) {
					CollegeBean bean = (CollegeBean) it.next();
			%>

			<tr align="center">
				<td><input type="checkbox" name="ids" value="<%=bean.getId()%>"></td>
				<td><%=bean.getName()%></td>
				<td><%=bean.getAddress()%></td>
				<td><%=bean.getState()%></td>
				<td><%=bean.getCity()%></td>
				<td><%=bean.getPhoneno()%></td>

				<td><a href="CollegeCtl.do?id=<%=bean.getId()%>">Edit</a></td>
			</tr>

			<%
				}
			%>

		</table>
		<br>
		<table width="100%">
		<tr>
		<td align="left"><input type="submit" name="operation" value="previous"
			<%=pageNo == 1 ? "disabled" : ""%>></td>

		<td ><input type="submit" name="operation" value="delete"></td>

		<td align="right"><input type="submit" name="operation" value="next"
			<%=list.size() == 0 ? "disabled" : ""%>></td>
		</tr>
		</table>
		<input type="hidden" name="pageNo" value="<%=pageNo%>">

	</form>
</body>
</html>