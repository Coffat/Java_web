package com.example.login.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LogoutServlet", urlPatterns = {"/logout"})
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String logoutType = request.getParameter("type");
        
        if ("cookie".equals(logoutType)) {
            // Clear the cookies
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if ("username".equals(cookie.getName())) {
                        cookie.setMaxAge(0); // Delete the cookie
                        response.addCookie(cookie);
                        break;
                    }
                }
            }
            response.sendRedirect(request.getContextPath() + "/cookie-login");
            
        } else if ("session".equals(logoutType)) {
            // Invalidate the session
            HttpSession session = request.getSession(false);
            if (session != null) {
                session.invalidate();
            }
            response.sendRedirect(request.getContextPath() + "/session-login");
            
        } else {
            // Default to home page if type not specified
            response.sendRedirect(request.getContextPath() + "/");
        }
    }
}
