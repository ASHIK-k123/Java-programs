<%@ page import="java.sql.*" %>

<h2>Employee Report</h2>

<table border="1">
<tr>
    <th>Emp No</th>
    <th>Name</th>
    <th>Salary</th>
</tr>

<%
Class.forName("com.mysql.cj.jdbc.Driver");

Connection con = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/Employee",
    "root",
    "ak@12345"
);

Statement st = con.createStatement();
ResultSet rs = st.executeQuery("SELECT * FROM Emp");

while(rs.next()) {
%>
<tr>
    <td><%= rs.getInt(1) %></td>
    <td><%= rs.getString(2) %></td>
    <td><%= rs.getInt(3) %></td>
</tr>
<%
}
%>

</table>

<br>
<a href="index.jsp">Back</a>
