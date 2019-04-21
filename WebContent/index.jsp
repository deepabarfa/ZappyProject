<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ZappyFood</title>
</head>

<body bgcolor="#FEF9E7">
<%
response.setHeader("Cache-Control", "no-cache");
response.setHeader("Cache-Control", "no-store");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);
%>
<%response.sendRedirect("ShoppingList"); %> <%--when project run, it will first come index page, and here
"response.sendredirect send the request ShoppingList Servlet and this servlet is available in test package"

We live in the net age, where everything is smart, fast and easy; then why should our cooking be the same tedious time-consuming chore. Zappy brings the ultimate convenience into the kitchen with a veritable range of Ready to Eat, Drink and Cook products.
Zappy makes you happy by taking the stress out of cooking. Surprise your family and friends with the tastiest snacks, drinks and desserts. All prepared in a few minutes with practically no effort at all.
All Zappy products are made with natural ingredients with a special packing that retains the freshness and taste. Plus, every recipe has been carefully selected to give you the best in taste and health.
Now, don’t worry about ‘What to cook today?’ any more. Just open a Zappy pack and see your family glow with happiness, or should we say, zappiness!

We use MVC
Model-
.javafile(not servlet or jsp)
it is contain all secure/ jdbc/business logic code
view-
it is a file that display data on web browser(html page or jsp or may be servlet)
controller-
file that provide interaction between model and view ( servlet / jsp)

--%>
</body>
</html>