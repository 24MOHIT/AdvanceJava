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

	<form action="MarksheetListCtl.do" method="post">

		<h1 align="center">Marksheet List</h1>

		<table>
			<th>Name :</th>
			<td><input type="text" name="name" placeholder="Enter FirstName"></td>
			
			<th>RollNo : </th>
			<td><input type="text" name="rollno" placeholder="Enter RollNo"> </td>
			
			<th>Maths : </th>
			<td><input type="text" name="maths" palceholder="Enter Number"> </td>

			<td><input type="submit" name="operation" value="search"></td>
		</table>

		<br>
		<table border="1pxl" width="100%">
			<tr style="background: skyblue">
				<th>Delete</th>
				<th>Rollno</th>
				<th>Name</th>
				<th>Maths</th>
				<th>Physics</th>
				<th>Chemistry</th>
				<th>Edit</th>

				<%
					Iterator it = list.iterator();
					while (it.hasNext()) {
						MarksheetBean bean = (MarksheetBean) it.next();
				%>
			
			<tr align="center">

				<td><input type="checkbox" name="ids" value="<%=bean.getId()%>"></td>

				<td><%=bean.getRollno()%></td>
				<td><%=bean.getName()%></td>
				<td><%=bean.getMaths()%></td>
				<td><%=bean.getPhysics()%></td>
				<td><%=bean.getChemistry()%></td>

				<td><a href="MarksheetCtl.do?rollno=<%=bean.getRollno()%>">Edit</a></td>
			</tr>

			<%
				}
			%>
		</table>

		<table width="100%">

			<td align="left"><input type="submit" name="operation"
				value="previous" <%=pageNo == 1 ? "disabled" : ""%>></td>

			<td><input type="submit" name="operation" value="delete"></td>

			<td align="right"><input type="submit" name="operation"
				value="next" <%=list.size() == 0 ? "disabled" : ""%>></td>
		</table>
		
		<input type="hidden" name="pageNo" value="<%= pageNo%>">
		
	</form>
	<%@ include file="Footer.jsp"%>

</body>
</html>