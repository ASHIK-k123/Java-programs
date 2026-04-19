<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
<title>Result</title>
<style>
.success { color: green; }
.error { color: red; }
</style>
</head>

<body>

<h2>Student Result</h2>

<%
String msg = (String) request.getAttribute("message");
boolean isError = msg != null && msg.startsWith("Error");
%>

<p class="<%= isError ? "error" : "success" %>"><%= msg %></p>

<% if (!isError) { %>

<p>Roll No: <%= request.getAttribute("rollno") %></p>
<p>Name: <%= request.getAttribute("name") %></p>

<p>Sub1: <%= request.getAttribute("s1") %></p>
<p>Sub2: <%= request.getAttribute("s2") %></p>
<p>Sub3: <%= request.getAttribute("s3") %></p>
<p>Sub4: <%= request.getAttribute("s4") %></p>
<p>Sub5: <%= request.getAttribute("s5") %></p>

<p><b>Average:</b> <%= request.getAttribute("average") %></p>
<p><b>Result:</b> <%= request.getAttribute("result") %></p>

<% } %>

<br>
<a href="index.jsp">Back to Form</a>

</body>
</html>
