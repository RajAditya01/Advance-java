package MyPackage;

import java.sql.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Servlet() {
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
        String strEmpId = request.getParameter("ID");
        int empId1 = Integer.parseInt(strEmpId);
        String ename1 = request.getParameter("NAME");
        String strSalary = request.getParameter("SALARY");
        int salary1 = Integer.parseInt(strSalary);

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "sys as sysdba", "1234");
                 PreparedStatement ps = con.prepareStatement("insert into employee (ID, NAME, SALARY) values (?, ?, ?)")) {

                ps.setInt(1, empId1);
                ps.setString(2, ename1);
                ps.setInt(3, salary1);
                ps.executeUpdate();

                response.setContentType("text/html");
                PrintWriter pw = response.getWriter();
                pw.println("Insertion Successful!!!");
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: " + e);
        }
    }
}
