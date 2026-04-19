/*
8.b Build a servlet program to create a cookie to get your name through text box and
press submit button (through HTML) to display the message by greeting Welcome back
your name!, you have visited this page n times along with the list of cookies and their values
and demonstrate the expiry of cookie.
*/

package com.cookieservlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String userName = request.getParameter("userName");

        // If user enters name → create cookies
        if (userName != null && !userName.isEmpty()) {

            Cookie nameCookie = new Cookie("user", userName);
            Cookie countCookie = new Cookie("count", "1");

            // Set expiry (30 seconds for demo)
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
                    Cookie updated = new Cookie("count", String.valueOf(visitCount));
                    updated.setMaxAge(30);
                    response.addCookie(updated);
                }
            }
        }

        // HTML response
        out.println("<html><body>");

        if (existingUser != null) {

            out.println("<h2 style='color:blue;'>Welcome back, " + existingUser + "!</h2>");
            out.println("<h3>You have visited this page " + visitCount + " times</h3>");

            // Display all cookies
            out.println("<h3>List of Cookies:</h3>");

            if (cookies != null) {
                for (Cookie c : cookies) {
                    out.println("Cookie Name: " + c.getName() + "<br>");
                    out.println("Value: " + c.getValue() + "<br><br>");
                }
            }

            out.println("<p style='color:red;'>Wait 30 seconds and refresh to see cookie expiry</p>");

        } else {

            // First-time user
            out.println("<h2>Enter Your Name</h2>");

            out.println("<form action='CookieServlet' method='get'>");
            out.println("Name: <input type='text' name='userName'>");
            out.println("<input type='submit' value='Submit'>");
            out.println("</form>");
        }

        out.println("</body></html>");
    }
}
