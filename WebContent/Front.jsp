<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.css"/>
<style type="text/css">
.box {
	width: 100%;
	margin: auto;
	padding: 10px;
	max-width: 400px;
	border-radius: 2px;
	box-shadow: $shadow2;
}
.photo{
  text-align: centre;
  overflow: hidden;
  height: 150px;
}

.photo2{
  text-align: centre;
  overflow: hidden;
  max-width:150px;
}

.photo3{
  text-align: centre;
  overflow: hidden;
}

.photo img{
    height: 150px;
}

.photo2 img{
    width: 150px;
}

.photo3{
  overflow:hidden;
  width: 150px;
  height: 150px;
}


div.gallery {
    margin: 5px;
    border: 1px solid #ccc;
    float: left;
    width: 180px;
}

div.gallery:hover {
    border: 1px solid #777;
}

div.gallery img {
    width: 100%;
    height: auto;
}

table { 
  width: 100%; 
  border-collapse: collapse;
  background="image/light_background_texture_69531_3840x2160.jpg"; 
}
/* Zebra striping */
tr:nth-of-type(odd) { 
  background: background="image/light_background_texture_69531_3840x2160.jpg"; 
}
th { 
  background: background="image/light_background_texture_69531_3840x2160.jpg"; 
  color: white; 
  font-weight: bold; 
}
td, th { 
  padding: 6px; 
  border: 1px solid #ccc; 
  text-align: left; 
}
@media 
only screen and (max-width: 760px),
(min-device-width: 768px) and (max-device-width: 1024px)  {

	/* Force table to not be like tables anymore */
	table, thead, tbody, th, td, tr { 
		display: block; 
	}
	
	/* Hide table headers (but not display: none;, for accessibility) */
	thead tr { 
		position: absolute;
		top: -9999px;
		left: -9999px;
	}
	
	tr { border: 1px solid #ccc; }
	
	td { 
		/* Behave  like a "row" */
		border: none;
		border-bottom: 1px solid #eee; 
		position: relative;
		padding-left: 50%; 
	}
	
	td:before { 
		/* Now like a table header */
		position: absolute;
		/* Top/left values mimic padding */
		top: 6px;
		left: 6px;
		width: 45%; 
		padding-right: 10px; 
		white-space: nowrap;
	}

}
p1
{
margin: 0 auto;
width: 800px;

}



</style>
</head>
<body background="image/light_background_texture_69531_3840x2160.jpg">
<%
response.setHeader("Cache-Control", "no-cache");
response.setHeader("Cache-Control", "no-store");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);
%>
<%
   HttpSession ss2=request.getSession();//if user already login 
	 String x2=(String)ss2.getAttribute("user");
	if(x2==null)//check if its not then send url CheckoutCLogin.jsp
	{%>
<p1 align="left">
<form action="AdminloginCheckout" method="Post">
<input type="submit" value="Admin" /></form></p1><% } %> 
<%
   HttpSession ss4=request.getSession();//if user already login 
	 String x4=(String)ss4.getAttribute("uid");
	if(x4!=null)//check if its not then send url CheckoutCLogin.jsp
	{%>
<p1 align="right">
<form action="logout.jsp" method="get">
<input type="submit" value=" Logout" /></form></p1><%-- when we click customer profile we go with form action on logout.jsp --%>
<% } %>
<%-- it is an action button that is perform the action on click which is send the request on there form action and here we go with form action on AdminloginCheckout--%>
<%HttpSession ss3=request.getSession();//check admin login or not
		 String x3=(String)ss3.getAttribute("uid");
		if(x3==null)//if admin not login
		{ %>
<p1 align="right">
<form action="CutomerLoginCheckout" method="Post">
<input type="submit" value=" Customer Profile" /></form></p1><% } %><%-- when we click customer profile we go with form action on CutomerLoginCheckout --%>
<%
   HttpSession ss1=request.getSession();//if user already login 
	 String x1=(String)ss1.getAttribute("user");
	if(x1!=null)//check if its not then send url CheckoutCLogin.jsp
	{%>
<p1 align="right">
<form action="logout.jsp" method="get">
<input type="submit" value=" Logout" /></form></p1><%-- when we click customer profile we go with form action on logout.jsp --%>
<% } %>
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

<center>
<img src="image/zappy-logo.png" heigth="150" width="150" /></img> <%-- it is an image of zappy --%>
</center><center>
<h3><%String m=(String)request.getAttribute("msg"); 
if(m!=null)
	out.println(m);
%></h3><%-- It get the attribute where set the msg attribute--%>
</center><center>
<%HttpSession ss5=request.getSession();//check admin login or not
		 String x5=(String)ss5.getAttribute("uid");
		if(x5==null)//if admin not login
		{ %>
<form action="Addtocard" method="get">
<input type="submit" value="show add to cart product(<%=a%>)" /></form>
<%} %></center><center>
<%@page import="java.util.ArrayList,zappyinfo.Zeppy" %>
<%
ArrayList<Zeppy> ar=(ArrayList<Zeppy>)request.getAttribute("LIST"); // get the list attribute which is set shoppingList servlet and get the all data in the arraylist form.
if(ar!=null)
{	int b=0;
	%><table background="image/light_background_texture_69531_3840x2160.jpg"><%
			for(Zeppy z:ar)
	{
			if(b%5==0) // we want to get the data in table sequence of four
			{
			out.println("<tr>");
		    %>
			<td>
			<form action="Addtocard" method="post">
   <center><h4>Product Name =<%=z.getProductID()%></h4></center> <%--get the productid with zeppy object z--%>
    <center><div class="photo"><a href="ViewproductDetailsController?productID=<%=z.getProductID()%>"><img src="images/<%=z.getImages()%>" heigth="150" width="150" /></a></div></br></center> <%-- we create a link when we click image it will go ViewproductDetailsController servlet and that is show the all product details--%>
    <center><b>Product Name</b> =<%=z.getProductname()%><br/></center><%--get the productname with getter function--%>
    <center><b>Price</b> =<%=z.getPrice()%>Rs<br/></center><%-- get the price --%>
   <center><b>Weight</b> = <%=z.getWeight()%><br/></center><%--get the weight --%>
   <center><b>Details</b> =<%=z.getDetails()%><br/></center><%--get details --%>
     <%-- <td><input type="number" value="quantity"/></td> --%>
   <center> <input type="hidden" name="productID" value="<%=z.getProductID() %>"/></center><%--it is hidden field with get the productid--%>
    <center><input type="submit" value="Addtocart" name="work"/><br/></center> <%--when we click the addtocart we go with form action on Addtocard servlet--%>
    <center><input type="number" min="1" value="1" name="quantity" required/><br/></center> <%--it is field of quantity that we set minimum value 1  --%>
   <center> <input type="hidden" value="<%=z.getPrice()%>" name="price" /></center>  <%--we also create another hidden field which is get price --%> 
  </form>
		</td>
	<%
			}else{
				%>
				<td>
<form action="Addtocard" method="post">                                            </br>
   <center><h4>Product Name =<%=z.getProductID()%></h4></center>
    <center><div class="photo"><a href="ViewproductDetailsController?productID=<%=z.getProductID()%>"><img src="images/<%=z.getImages()%>" heigth="150" width="150" /></a></div></br></center>
    <center><b>Product Name</b> =<%=z.getProductname()%><br/></center>
    <center><b>Price</b> =<%=z.getPrice()%>Rs<br/></center>
   <center><b>Weight</b> = <%=z.getWeight()%><br/></center>
   <center><b>Details</b> =<%=z.getDetails()%><br/></center>
     <%-- <td><input type="number" value="quantity"/></td> --%>
   <center><input type="hidden" name="productID" value="<%=z.getProductID() %>"/></center>
    <center><input type="submit" value="Addtocart" name="work"/><br/></center>
    <center><input type="number" min="1" value="1" name="quantity" required/><br/></center>
    <center><input type="hidden" value="<%=z.getPrice()%>" name="price" /> </center>  
																						
						</center>
					</form>
				</td>
				
				<%
			if(b%5==4)
				out.println("</tr>");
			    	
		    }		
			b++;

		}
							
    
%>
		</table>				
	<%
}
%>
</center>
</center>
</body>
</html>
