package com.example.login.servlets;

import com.example.login.models.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "SessionLoginServlet", urlPatterns = {"/session-login"})
public class SessionLoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Check if user is already logged in using session
        HttpSession session = request.getSession(false);
        
        if (session != null && session.getAttribute("username") != null) {
            request.setAttribute("username", session.getAttribute("username"));
            request.getRequestDispatcher("/WEB-INF/session-welcome.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/WEB-INF/session-login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        User user = new User(username, password);
        
        if (user.validate()) {
            // Create session and add username attribute
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            // Session timeout after 30 minutes of inactivity
            session.setMaxInactiveInterval(30 * 60);
            
            request.setAttribute("username", username);
            request.getRequestDispatcher("/WEB-INF/session-welcome.jsp").forward(request, response);
        } else {
            request.setAttribute("error", "Invalid username or password");
            request.getRequestDispatcher("/WEB-INF/session-login.jsp").forward(request, response);
        }
    }
}
