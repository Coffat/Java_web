package com.example.login.servlets;

import com.example.login.models.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CookieLoginServlet", urlPatterns = {"/cookie-login"})
public class CookieLoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Check if user is already logged in by checking cookies
        Cookie[] cookies = request.getCookies();
        boolean isLoggedIn = false;
        
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("username".equals(cookie.getName())) {
                    request.setAttribute("username", cookie.getValue());
                    isLoggedIn = true;
                    break;
                }
            }
        }
        
        if (isLoggedIn) {
            request.getRequestDispatcher("/WEB-INF/cookie-welcome.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/WEB-INF/cookie-login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String rememberMe = request.getParameter("rememberMe");
        
        User user = new User(username, password);
        
        if (user.validate()) {
            // Create cookie if remember me is checked
            if (rememberMe != null && rememberMe.equals("on")) {
                Cookie usernameCookie = new Cookie("username", username);
                // Set cookie to last for 24 hours (in seconds)
                usernameCookie.setMaxAge(24 * 60 * 60);
                response.addCookie(usernameCookie);
            }
            
            request.setAttribute("username", username);
            request.getRequestDispatcher("/WEB-INF/cookie-welcome.jsp").forward(request, response);
        } else {
            request.setAttribute("error", "Invalid username or password");
            request.getRequestDispatcher("/WEB-INF/cookie-login.jsp").forward(request, response);
        }
    }
}
