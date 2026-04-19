package com.employee;

import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {

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

           
            // 1. DELETE OPERATION
           
            String deleteQuery = "DELETE FROM Emp WHERE Emp_Name LIKE ?";

            PreparedStatement ps1 = con.prepareStatement(deleteQuery);
            ps1.setString(1, letter + "%");

            ps1.executeUpdate();

           
            // 2. SELECT REMAINING DATA
        
            String selectQuery = "SELECT * FROM Emp";

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(selectQuery);

           
            // 3. PRINT REPORT
         
            response.getWriter().println("<h2>Salary Report</h2>");

            while (rs.next()) {

                response.getWriter().println(
                    "<h3>~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~</h3>" +
                    "<b>Emp_No :</b> " + rs.getInt(1) + "<br>" +
                    "<b>Emp_Name :</b> " + rs.getString(2) + "<br>" +
                    "<b>Basic :</b> " + rs.getInt(3) + "<br>"
                );
            }

            response.getWriter().println("<h3>~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~</h3>");

        } catch (Exception e) {
            response.getWriter().println("Error: " + e);
        }
    }
}
