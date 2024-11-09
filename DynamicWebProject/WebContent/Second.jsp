<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%=request.getParameter("firstname") %>
<%=request.getParameter("lastname") %>
<br>
<%=request.getParameter("loginid") %>
<br>
<%=request.getParameter("password") %>
<br>
<%=request.getParameter("address")%>
<br>
<%=request.getParameter("dob") %>
</body>
</html>