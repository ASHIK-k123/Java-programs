/*
10.a Build an Application to get Username, Email and Designation through JSP (index.jsp)
with client-side validation and submit to the servlet (UserDataServlet) and process all fields
with server-side validation and display data through result.jsp with a link back to client page.
*/

package com.HTTP_REQ_RE;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/processUser")
public class UserDataServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get form data
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String designation = request.getParameter("designation");

        String message;

        // Server-side validation
        if (username == null || username.trim().isEmpty()) {
            message = "Error: Username is required";
        } else if (email == null || !email.contains("@")) {
            message = "Error: Invalid Email";
        } else if (designation == null || designation.trim().isEmpty()) {
            message = "Error: Designation is required";
        } else {
            message = "User data processed successfully";

            // Store data in request scope
            request.setAttribute("username", username);
            request.setAttribute("email", email);
            request.setAttribute("designation", designation);
        }

        request.setAttribute("message", message);

        // Forward to result.jsp
        RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
        rd.forward(request, response);
    }

    // Redirect GET request to form page
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.sendRedirect("index.jsp");
    }
}
