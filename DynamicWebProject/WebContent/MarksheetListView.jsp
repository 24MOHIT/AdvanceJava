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
	%>
<form action="MarksheetListCtl.do" method="post">

	<h1 align="center">Marksheet List</h1>

	<table border="1pxl" width="100%">
		<tr style="background: skyblue">
			<th>Delete</th>
			<th>Rollno</th>
			<th>Name</th>
			<th>Maths</th>
			<th>Physics</th>
			<th>Chemistry</th>

			<%
				Iterator it = list.iterator();
				while (it.hasNext()) {
					MarksheetBean bean = (MarksheetBean) it.next();
			%>
		
		<tr align="center">

			<td><input type="checkbox" name="ids"
				value="<%=bean.getId()%>"></td>

			<td><%=bean.getRollno()%></td>
			<td><%=bean.getName()%></td>
			<td><%=bean.getMaths()%></td>
			<td><%=bean.getPhysics()%></td>
			<td><%=bean.getChemistry()%></td>
		</tr>

		<%
			}
		%>
		</table>
	
	
	<td><input type="submit" name="operation" value="delete"></td>
	
	</form>
	<%@ include file="Footer.jsp"%>

</body>
</html>