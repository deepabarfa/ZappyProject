<%-- this jsp shows add to card page
 --%>
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
<form action="CutomerLoginCheckout" method="post">
<input type="submit" value="Customer Home"/></form>
<form action="index.jsp" method="get">
<input type="submit" value="Zappy Home" /></form></p1>
<%
   HttpSession ss1=request.getSession();//if user already login 
	 String x1=(String)ss1.getAttribute("user");
	if(x1!=null)//check if its not then send url CheckoutCLogin.jsp
	{%>
<p1 align="right">
<form action="logout.jsp" method="get">
<input type="submit" value=" Logout" /></form></p1><%-- when we click customer profile we go with form action on logout.jsp --%>
<% } %>
<h2><font color="green">My Card</font> </h2>
<a href ="ShoppingList">add more product </a>
<br/>
<table style="background-color: #FBFCFC;" border="1">
<tr style="background-color:#E5E7E9;"><th>productID</th><th>images</th><th>productname</th><th>price</th><th>weight</th><th>details</th><th>Quantity</th><th>identity</th><th>Remove</th></tr>

<%@page import="java.util.ArrayList,zappyinfo.Zeppy" %>
<%@page import="connect.Addtocartconnect"%>

<%
double tamount=0;
ArrayList<Zeppy> ar=(ArrayList<Zeppy>)request.getAttribute("LIST");
for(Zeppy z:ar)
{
%>
<tr>
     <form action="addtocartCheckoutcontroller" method="post">
    <td><%=z.getProductID()%></td>
    <td><img src="images/<%=z.getImages()%>" heigth="100" width="100"/></a></td>
    <td><%=z.getProductname()%></td>
    <td><%=z.getPrice()%></td>
    <td><%=z.getWeight()%></td>
    <td><%=z.getDetails()%></td>
    <td>
   <%-- <form action="addtocartCheckoutcontroller" method="post">--%> 
    <input type="number" min="1" value="<%=z.getQuantity()%>" name="quantity" required/>
    <input type="hidden" name="productID" value="<%=z.getProductID() %>"/> 
   <input type="submit" value="update" name="op"/>
    </td>
    <td><%=z.getIpaddress()%></td> 
<td><h1><input type="submit" value="Delete" name="op"/></h1></td> 
    <input type="hidden" name="productID" value="<%=z.getProductID() %>"/> 
<%tamount=tamount+((z.getPrice())*(z.getQuantity())); %>
</form>
  </tr>
<% 
}
%>  


    </table>
</br>
</br>
<p1 align="left">
<form action="addtocartCheckoutcontroller" method="post">
<input type="submit" value="Checkout" name="op"/></form></p1>

<%!int a=0;%>
 <%!String ipaddress="";%>
<%@page import="connect.Addtocartconnect,java.net.InetAddress"%>
   <%
   HttpSession ss=request.getSession();//if user already login 
	 String x=(String)ss.getAttribute("user");
	if(x==null)//check if its not then send url CheckoutCLogin.jsp
	{
 InetAddress addr=InetAddress.getLocalHost();
	String ipaddress=addr.getHostAddress();
 //ipaddress =request.getRemoteAddr();
 Addtocartconnect pd=new Addtocartconnect();//it is an class and we create an object
 a=pd.countProduct(ipaddress);//by object we call countProduct(ipaddress) function and it all data give the value a
	}
	else
	{
		String email=x;
		Addtocartconnect pd1=new Addtocartconnect();//it is an class and we create an object
	    a=pd1.countProductemail(email);//by object we call countProduct(ipaddress) function and it all data give the value a
	}
   %>
   <br/>
Total product:  <%=a%>
Total Amount:   <%=tamount%>

</table>
</body>
</html>