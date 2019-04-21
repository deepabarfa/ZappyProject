<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="silver">
<%
response.setHeader("Cache-Control", "no-cache");
response.setHeader("Cache-Control", "no-store");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);
%>
<p1 align="left">
<form action="AdminHome.jsp" method="get">
<input type="submit" value="Admin Home"/></form> <%--buttons --%>
<form action="index.jsp" method="get">
<input type="submit" value="Zappy Home" /></form></p1>
 <p1 align="right">
<form action="logout.jsp" method="get">
<input type="submit" value=" Logout" /></form></p1>

<h3><%String m=(String)request.getAttribute("msg");
if(m!=null)
out.println(m);
%></h3>

<%-- 
  <%@page import="java.util.ArrayList,zappyinfo.admin" %>--%>
<h2><font color="green">Change Password</font> </h2 >
<%-- <% 
admin z=(admin)request.getAttribute("msg");
%>--%>
<table>
<form action="Updateadminprofile" method="post">
<%-- here fields to fill by user --%>
<tr><td>Old Password</td>     <td><input type="password" name="current"  required/></td></tr>
<tr><td>Password</td>     <td><input type="password" name="password" id="txtPassword"  required/></td></tr>
<tr><td>confirmPassword</td> <td><input type="password" name="Confirmpassword" id="txtConfirmPassword" required/></td></tr>
<%-- <input type="hidden" value="<%=z.getUid()%>" name="uid" /> --%><%-- hidden fields which is never show in the view page but it's available. we use this hidden field in the servlet(which is get their value by the database and get by getter function)  --%>
<tr><td><input type="submit" value="Update" onclick="return Validate()" /></td><tr/>
<% if ( !("password").equals("Confirmpassword") ) //check condition
{ %>
		<%@ include file="errorpage.jsp" %>
	<%} %>
</form>
</table>
<script type="text/javascript">
    function Validate() { //onclick function check 
        var password = document.getElementById("txtPassword").value;
        var confirmPassword = document.getElementById("txtConfirmPassword").value;
        if (password != confirmPassword) {
            alert("Passwords do not match.");
            return false;
        }
        return true;
    }
</script>
</body>
</html>