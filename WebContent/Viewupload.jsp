<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
$shadow1 : 0 1px 3px rgba(0,0,0,0.12), 0 1px 2px rgba(0,0,0,0.24);
$shadow2 : 0 3px 6px rgba(0,0,0,0.16), 0 3px 6px rgba(0,0,0,0.23);
$shadow3 : 0 10px 20px rgba(0,0,0,0.19), 0 6px 6px rgba(0,0,0,0.23);
$shadow4 : 0 14px 28px rgba(0,0,0,0.25), 0 10px 10px rgba(0,0,0,0.22);
$shadow5 : 0 19px 38px rgba(0,0,0,0.30), 0 15px 12px rgba(0,0,0,0.22);

*, *:before, *:after {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

body {-webkit-box-shadow:0px 5px 10px #1c1c1c;
-moz-box-shadow:0px 5px 10px #1c1c1c;
box-shadow:0px 5px 10px #1c1c1c;
	font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif;
	background-color: #FEF9E7;
	background: linear-gradient(130deg, #FEF9E7 20%, #ffff80 50%, #99ffcc 100%) no-repeat center center fixed;
}
</style>
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
<center>
<h2><font color="green">Zappy Products</font> </h2>
<table style="background-color: #FBFCFC;"" border="1">
<tr style="background-color:#E5E7E9;"><th>productID</th><th>productname</th><th>price</th><th>weight</th><th>details</th><th>images</th><th>option</th></tr>
<%@page import="java.util.ArrayList,zappyinfo.Zeppy" %>
<h3><font color="green"><%String m=(String)request.getAttribute("msg");
 if(m!=null)
	 out.println(m);
%></font></h3>
<%
ArrayList<Zeppy> ar=(ArrayList<Zeppy>)request.getAttribute("LIST");
for(Zeppy z:ar)
{
%>
<tr>
     <form action="Opreation" method="get">
    <td><%=z.getProductID()%></td>
    <td><%=z.getProductname()%></td>
    <td><%=z.getPrice()%></td>
    <td><%=z.getWeight()%></td>
    <td><%=z.getDetails()%></td>
    <td><img src="images/<%=z.getImages()%>" heigth="75" width="75" /></td>
    <td>

    <input type="hidden" name="productID" value="<%=z.getProductID() %>"/>
    <input type="submit" value="Delete" name="opreation" onclick="return confirmdelete();"/>
 <script>
 function confirmTest()
 {
var a=confirm("do you realy want to Update");
return a;
 }
 </script>
 <script>
 function confirmdelete()
 {
var a=confirm("do you realy want to delete");
return a;
 }
 </script>
 <script>
 function confirmupdate()
 {
var a=confirm("do you realy want to update image");
return a;
 }
 </script>
    
    <input type="submit" value="Update" name="opreation" onclick="return confirmTest();" />
    <input type="submit" value="Update image" name="opreation" onclick="return confirmupdate();" />
    </form></td>   
  </tr>
  <a href="Opreation" onclick="return confirmTest();"></a>
<% 
}
%>
</table></center>
</body>
</html>