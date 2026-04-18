<%--
7.a Build a Session Management using JSP program set with one minute session expiry time
to get your name through text box and press submit to display the message by greeting 
Hello your name!. Check the expiry of the session after one minute.
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Session Started</title>
</head>
<body>

<%
    // Get user input from form
    String name = request.getParameter("uname");

    // Display greeting message
    out.print("<h3>Hello " + name + "</h3>");

    // Store name in session object
    session.setAttribute("user", name);

    // Set session expiry time to 60 seconds (1 minute)
    session.setMaxInactiveInterval(60);

    out.print("Session started successfully.<br>");
    out.print("Session will expire in 1 minute.<br><br>");
%>

<!-- Link to check session -->
<a href="check.jsp">Check Session Value</a>

</body>
</html>
