/*
8a. Build a servlet program to create a cookie to get your name through text box and press
submit button to display the message by greeting Welcome back your name!,
you have visited this page n times and demonstrate the expiry of cookie.
*/

package com.cookieservlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    // Handle GET request
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String userName = request.getParameter("userName");

        // Create cookies if user enters name
        if (userName != null && !userName.isEmpty()) {

            // Cookie for username
            Cookie nameCookie = new Cookie("user", userName);

            // Cookie for visit count
            Cookie countCookie = new Cookie("count", "1");

            // Set expiry time (30 seconds for demo)
            nameCookie.setMaxAge(30);
            countCookie.setMaxAge(30);

            response.addCookie(nameCookie);
            response.addCookie(countCookie);
        }

        // Read cookies
        Cookie[] cookies = request.getCookies();

        String existingUser = null;
        int visitCount = 0;

        if (cookies != null) {
            for (Cookie c : cookies) {

                if (c.getName().equals("user")) {
                    existingUser = c.getValue();
                }

                if (c.getName().equals("count")) {
                    visitCount = Integer.parseInt(c.getValue());
                    visitCount++;

                    // Update count cookie
                    Cookie updatedCount = new Cookie("count", String.valueOf(visitCount));
                    updatedCount.setMaxAge(30);
                    response.addCookie(updatedCount);
                }
            }
        }

        // Generate response
        out.println("<html><body>");

        if (existingUser != null) {

            out.println("<h2 style='color:blue;'>Welcome back, " + existingUser + "!</h2>");
            out.println("<h3 style='color:magenta;'>You have visited this page "
                    + visitCount + " times!</h3>");

            out.println("<p>Cookie will expire in 30 seconds. Wait and refresh to see expiry.</p>");

        } else {

            // First time user
            out.println("<h2 style='color:red;'>Welcome Guest! Please enter your name:</h2>");

            out.println("<form action='CookieServlet' method='get'>");
            out.println("Name: <input type='text' name='userName'>");
            out.println("<input type='submit' value='Submit'>");
            out.println("</form>");
        }

        out.println("</body></html>");
    }
}
