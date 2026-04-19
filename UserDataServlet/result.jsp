<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
<title>Result Page</title>

<style>
.container {
    width: 300px;
    margin: auto;
    padding: 20px;
    border: 1px solid #ccc;
}
.success { color: green; }
.error { color: red; }
</style>

</head>
<body>

<div class="container">

<h2>Result</h2>

<%
String message = (String) request.getAttribute("message");
boolean isError = message != null && message.startsWith("Error");
%>

<p class="<%= isError ? "error" : "success" %>">
<%= message %>
</p>

<% if (!isError) { %>
<h3>Submitted Data:</h3>
<p>Username: <%= request.getAttribute("username") %></p>
<p>Email: <%= request.getAttribute("email") %></p>
<p>Designation: <%= request.getAttribute("designation") %></p>
<% } %>

<br>
<a href="index.jsp">Back to Form</a>

</div>

</body>
</html>
