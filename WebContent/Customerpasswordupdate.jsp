<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<form action="CHome.jsp" method="get">
<input type="submit" value="Customer Home"/></form> <%--buttons --%>
<form action="index.jsp" method="get">
<input type="submit" value="Zappy Home" /></form></p1>
 <p1 align="right">
<form action="logout.jsp" method="get">
<input type="submit" value=" Logout" /></form></p1>

<h3>
<%String m2=(String)request.getAttribute("msg1");
if(m2!=null)
out.println(m2);
%></h3>

<h2><font color="green">Change Password</font> </h2 >
<table>
<form action="UpdateCustomerPassword" method="post">
<%-- here fields to fill by user --%>
<tr><td>Old Password</td>     <td><input type="password" name="current"  required/></td></tr>
<tr><td>Password</td>     <td><input type="password" name="password" id="txtPassword"  required/></td></tr>
<tr><td>confirmPassword</td> <td><input type="password" name="Confirmpassword" id="txtConfirmPassword" required/></td></tr>
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