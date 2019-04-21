<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="#FEF9E7">
<%
response.setHeader("Cache-Control", "no-cache");
response.setHeader("Cache-Control", "no-store");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);
%>
<p1 align="left">
<form action="AdminHome.jsp" method="get">
<input type="submit" value="Admin Home"/></form>
<form action="index.jsp" method="get">
<input type="submit" value="Zappy Home" /></form></p1>
 <p1 align="right">
<form action="logout.jsp" method="get">
<input type="submit" value=" Logout" /></form></p1>
<h1><font color="green">Customer Details</font> </h1 >
<table style="background-color: #FBFCFC;" border="1">
<tr style="background-color:#E5E7E9;"><th>Email</th><th>first Name</th><th>Last Name</th><th>City</th><th>State</th><th>Pin</th><th>Address</th><th>Mobile</th></tr>
<%@page import="java.util.ArrayList,zappyinfo.Zeppy" %>
<%
ArrayList<Zeppy> ar=(ArrayList<Zeppy>)request.getAttribute("LIST");
for(Zeppy z:ar)
{
%>
<tr> 
    <td><%=z.getEmail()%></td>
    <td><%=z.getName()%></td>
    <td><%=z.getLastname()%></td>
    <td><%=z.getCity()%></td>
    <td><%=z.getState()%></td>
    <td><%=z.getPin()%></td>
    <td><%=z.getAddress()%></td>
    <td><%=z.getMobile()%></td>
</tr>
<% 
}
%>
</table>

</body>
</html>