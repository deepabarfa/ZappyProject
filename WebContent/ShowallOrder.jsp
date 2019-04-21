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
<form action="AdminHome.jsp" method="get">
<input type="submit" value="Admin Home"/></form>
<form action="index.jsp" method="get">
<input type="submit" value="Zappy Home"/></form></p1>
 <p1 align="right">
<form action="logout.jsp" method="get">
<input type="submit" value=" Logout" /></form></p1>

 <h3><font color="green">View all Total order</font> </h3 >
<table style="background-color:#E5E7E9;"border="1">
<tr style="background-color: #FBFCFC;"><th>productID</th><th>images</th><th>productname</th><th>price</th><th>details</th><th>Quantity</th><th>TotalAmount</th><th>Email Id</th><th>Name</th><th>Mobile</th><th>Address</th><th>Date</th><th>Status</th></tr>
<%@page import="java.util.ArrayList,zappyinfo.Zeppy" %>

<%
ArrayList<Zeppy> ar=(ArrayList<Zeppy>)request.getAttribute("LIST");
for(Zeppy z:ar)
{
%>
<tr>
    <td><%=z.getProductID()%></td>
    <td><img src="images/<%=z.getImages()%>" heigth="125" width="125" /></td>
    <td><%=z.getProductname()%></td>
    <td><%=z.getPrice()%></td>
    <td><%=z.getDetails()%></td>
    <td><%=z.getQuantity()%></td>
    <td><%=z.getTamount()%></td>
    <td><%=z.getEmail()%></td>
    <td><%=z.getName()%></td>
    <td><%=z.getMobile()%></td>
    <td><%=z.getAddress()%></td>
    <td><%=z.getDate()%></td>
    <%  int st=0;
      String status;
      st=z.getStatus(); 
      if(st==1)
      {
    	  status="Dispatched";
      }
      else if(st==2)
      {
    	  status="cancel";
      }
      else
      {
    	  status="Pending";
      }
      %>
      <td><%=status%></td>
  </tr>

 <% 
}
%>
  </table>
</body>
</html>