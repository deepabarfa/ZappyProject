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
<form action="index.jsp" method="get">
<input type="submit" value="Zappy Home" /></form></p1>
<p1 align="right">
<form action="logout.jsp" method="get">
<input type="submit" value=" Logout" /></form>
</p1>
<h3><font color="green">Welcome</font> </h3 >
<h3><%String m1=(String)session.getAttribute("user");
if(m1!=null) out.println(m1); %></font>
</h3>
<h3>
<%String m=(String)request.getAttribute("msg");
if(m!=null)
out.println(m);
%></h3>
<fieldset>
<legend>Account Setting</legend>
<a href ="ViewCustomerProfile">Profile</a>
<br/><br/>
<a href ="EditProfileController">Edit Profile</a>
<br/><br/>
<a href ="Customerpasswordupdate.jsp">Update Password</a>
<br/></fieldset>
<br/>
<fieldset>
<legend>Product Details</legend>
<a href ="CustomerOrderShowController">My Order</a>
<br/><br/>
<a href ="CustomerOrderStatusController">My Order Status</a>
<br/><br/>
<a href ="Addtocard">My Cart</a>
<br/></fieldset>
</body>
</html>