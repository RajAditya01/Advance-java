<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee Details Form</title>
</head>
<body>

    <form action="insert.jsp" method="post">
        Employee ID: <input type="text" name="employeeId"><br>
        Employee Name: <input type="text" name="employeeName"><br>
        Salary: <input type="text" name="salary"><br>
        Designation: <input type="text" name="designation"><br>
        <input type="submit" value="Submit">
    </form>

</body>
</html>
