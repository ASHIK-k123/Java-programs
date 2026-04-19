<!DOCTYPE html>
<html>
<head>
    <title>Employee Form</title>
</head>
<body>

<h2>Employee Entry</h2>

<form action="AddEmployeeServlet" method="post">
    Emp No: <input type="text" name="empno"><br><br>
    Name: <input type="text" name="empname"><br><br>
    Salary: <input type="text" name="salary"><br><br>

    <input type="submit" value="Insert">
</form>

<br>
<a href="Employee.jsp">View Employees</a>

</body>
</html>
