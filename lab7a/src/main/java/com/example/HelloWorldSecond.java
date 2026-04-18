/*
Lab 7a: Execute the following Hello World Servlet Worked out Example
Running a Servlet without HTML file
*/

package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Annotation-based mapping (no web.xml required)
@WebServlet("/HelloWorldSecond")
public class HelloWorldSecond extends HttpServlet {

    private static final long serialVersionUID = 1L;

    // Default constructor
    public HelloWorldSecond() {
        super();
    }

    // Handles GET request
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Set response content type
        response.setContentType("text/html");

        // Create PrintWriter to send output
        PrintWriter out = response.getWriter();

        // Generate HTML output directly using servlet (no separate HTML file)
        out.println("<html><body>");

        // Display Hello World message
        out.println("<h2 style='color:blue;'>Hello World!!!</h2>");

        // Display current server date and time
        out.println("<p style='color:magenta;'>The server time is: " 
                    + new Date() + "</p>");

        out.println("</body></html>");
    }

    // Handles POST request (calls doGet method)
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }
}
