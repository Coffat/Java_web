<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Error Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
            background-color: #f4f4f4;
        }
        .error-container {
            max-width: 600px;
            margin: 0 auto;
            background: white;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            text-align: center;
        }
        h1 {
            color: #d9534f;
        }
        .home-link {
            display: inline-block;
            margin-top: 20px;
            padding: 10px 20px;
            background: #5bc0de;
            color: white;
            text-decoration: none;
            border-radius: 4px;
        }
    </style>
</head>
<body>
    <div class="error-container">
        <h1>Oops! Something went wrong</h1>
        <p>Sorry, an error occurred while processing your request.</p>
        <p>Please try again later or contact support if the problem persists.</p>
        
        <% if(exception != null) { %>
            <div style="color: #777; margin-top: 20px; text-align: left; font-size: 14px;">
                <p><strong>Error details:</strong> <%= exception.getMessage() %></p>
            </div>
        <% } %>
        
        <a href="${pageContext.request.contextPath}/" class="home-link">Return to Home Page</a>
    </div>
</body>
</html>
