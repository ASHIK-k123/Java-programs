/*
7c. Build a servlet program to check the given number is prime number or not,
using HTML with Error Code when an invalid number is entered.
*/

package com.prime;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

// Annotation mapping
@WebServlet("/prime")
public class PrimeServlet extends HttpServlet {

    // Handle POST request
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            // Get input from HTML form
            int number = Integer.parseInt(request.getParameter("number"));

            // Validate input
            if (number < 0) {
                throw new IllegalArgumentException("Number cannot be negative");
            }

            // Check prime logic
            boolean isPrime = true;

            if (number == 0 || number == 1) {
                isPrime = false;
            } else {
                for (int i = 2; i <= number / 2; i++) {
                    if (number % i == 0) {
                        isPrime = false;
                        break;
                    }
                }
            }

            // Display result
            out.println("<html><body>");
            out.println("<h2>Prime Number Result</h2>");
            out.println("<p>Number: " + number + "</p>");

            if (isPrime) {
                out.println("<p style='color:green;'><b>" + number + " is a Prime Number</b></p>");
            } else {
                out.println("<p style='color:red;'><b>" + number + " is NOT a Prime Number</b></p>");
            }

            out.println("<a href='index.html'>Check Another Number</a>");
            out.println("</body></html>");

        } catch (NumberFormatException e) {
            // Invalid number error
            displayError(response, "Invalid input! Please enter a valid integer.");
        } catch (IllegalArgumentException e) {
            displayError(response, e.getMessage());
        }
    }

    // Error display method
    private void displayError(HttpServletResponse response, String message) throws IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h2 style='color:red;'>Error</h2>");
        out.println("<p>" + message + "</p>");
        out.println("<a href='index.html'>Try Again</a>");
        out.println("</body></html>");
    }

    // Redirect GET request to HTML page
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.sendRedirect("index.html");
    }
}
