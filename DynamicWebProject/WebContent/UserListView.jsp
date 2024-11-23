
<!DOCTYPE html>
<%@page import="com.rays.Bean.UserBean"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
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

	<form action="UserListCtl.do" method="post">
		<h1 align="center">User List</h1>

		<table>
			<th>FirstName :</th>
			<td><input type="text" name="firstname"
				placeholder="Enter FirstName"></td>

			<th>LastName :</th>
			<td><input type="text" name="lastname"
				placeholder="Enter LastName"></td>

			<th>LoginId :</th>
			<td><input type="text" name="loginid"
				placeholder="Enter Loginid"></td>

			<th>Address :</th>
			<td><input type="text" name="address"
				placeholder="Enter Address"></td>

			<th>Dob :</th>
			<td><input type="date" name="dob"></td>


			<td><input type="submit" name="operation" value="search"></td>

		</table>

		<table border="1px" width="100%">

			<tr style="background: skyblue">
				<th>Delete</th>
				<th>S.No</th>
				<th>FirstName</th>
				<th>LastName</th>
				<th>LoginId</th>
				<th>Address</th>
				<th>Dob</th>
				<th>Edit</th>
			</tr>


			<%
				Iterator it = list.iterator();
				while (it.hasNext()) {
					UserBean bean = (UserBean) it.next();
			%>

			<tr align="center">

				<td><input  type="checkbox" name="ids" value="<%=bean.getId()%>"></td>
				<td><%=bean.getId() %></td>
				<td><%=bean.getFirstname()%></td>
				<td><%=bean.getLastname()%></td>
				<td><%=bean.getLoginid()%></td>
				<td><%=bean.getAddress()%></td>
				<td><%=bean.getDob()%></td>

				<td><a href="UserCtl.do?id=<%=bean.getId()%>">Edit</a></td>

			</tr>
			<%
				}
			%>
		</table>
		<table width="100%">
			<tr >
<br>
				<td align="left"><input type="submit" name="operation"
					value="previous" <%=(pageNo) == 1 ? "disabled" : ""%>></td>

				<td><input type="submit" name="operation" value="delete"></td>

				<td align="right"><input type="submit" name="operation"
					value="next" <%=(list.size()) == 0 ? "disabled" : ""%>></td>
			</tr>
</table>
			<input type="hidden" name="pageNo" value="<%=pageNo%>">

		
	</form>

	<%@ include file="Footer.jsp"%>
</body>
</html>