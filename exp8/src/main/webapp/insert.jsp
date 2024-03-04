<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert Employee</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        form {
            width: 300px;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            box-sizing: border-box;
        }

        input[type="text"] {
            width: 100%;
            padding: 8px;
            margin: 5px 0;
            box-sizing: border-box;
        }

        input[type="submit"] {
            width: 100%;
            background-color: #3498db;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #2980b9;
        }

        .result,
        .error {
            margin-top: 20px;
            padding: 10px;
            border-radius: 5px;
            text-align: center;
        }

        .result {
            background-color: #dff0d8;
            color: #3c763d;
        }

        .error {
            background-color: #f2dede;
            color: #a94442;
        }
    </style>
</head>
<body>

<%
String action = request.getParameter("action");

if ("insert".equals(action)) {
    // Insertion logic
    String strEmpId = request.getParameter("empId");
    int empId1 = 0; // Default value for invalid input

    if (strEmpId != null && !strEmpId.isEmpty()) {
        empId1 = Integer.parseInt(strEmpId);
    }

    String ename1 = request.getParameter("ename");
    String strSalary = request.getParameter("salary");
    int salary1 = 0; // Default value for invalid input

    if (strSalary != null && !strSalary.isEmpty()) {
        salary1 = Integer.parseInt(strSalary);
    }

    try {
        // Load the Oracle JDBC driver
        Class.forName("oracle.jdbc.driver.OracleDriver");

        // Provide your Oracle database URL, username, and password
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "sys as sysdba", "1234");

        String insertQuery = "INSERT INTO employee (ID, NAME, SALARY) VALUES (?, ?, ?)";

        PreparedStatement insertStatement = con.prepareStatement(insertQuery);
        insertStatement.setInt(1, empId1);
        insertStatement.setString(2, ename1);
        insertStatement.setInt(3, salary1);
        int insertionResult = insertStatement.executeUpdate();

        if (insertionResult > 0) {
%>
            <div class="result">Insertion Successful!!</div>
<%
        } else {
%>
            <div class="error">Insertion Failed!!</div>
<%
        }
    } catch (Exception e) {
%>
        <div class="error">Error: <%= e %></div>
<%
    }
}
%>

<form action="insert.jsp?action=insert" method="post">
    <!-- Insertion form fields -->
    <label for="empId">Employee ID:</label>
    <input type="text" name="empId" required><br>
    <label for="ename">Employee Name:</label>
    <input type="text" name="ename" required><br>
    <label for="salary">Salary:</label>
    <input type="text" name="salary" required><br>
    <input type="submit" value="Insert">
</form>

</body>
</html>
