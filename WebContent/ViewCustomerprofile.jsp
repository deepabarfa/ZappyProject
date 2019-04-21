<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="image/light_background_texture_69531_3840x2160.jpg">
<%
response.setHeader("Cache-Control", "no-cache");
response.setHeader("Cache-Control", "no-store");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);
%>
<p1 align="left">
<form action="CHome.jsp" method="get">
<input type="submit" value="Customer Home"/></form>
<form action="index.jsp" method="get">
<input type="submit" value="Zappy Home" /></form></p1>
 <p1 align="right">
<form action="logout.jsp" method="get">
<input type="submit" value=" Logout" /></form></p1>

<center>

<%@page import="java.util.ArrayList,zappyinfo.Zeppy" %>
<%
Zeppy z=(Zeppy)request.getAttribute("c");
%>
<fieldset>
<legend><h2><font color="blue"><%=z.getName()%>'s profile</font></h2></legend>
<Center>
<h2><font color="green">Email </font>: <%=z.getEmail()%></h2>
<h2><font color="green">Name</font>: <%=z.getName()%></h2>
<h2><font color="green">LastName</font>: <%=z.getLastname()%></h2>
<h2><font color="green">City</font>: <%=z.getCity()%></h2>
<h2><font color="green">State</font>: <%=z.getState()%></h2>
<h2><font color="green">pin</font>: <%=z.getPin()%></h2>
<h2><font color="green">Address</font>: <%=z.getAddress()%></h2>
<h2><font color="green">Mobile</font>: <%=z.getMobile()%></h2>

</Center>

</fieldset>
</center> 

</body>
</html>