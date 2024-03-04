<%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Result</title>
</head>
<body>

<%
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
        out.println(e);
    }
%>

</body>
</html>
