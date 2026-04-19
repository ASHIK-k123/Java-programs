/*12c. Develop a JDBC project using MySQL after appending the fields empno,
empname and basicsalary into the table Emp of the database Employee in Mysql and
by getting a character through keyboard using JSP and Generate the query report as
follows*/

package com.employee;

import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/SalaryServlet")
public class SalaryServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        String letter = request.getParameter("letter");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/Employee",
                "root",
                "ak@12345"
            );

            String query = "SELECT * FROM Emp WHERE Emp_Name LIKE ?";

            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, letter + "%");

            ResultSet rs = ps.executeQuery();

            response.getWriter().println("<h2>~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~</h2>");
            response.getWriter().println("<h2>Salary Report</h2>");
            response.getWriter().println("<h2>~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~</h2>");

            while (rs.next()) {

                response.getWriter().println(
                    "<b>Emp_No :</b> " + rs.getInt(1) + "<br>" +
                    "<b>Emp_Name :</b> " + rs.getString(2) + "<br>" +
                    "<b>Basic :</b> " + rs.getInt(3) + "<br>" +
                    "<h2>~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~</h2>"
                );
            }

        } catch (Exception e) {
            response.getWriter().println("Error: " + e);
        }
    }
}
