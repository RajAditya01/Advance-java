<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<%@ page import="Aditya.DemoServlet.*" %>
<%@ page import="javax.script.*" %>

<%
    // Retrieve form data
    String employeeId = request.getParameter("employeeId");
    String employeeName = request.getParameter("employeeName");
    String Salary = request.getParameter("Salary");

    // Database connection parameters
    String url = "jdbc:oracle:thin:@localhost:1521:XE";
    String user = "sys as sysdba";
    String password = "1234";

    try {
        // Load the JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Establish the connection
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "sys as sysdba", "1234");

        // Create a statement
        Statement statement = connection.createStatement();

        // Insert data into the Employee table
        String query = "INSERT INTO Employee (employeeId, employeeName, Salary) VALUES ('" + employeeId + "', '" + employeeName + "', '" + Salary
        		+ "')";
        int rowsAffected = statement.executeUpdate(query);

        // Close the connections
        statement.close();
        connection.close();

        // Check if the data is successfully inserted
        if (rowsAffected > 0) {
            out.println("<h2>Employee details added successfully!</h2>");
        } else {
            out.println("<h2>Error adding employee details.</h2>");
        }

    } catch (Exception e) {
        e.printStackTrace();
        out.println("<h2>Error: " + e.getMessage() + "</h2>");
    }
%>