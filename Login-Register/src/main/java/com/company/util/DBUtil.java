package com.company.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    // Oracle database connection details
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";  
    private static final String USERNAME = "sys as sysdba";  
    private static final String PASSWORD = "1234";  
    Connection con=null;
    Connection getConnection1() {
        try {
            // Load the Oracle JDBC driver
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con=DriverManager.getConnection(URL,USERNAME,PASSWORD);
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch(SQLException s) {
        	s.printStackTrace();
        }
		return con;
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
