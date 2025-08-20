<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome - Session Authentication</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
            background-color: #f4f4f4;
        }
        .container {
            max-width: 600px;
            margin: 0 auto;
            background: white;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            text-align: center;
        }
        h1 {
            color: #333;
        }
        .user-info {
            margin: 20px 0;
            padding: 15px;
            background: #e9f7ef;
            border-radius: 5px;
        }
        .btn {
            display: inline-block;
            padding: 10px 20px;
            background: #4CAF50;
            color: white;
            text-decoration: none;
            border-radius: 4px;
            margin-top: 15px;
        }
        .btn-logout {
            background: #f44336;
        }
        .links {
            margin-top: 20px;
        }
        .links a {
            margin: 0 10px;
        }
        .session-info {
            margin-top: 20px;
            font-size: 14px;
            color: #666;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Welcome to Session Authentication Demo</h1>
        
        <div class="user-info">
            <h2>Hello, <%= request.getAttribute("username") %>!</h2>
            <p>You have been successfully authenticated using session.</p>
        </div>
        
        <div class="auth-info">
            <h3>Authentication Information</h3>
            <p>Your login is currently being maintained by a server-side session.</p>
            <p>This session will expire after 30 minutes of inactivity or when you log out.</p>
        </div>
        
        <div class="session-info">
            <p>Session ID: <%= session.getId() %></p>
            <p>Session Creation Time: <%= new java.util.Date(session.getCreationTime()) %></p>
            <p>Session will expire in: <%= session.getMaxInactiveInterval() / 60 %> minutes</p>
        </div>
        
        <div class="links">
            <a href="${pageContext.request.contextPath}/logout?type=session" class="btn btn-logout">Logout</a>
            <a href="${pageContext.request.contextPath}/" class="btn">Back to Home</a>
        </div>
    </div>
</body>
</html>
