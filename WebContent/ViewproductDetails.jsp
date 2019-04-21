<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
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
<form action="index.jsp" method="get">
<input type="submit" value="Zappy Home" /></form></p1>
<%@page import="java.util.ArrayList,zappyinfo.Zeppy" %>
<%
ArrayList<Zeppy> ar=(ArrayList<Zeppy>)request.getAttribute("LIST");
for(Zeppy z:ar)
{
%>
<center>
<fieldset>
<legend>Product Details</legend>
 <form action="Addtocard" method="post">
   productId: <%=z.getProductID()%><br/>
    <img src="images/<%=z.getImages()%>" heigth="400" width="350" /><br/>
    productname:<%=z.getProductname()%><br/>
    price:<%=z.getPrice()%><br/>
    Weight:<%=z.getWeight()%><br/>
    Details<%=z.getDetails()%><br/>
    <input type="hidden" name="productID" value="<%=z.getProductID() %>"/>
    <input type="number" min="1" value="1" name="quantity" required/>
    <input type="submit" value="Addtocart" name="work"/>
    <input type="hidden" value="<%=z.getPrice()%>" name="price" />
  </form>
<% 
}
%>
</fieldset>
</center>
</body>
</html>