/*
7b. Build a servlet program to find the factorial of a number using HTML.
*/

package com.factorial;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

// Annotation mapping (no web.xml needed)
@WebServlet("/factorial")
public class FactorialServlet extends HttpServlet {

    // Handle POST request from HTML form
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Set response type
        response.setContentType("text/html");

        // Writer to display output
        PrintWriter out = response.getWriter();

        try {
            // Get number from form
            int number = Integer.parseInt(request.getParameter("number"));

            // Validation
            if (number < 0) {
                throw new IllegalArgumentException("Number cannot be negative");
            }

            if (number > 20) {
                throw new IllegalArgumentException("Maximum allowed value is 20");
            }

            // Calculate factorial
            long factorial = 1;
            String calculation = "Calculation steps:<br>";

            if (number == 0 || number == 1) {
                factorial = 1;
                calculation += number + "! = 1";
            } else {
                calculation += number + "! = " + number;

                for (int i = number; i >= 1; i--) {
                    factorial *= i;

                    if (i != number) {
                        calculation += " × " + i;
                    }
                }

                calculation += " = " + factorial;
            }

            // Display result
            out.println("<html>");
            out.println("<head><title>Factorial Result</title></head>");
            out.println("<body>");

            out.println("<h2>Factorial Result</h2>");
            out.println("<p><b>Number:</b> " + number + "</p>");
            out.println("<p><b>Factorial:</b> " + factorial + "</p>");
            out.println("<p>" + calculation + "</p>");

            out.println("<a href='index.html'>Calculate Again</a>");

            out.println("</body>");
            out.println("</html>");

        } catch (NumberFormatException e) {
            displayError(out, "Please enter a valid number");
        } catch (IllegalArgumentException e) {
            displayError(out, e.getMessage());
        }
    }

    // Method to display error messages
    private void displayError(PrintWriter out, String message) {
        out.println("<html>");
        out.println("<body>");
        out.println("<h2 style='color:red;'>Error</h2>");
        out.println("<p>" + message + "</p>");
        out.println("<a href='index.html'>Try Again</a>");
        out.println("</body>");
        out.println("</html>");
    }

    // Redirect GET request to HTML page
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.sendRedirect("index.html");
    }
}
