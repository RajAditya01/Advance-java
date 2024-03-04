<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert Page</title>
</head>
<body>

    <%-- Retrieve data from the form --%>
    <% String employeeId = request.getParameter("employeeId"); %>
    <% String employeeName = request.getParameter("employeeName"); %>
    <% String salary = request.getParameter("salary"); %>
    <% String designation = request.getParameter("designation"); %>

    <%-- JDBC database connection details --%>
    <% String url = "jdbc:oracle:thin:@localhost:1521:XE"; %>
    <% String username = "sys as sysdba"; %>
    <% String password = "1234"; %>

    <h2>Employee Details</h2>
    <p>Employee ID: <%= employeeId %></p>
    <p>Employee Name: <%= employeeName %></p>
    <p>Salary: <%= salary %></p>
    <p>Designation: <%= designation %></p>

    <%-- JDBC code to insert data into the database --%>
    <%
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);

            String sql = "INSERT INTO employee (employee_id, employee_name, salary, designation) VALUES (?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, employeeId);
            preparedStatement.setString(2, employeeName);
            preparedStatement.setString(3, salary);
            preparedStatement.setString(4, designation);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                out.println("<p>Data inserted successfully into the database!</p>");
            } else {
                out.println("<p>Failed to insert data into the database.</p>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    %>

</body>
</html>
