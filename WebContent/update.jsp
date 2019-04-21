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
 <script type="text/javascript">
function show(input) {
        debugger;
        var validExtensions = ['jpg','png','jpeg']; //array of valid extensions
        var fileName = input.files[0].name;
        var fileNameExt = fileName.substr(fileName.lastIndexOf('.') + 1);
        if ($.inArray(fileNameExt, validExtensions) == -1) {
            input.type = ''
            input.type = 'file'
            $('#user_img').attr('src',"");
            alert("Only these file types are accepted : "+validExtensions.join(', '));
        }
        else
        {
        if (input.files && input.files[0]) {
            var filerdr = new FileReader();
            filerdr.onload = function (e) {
                $('#user_img').attr('src', e.target.result);
            }
            filerdr.readAsDataURL(input.files[0]);
        }
        }
    }

</script>
<p1 align="left">
<form action="AdminHome.jsp" method="get">
<input type="submit" value="Admin Home"/></form>
<form action="index.jsp" method="get">
<input type="submit" value="Zappy Home" /></form></p1>
<p1 align="right">
<form action="logout.jsp" method="get">
<input type="submit" value=" Logout" /></form></p1>
<%@page import="java.util.ArrayList,zappyinfo.Zeppy" %>
<h2><font color="green">Update Products</font> </h2>
<% 
Zeppy z=(Zeppy)request.getAttribute("msg");
%>

<table>
<form action="Opreation" method="post" enctype="multipart/form-data">
 <tr><td>productID</td><td><input type="text" value="<%=z.getProductID()%>" name="productID" required /><td><tr/>
<tr><td> productname</td><td><input type="text" value="<%=z.getProductname()%>" pattern="[a-zA-Z\s]+" name="productname" required/></td><tr/>
 <tr><td>price</td><td><input type="text" value="<%=z.getPrice()%>" pattern="\d+(\.\d{1,2})?" name="price"required/></td><tr/>
 <tr><td>weight(kg)</td><td><input type="text" value="<%=z.getWeight()%>" pattern="^[0-9]*$" name="weight" required/></td><tr/>
 <tr><td>details</td><td><input type="areatext" value="<%=z.getDetails()%>" pattern="^\S+.*?\S+$" name="details" required/></td><tr/>
 <tr><td>images</td><td><image src="images/<%=z.getImages()%>" height="125" weight="125"/>
 <tr><td><input type="submit" value="Update" /></td></tr>
 </form>
 <%-- </td><td><input type="file" value="<%=z.getImages()%>"name="file" accept=".jpg"/></td><tr/>--%>

</table>
<br/><br/>

</body>
</html>