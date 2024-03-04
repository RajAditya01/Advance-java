package Aditya;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public RegisterServlet() {
        super();
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print("Register Servlet");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "sys as sysdba", "1234");

           // String username = request.getParameter("username");
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            // Check if the email already exists in the database
            PreparedStatement checkEmail = con.prepareStatement("select * from Auth where EMAIL=?");
            checkEmail.setString(1, email);
            ResultSet emailResult = checkEmail.executeQuery();

            if (emailResult.next()) {
                // Redirect to registration error page or handle duplicate email
                response.sendRedirect("registrationError.jsp");
            } else {
                // Email doesn't exist, proceed with registration
                PreparedStatement ps = con.prepareStatement("insert into Auth (EMAIL, PASSWORD) values (?, ?)");
               // ps.setString(1, username);
                ps.setString(1, email);
                ps.setString(2, password);

                int rowsAffected = ps.executeUpdate();

                if (rowsAffected > 0) {
                    // Registration successful, redirect to a success page
                    response.sendRedirect("registrationSuccess.jsp");
                } else {
                    // Registration failed, redirect to an error page
                    response.sendRedirect("registrationError.jsp");
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
