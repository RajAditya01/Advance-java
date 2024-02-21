<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Employee Form</title>
</head>
<body>
    <form action="AddEmployeeServlet" method="post">
        <label for="ID">First Name:</label>
        <input type="text" id="" name="firstName" required><br>

        <label for="lastName">Last Name:</label>
        <input type="text" id="lastName" name="lastName" required><br>

        <label for="position">Position:</label>
        <input type="text" id="position" name="position" required><br>

        <input type="submit" value="Submit">
    </form>
</body>
</html>