<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
 <%--buttons --%>
<form action="index.jsp" method="get">
<input type="submit" value="Zappy Home" /></form></p1>

<h3>
<%String m=(String)request.getAttribute("msg");
if(m!=null)
out.println(m);
%></font></h3>


<%@page import="java.util.ArrayList,zappyinfo.Zeppy" %>
<h2><font color="green"> Forget Password</font> </h2 >
<table>
<form action="ForgetpasswordController" method="post">
<tr><td>Email Id</td><td><input type="email" name="youremail" required/></td></tr>
<tr><td><input type="submit" value="send mail"  /></td><tr/>


</table>
</body>
</html>