


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>order</title>
</head>
<body bgcolor="#FEF9E7">

<%
response.setHeader("Cache-Control", "no-cache");
response.setHeader("Cache-Control", "no-store");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);
%>
<p1 align="left">
<form action="CHome.jsp" method="post">
<input type="submit" value="Customer Home" /></form><%--buttons --%>
<form action="index.jsp" method="get">
<input type="submit" value="Zappy Home" /></form>
<form action="Addtocard" method="get">
<input type="submit" value="Back" /></form></p1>
<p1 align="right">
<form action="logout.jsp" method="post">
<input type="submit" value="LogOut" /></form></p1>

<h1>Customer Details</h1>
<%@page import="java.util.ArrayList,zappyinfo.Zeppy" %>
<%
ArrayList<Zeppy> ar=(ArrayList<Zeppy>)request.getAttribute("LIST");//get list from Allinfo servlet
for(Zeppy z:ar)
{
	
%>
Email:<%=z.getEmail()%><br/><%--get value from servlet and call by getter function which is available in zappy class and it is get by database --%>
Name:<%=z.getName()%><br/>
LastName:<%=z.getLastname()%><br/>
City:<%=z.getCity()%><br/>
State:<%=z.getState()%><br/>
Pin:<%=z.getPin()%><br/>
address:<%=z.getAddress()%><br/>
mobile:<%=z.getMobile()%><br/>

</td>  

<% 
}
%>
<br/>
<a href ="ShoppingList">More shopping </a>
<br/>
<h1>product Details</h1>
<table style="background-color:#E5E7E9;" border="1">
<tr style="background-color: #FBFCFC;"><th>productID</th><th>images</th><th>productname</th><th>price</th><th>weight</th><th>details</th><th>Quantity</th><th>identity</th><th>Order</th></tr>
<%-- heading --%>
<%@page import="java.util.ArrayList,zappyinfo.Zeppy" %>
<%
double tamount=0;
ArrayList<Zeppy> ar1=(ArrayList<Zeppy>)request.getAttribute("LIST1");
for(Zeppy z:ar1) //also get LIST1 from Allinfo servlet
{
%>
<tr>
<form action="OrderController" method="post">
    <td><%=z.getProductID()%></td>
    <input type="hidden" name="productID" value="<%=z.getProductID()%>"/>
    <td><img src="images/<%=z.getImages()%>" heigth="75" width="75" /></td>
    <td><%=z.getProductname()%></td>
    <td><%=z.getPrice()%></td>
    <td><%=z.getWeight()%></td>
    <td><%=z.getDetails()%></td>
    <td>
    <input type="number" min="1" value="<%=z.getQuantity()%>" name="quantity" required/>
    <input type="hidden" name="productID" value="<%=z.getProductID() %>"/>
   <input type="submit" value="update" name="op"/>
    </td>
    <td><%=z.getIpaddress()%></td>  
<%tamount=tamount+((z.getPrice())*(z.getQuantity())); %><%--perform opreation --%>
  <td><input type="submit" value="Order Now" name="op"/>
  <input type="submit" value="Delete" name="op"/>
  <%--if we click Order Now it will request go OrderController by form action --%>
  </form></td></tr>
<% 
}
%>  
</table>


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
</body>
</html>