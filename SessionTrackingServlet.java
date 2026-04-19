package com.lab9;

/*
9.a Build a Session Management using Servlet program (without using HTML file)
set with one minute session to show Session Tracking Information,
Session ID, Session Creation Time, Last Access Time, Visit Count
*/



import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// Annotation-based mapping (no web.xml required)
@WebServlet("/SessionTracker")
public class SessionTrackingServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Set response type
        response.setContentType("text/html");

        // Create writer to display output
        PrintWriter out = response.getWriter();

        // Get existing session or create a new one
        HttpSession session = request.getSession(true);

        // Set session expiry time to 60 seconds (1 minute)
        session.setMaxInactiveInterval(60);

        // Get session details
        String sessionId = session.getId(); // Unique session ID
        Date createTime = new Date(session.getCreationTime()); // Creation time
        Date lastAccessTime = new Date(session.getLastAccessedTime()); // Last access time

        // Retrieve visit count from session
        Integer visitCount = (Integer) session.getAttribute("visitCount");

        // If first visit, initialize count
        if (visitCount == null) {
            visitCount = 1;
        } else {
            visitCount++; // Increment on refresh
        }

        // Store updated visit count
        session.setAttribute("visitCount", visitCount);

        // Generate HTML response (no separate HTML file used)
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head><title>Session Tracking Demo</title></head>");
        out.println("<body>");

        out.println("<h2>Session Tracking Information</h2>");
        out.println("<p><b>Session ID:</b> " + sessionId + "</p>");
        out.println("<p><b>Session Creation Time:</b> " + createTime + "</p>");
        out.println("<p><b>Last Access Time:</b> " + lastAccessTime + "</p>");
        out.println("<p><b>Visit Count:</b> " + visitCount + "</p>");

        out.println("<p>Refresh the page to increase visit count.</p>");
        out.println("<p>Wait for 1 minute to see session expiry.</p>");

        out.println("</body>");
        out.println("</html>");
    }
}
