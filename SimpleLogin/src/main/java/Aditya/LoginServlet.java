package Aditya;

import jakarta.servlet.RequestDispatcher;
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

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print("Welcome");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "sys as sysdba", "1234");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            PreparedStatement ps = con.prepareStatement("select * from Auth where EMAIL=?");
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            
            if (rs.next()) {
                // Forward the request to login.jsp
                response.sendRedirect("login.jsp");            
            } else {
                // Redirect to an error page or handle unsuccessful login
                response.sendRedirect("error.jsp");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
