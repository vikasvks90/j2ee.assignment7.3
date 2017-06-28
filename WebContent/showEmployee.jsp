<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<% Class.forName("oracle.jdbc.OracleDriver"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
</head>
<body>
<%
String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
String username = "vikas";
String password = "vikas";
Connection con = DriverManager.getConnection(dbURL, username, password);
Statement stmt = con.createStatement();
ResultSet rs = stmt.executeQuery("select * from employee");
%>
<table border="1">
<tr>
	<th>Employee Id</th><th>Employee Name</th><th>Designation</th><th>Salary</th>
</tr>
<%
while(rs.next()){
%>
<tr>
	<td><%= rs.getInt(1)%></td><td><%= rs.getString(2)%></td><td><%= rs.getString(3)%></td><td><%= rs.getInt(4)%></td>
</tr>
<%			
}
%>
</table>
</body>
</html>