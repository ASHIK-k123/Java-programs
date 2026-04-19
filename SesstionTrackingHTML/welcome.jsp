<%--
9.b Build a Session Management using JSP program set with one minute session expiry time
to get your name through text box and press submit to display the message by greeting Hello your name!.
Check the expiry of the session after one minute.
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
    // Retrieve the name entered by the user from the form
    String name = request.getParameter("uname");

    // Display welcome message
    out.print("Welcome! " + name);

    // Indicate that session has started
    out.print("<br>Session has started ... " + name);

    // Store the username in session object
    session.setAttribute("user", name);
    out.print("<br>Your name has been stored in session object");

    // Set session expiry time to 60 seconds (1 minute)
    session.setMaxInactiveInterval(60);
    out.print("<br>One minute is set for the session expiry");

    // Instructions for user
    out.print("<br>Click the link below within one minute or wait for a minute to see session expiry<br>");
%>

<!-- Link to check session value -->
<a href="second.jsp">Display the value</a>

</body>
</html>
