<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
    <h2>Login Page</h2>
    <form action="LoginServlet" method="post">
        <label for="email">Email:</label>
        <input type="text" id="email" name="email" required><br>
        
        <label for="password">Password:</label>
        <input type="text" id="password" name="password" required><br>
        
        <input type="submit" value="Login">
        <label>New Registration</label>
        <a href="register.jsp">New Registration</a>
    </form>
</body>
</html>
