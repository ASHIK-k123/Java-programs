<%--
9.c Build a Session Management using JSP program for getting session expiry time and your name
through text box and press submit to display the message by greeting Hello your name!.
Press the following link to check it within the set session time or wait there for the minutes set 
to see the session expiry.
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
    // Get user input
    String name = request.getParameter("uname");
    String timeStr = request.getParameter("time");

    int time = 0;

    // Convert time input from string to integer
    try {
        time = Integer.parseInt(timeStr);
    } catch(Exception e) {
        out.print("Invalid time entered<br>");
    }

    // Store name in session
    session.setAttribute("user", name);

    // Set session expiry time based on user input
    session.setMaxInactiveInterval(time);

    // Display messages
    out.print("<h3>Hello " + name + "</h3>");
    out.print("Session started successfully.<br>");
    out.print("Session expiry time: " + time + " seconds<br><br>");

    out.print("Click the link below within the set time or wait to see session expiry.<br><br>");
%>

<!-- Link to check session -->
<a href="check.jsp">Check Session</a>

</body>
</html>
