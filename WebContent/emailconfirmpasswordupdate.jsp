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
<h3>
<%String m1=(String)request.getAttribute("msg1");
if(m1!=null)
out.println(m1);
%></font></h3>

<table>

<form action="ForgetpasswordchangeController" method="post">
<tr><td> new Password</td>     <td><input type="password" name="password" id="txtPassword"  required/></td></tr>
<tr><td>confirmPassword</td> <td><input type="password" name="Confirmpassword" id="txtConfirmPassword" required/></td></tr>
<tr><td><input type="submit" value="UpdateAgain" onclick="return Validate()" /></td><tr/>
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