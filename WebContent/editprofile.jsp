<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
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
<form action="CHome.jsp" method="get">
<input type="submit" value="Customer Home"/></form>
<form action="index.jsp" method="get">
<input type="submit" value="Zappy Home" /></form></p1>
 <p1 align="right">
<form action="logout.jsp" method="get">
<input type="submit" value=" Logout" /></form></p1>
<%@page import="java.util.ArrayList,zappyinfo.Zeppy" %>
<%String m=(String)request.getAttribute("msg");
if(m!=null)
out.println(m);
%>
<%
Zeppy cc=(Zeppy)request.getAttribute("c");
%>
<h2><font color="blue">Edit Profile</font></h2>
<table>
<form action="CustomerProfileUpdate" method="post">
<tr><td>Name:</td><td> <input type="text" value="<%=cc.getName()%>" pattern="[a-zA-Z\s]+" name="name" required /></td></tr> 
<tr><td>City:</td><td> <input type="text" value="<%=cc.getCity()%>" pattern="[a-zA-Z\s]+" name="city" required/></td></tr> 
<tr><td>State:</td><td> <input type="text" value="<%=cc.getState()%>" pattern="[a-zA-Z\s]+"  name="state" required/></td></tr> 
<tr><td>Pin:</td><td>  <input type="text" value="<%=cc.getPin()%>"  pattern="^[0-9]*$" name="pin" required/></td></tr> 
 <tr><td>Address:  </td><td>  <input type="text" value="<%=cc.getAddress()%>"  name="address" required/></td> </tr>
 <tr><td>EMAIL:</td><td> <input type="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,63}$" value="<%=cc.getEmail()%>" name="email" required/></td> </tr>
 <tr><td>Mobile:</td><td> <input type="text" value="<%=cc.getMobile()%>" pattern="^[0-9]*$" name="mobile" required/></td></tr>
 <%-- <tr><td>Password</td><td> <input type="password" value="<%=cc.getPassword()%>" name="password" required/></td></tr>--%>
 <input type="hidden" name="email"value="<%=cc.getEmail()%>" />
  <tr><td><input type="submit" value="change" /></td></tr> </form> </table>
            
</body>
</html>