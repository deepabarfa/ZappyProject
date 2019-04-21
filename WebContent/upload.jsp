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

 <h3><font color="green">Add Zappy Products</font> </h3 >
 <h3><font color="blue"><%String m=(String)request.getAttribute("msg");
 if(m!=null)
	 out.println(m);
%></font></h3>
 <table>
 <pre>
 <form action="UploadProduct" method="post" enctype="multipart/form-data">
 <font color="blue">Product Name </font> <input type="text" pattern="[a-zA-Z\s]+" name="productname" required /><br/>
 <font color="blue">price </font>        <input type="text" pattern="\d+(\.\d{1,2})?" name="price" required /><br/>
 <font color="blue">weight(kg) </font>   <input type="text" pattern="^[0-9]*$" name="weight" required/><br/>
<font color="blue"> Details </font>      <input type="areatext" pattern="^\S+.*?\S+$" name="details" required/><br/>
 <font color="blue">Images</font>        <%--<input type="file" name="file" accept=".jpg"  required/><br/>--%>
          
          <td>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<div class="form-group">
 <td><div class="col-md-10">
                            <img id="user_img"
                                 height="130"
                                 width="130"
                                 style="border:solid" />
                        </td><td> 
                           <input type="file" title="search image" id="file" name="file" onchange="show(this)" required="required"/>
</td>
                        </div>
                </div></td>
<tr><td><input type="submit" /></td></tr>
 </form>
 </pre>
 </table>
</body>
</html>