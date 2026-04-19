/*11 c. Develop a JDBC project using JDBC to append the fields empno, empname and
basicsalary into the table Emp of the database Employee by getting the fields through
keyboard using index.jsp and Generate the report using Employee.jsp as follows*/

package com.employee;

import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/AddEmployeeServlet")
public class AddEmployeeServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        String empno = request.getParameter("empno");
        String empname = request.getParameter("empname");
        String salary = request.getParameter("salary");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/Employee",
                "root",
                "ak@12345"   // CHANGE THIS
            );

            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO Emp VALUES (?, ?, ?)"
            );

            ps.setInt(1, Integer.parseInt(empno));
            ps.setString(2, empname);
            ps.setInt(3, Integer.parseInt(salary));

            int i = ps.executeUpdate();

            if (i > 0) {
                response.getWriter().println("<h2>Employee Inserted Successfully</h2>");
            }

        } catch (Exception e) {
            response.getWriter().println("<h2>Error: " + e + "</h2>");
        }
    }
}
