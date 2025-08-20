<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Demo</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
            background-color: #f4f4f4;
        }
        .container {
            max-width: 800px;
            margin: 0 auto;
            background: white;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        h1 {
            color: #333;
            text-align: center;
        }
        .login-options {
            display: flex;
            justify-content: space-around;
            margin-top: 30px;
        }
        .login-card {
            width: 45%;
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 5px;
            text-align: center;
        }
        .btn {
            display: inline-block;
            padding: 10px 20px;
            background: #4CAF50;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            margin-top: 15px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Login Demo Application</h1>
        
        <div class="login-options">
            <div class="login-card">
                <h2>Cookie-based Login</h2>
                <p>Login using cookies for persistent authentication</p>
                <a href="cookie-login" class="btn">Try Cookie Login</a>
            </div>
            
            <div class="login-card">
                <h2>Session-based Login</h2>
                <p>Login using HTTP sessions for server-side authentication</p>
                <a href="session-login" class="btn">Try Session Login</a>
            </div>
        </div>
    </div>
</body>
</html>
