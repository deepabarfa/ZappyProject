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
<form action="index.jsp" method="post">
<input type="submit" value="back" /></form>
<h1>Please Register</h1>
<h2><font color="green"><%
String s=(String)request.getAttribute("msg");
if(s!=null)
	out.print(s);

%>
</font></h2><br/>
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

<table>
<form action="Registration" method="get">
<tr><td>Email</td><td><input type="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,63}$" name="email" required/></td></tr>
<tr><td>Name</td><td><input type="text" pattern="[a-zA-Z\s]+" name="name" required/></td></tr>
<tr><td>lastname</td><td><input type="text" pattern="[a-zA-Z\s]+" name="lastname" required/></td></tr>
<tr><td> city</td><td><input type="text" pattern="[a-zA-Z\s]+" name="city" required/></td></tr>
<tr><td>State</td><td><input type ="text" name="state" pattern="[a-zA-Z\s]+" required/> </td></tr>
<tr><td>pin</td><td> <input type="text"  pattern="^[0-9]*$" name="pin" required /></td></tr>
<tr><td>Address</td><td><input type="text" pattern="[a-zA-Z\s]+" name="address"required/></td></tr>
<tr><td>Mobile</td><td><input type="text" pattern="^[0-9]*$" name="mobile" required/></td></tr>
<tr><td>password</td><td><input type="password" name="password" required/></td></tr>
<tr><td><input type="submit"/></td></tr>

</script>
</form>
</table>


</body>
</html>