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
<title>Session Check</title>
</head>
<body>

<h2>Session Status</h2>

<%
    // Retrieve name from session
    String name = (String) session.getAttribute("user");

    // Check if session expired
    if (name == null) {
        out.print("<b>Sorry, session has expired!</b>");
    } else {
        out.print("<b>Hello " + name + "</b>");
    }
%>

</body>
</html>
