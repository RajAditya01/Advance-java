package Aditya;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    response.setContentType("text/html");
	    
	    PrintWriter out = response.getWriter();
	    out.println("<html><body>");

	    Connection conn = null;
	    Statement stmt = null;
	    ResultSet rs = null;

	    try {
	        // Load the Oracle JDBC driver
	        Class.forName("oracle.jdbc.driver.OracleDriver");

	        // Connect to the database
	        conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "sys as sysdba", "1234");

	        // Execute SQL query to retrieve employee details
	        stmt = conn.createStatement();
	        rs = stmt.executeQuery("SELECT * FROM Employee");

	        // Create an HTML table
	        out.println("<table border='1'>");
	        out.println("<tr><th>Employee ID</th><th>Name</th><th>Salary</th></tr>");
	        

	        // Print employee details in the table
	        while (rs.next()) {
	            out.println("<tr>");
	            out.println("<td>" + rs.getInt("id") + "</td>");
	            out.println("<td>" + rs.getString("name") + "</td>");
	            out.println("<td>" + rs.getString("salary") + "</td>");
	            out.println("</tr>");
	        }

	        out.println("</table>");

	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();
	    } finally {
	        // Close the database resources
	        try {
	            if (rs != null)
	                rs.close();
	            if (stmt != null)
	                stmt.close();
	            if (conn != null)
	                conn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    out.println("</body></html>");
	}

}