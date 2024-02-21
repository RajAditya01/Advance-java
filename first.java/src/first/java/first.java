package first.java;
import java.sql.*;

public class first {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // TODO Auto-generated method stub
        // step-1
        Class.forName("oracle.jdbc.driver.OracleDriver");

        // step-2
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "sys as sysdba", "1234");

        // step-3
        String sql = "create table Employee(id int, Name varchar(20), Salary int)";
        Statement stmt = con.createStatement();
        stmt.execute(sql);

        System.out.println("Table Created Successfully!!!");

        String sql1 = "insert into Employee values(1, 'Aditya', 5000)";
        stmt.addBatch(sql1);
        String sql2 = "insert into Employee values(2, 'Snehit', 4000)";
        stmt.addBatch(sql2);

        stmt.executeBatch();
        System.out.println("Insertion Successful");
    }
}

