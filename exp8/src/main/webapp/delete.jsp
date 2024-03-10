<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Delete Employee</title>
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
            background-color: #e74c3c;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #c0392b;
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

if ("delete".equals(action)) {
    // Deletion logic
    String strEmpId = request.getParameter("empId");
    int empIdToDelete = 0;

    if (strEmpId != null && !strEmpId.isEmpty()) {
        empIdToDelete = Integer.parseInt(strEmpId);
    }

    try {
        // Load the Oracle JDBC driver
        Class.forName("oracle.jdbc.driver.OracleDriver");

        // Provide your Oracle database URL, username, and password
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "sys as sysdba", "1234");

        String deleteQuery = "DELETE FROM employee WHERE ID = ?";

        PreparedStatement deleteStatement = con.prepareStatement(deleteQuery);
        deleteStatement.setInt(1, empIdToDelete);
        int deletionResult = deleteStatement.executeUpdate();

        if (deletionResult > 0) {
%>
            <div class="result">Deletion Successful!!</div>
<%
        } else {
%>
            <div class="error">Deletion Failed. Employee ID not found.</div>
<%
        }
    } catch (Exception e) {
%>
        <div class="error">Error: <%= e %></div>
<%
    }
}
%>

<form action="delete.jsp?action=delete" method="post">
    <!-- Deletion form fields -->
    <label for="empId">Employee ID to Delete:</label>
    <input type="text" name="empId" required><br>
    <input type="submit" value="Delete">
</form>

</body>
</html>
