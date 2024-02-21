package first.java;
import java.sql.*;

public class practocle1 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // TODO Auto-generated method stub

        // step-1 loading of driver
        Class.forName("oracle.jdbc.driver.OracleDriver");

        // step-2 creating connection DriverManager.getConnection(url, username, pwd)
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "sys as sysdba", "1234");

        // step-3 create a table
        String createTableSQL = "create table Employee1(id int, Name varchar(20), Salary int)";

        // convert string into sql
        Statement createTableStmt = con.createStatement();
        createTableStmt.execute(createTableSQL);

        System.out.println("Table Created Successfully!!!");

        // insert data into the table
        String insertDataSQL = "insert into Employee1 (id, Name, Salary) values (1, 'Rinki', 5000)";

        // create a statement
        Statement insertDataStmt = con.createStatement();

        // execute the query
        int rowsAffected = insertDataStmt.executeUpdate(insertDataSQL);

        System.out.println(rowsAffected + " row(s) inserted successfully");

        // Close the resources
        createTableStmt.close();
        insertDataStmt.close();
        con.close();
    }
}
