<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Zappy</title>
<link rel="icon" href="favicon.ico" type="image/x-icon" />

</head>
<body>
  <%
response.setHeader("Cache-Control", "no-cache");
response.setHeader("Cache-Control", "no-store");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);
%>   
	</br>
	</br>
	<form action="Logout" method="post">
		<input type="submit" value="Logout">
	</form>
	
<script type="text/javascript" src="http://code.jquery.com/jquery-1.6.2.js"></script>
<div id="likes">
    <span class="figure"></span>
</div>
<button type="submit" id="addcart">Like</button>
<script type="text/javascript">
    var clicks = 0; $("#addcart").click(function(){ clicks++; $('.figure').html(clicks);});
</script>	
	
	
	
	
</body>
</html>