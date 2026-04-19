/*
10.b Build an Application to get Rollno, Studentname, Sub1–Sub5 through JSP (index.jsp)
with client-side validation and submit to ResultServlet and process all fields with
server-side validation and display data along with result (Pass if all subjects > 40)
and average marks through result.jsp.
*/

package com.result;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/processResult")
public class ResultServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get parameters
        String rollno = request.getParameter("rollno");
        String name = request.getParameter("name");

        String message;

        try {
            int s1 = Integer.parseInt(request.getParameter("sub1"));
            int s2 = Integer.parseInt(request.getParameter("sub2"));
            int s3 = Integer.parseInt(request.getParameter("sub3"));
            int s4 = Integer.parseInt(request.getParameter("sub4"));
            int s5 = Integer.parseInt(request.getParameter("sub5"));

            // Server-side validation
            if (rollno == null || rollno.isEmpty() || name == null || name.isEmpty()) {
                message = "Error: Roll No and Name required";
            } else if (s1 < 0 || s2 < 0 || s3 < 0 || s4 < 0 || s5 < 0) {
                message = "Error: Marks cannot be negative";
            } else {

                // Calculate average
                double avg = (s1 + s2 + s3 + s4 + s5) / 5.0;

                // Check pass condition
                String result = (s1 > 40 && s2 > 40 && s3 > 40 && s4 > 40 && s5 > 40)
                        ? "PASS" : "FAIL";

                // Store attributes
                request.setAttribute("rollno", rollno);
                request.setAttribute("name", name);
                request.setAttribute("s1", s1);
                request.setAttribute("s2", s2);
                request.setAttribute("s3", s3);
                request.setAttribute("s4", s4);
                request.setAttribute("s5", s5);
                request.setAttribute("average", avg);
                request.setAttribute("result", result);

                message = "Result Processed Successfully";
            }

        } catch (NumberFormatException e) {
            message = "Error: Invalid marks entered";
        }

        request.setAttribute("message", message);

        // Forward to result.jsp
        RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
        rd.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.sendRedirect("index.jsp");
    }
}
