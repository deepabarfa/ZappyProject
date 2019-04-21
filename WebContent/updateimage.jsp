<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body  bgcolor="#FEF9E7">
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
<h2><font color="green">Update Products image</font> </h2>
<% 
Zeppy z=(Zeppy)request.getAttribute("msg");
%>
<table>
<form action="PicupdateController" method="post" enctype="multipart/form-data">
<tr>
 <td>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<div class="form-group">
 <tr><td>Upload Your Image</td><td><div class="col-md-10">
                        <div>
                            <img id="user_img"
                                 height="130"
                                 width="130"
                                 style="border:solid" />
                        </div>
                        <div>
                        </td></tr>
                           
                           <td> 
                        
                           <input type="file" title="search image" id="file" name="file" onchange="show(this)" required="required"/>
                           <td><input type="hidden" value="<%=z.getProductID()%>" name="productID" /><td>
                           </td>
                        </div>
                    </div>
                </div>
                <tr><td><input type="submit" value=" pic Update" /></td>
  </tr>

</form>
</table>
</body>
</html>