package first.java;

import java.sql.*;

public class exp3 {

    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;

        try {
            // step-2
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "sys as sysdba", "1234");

            // step-3
            String createTableSql = "create table Employee(id int primary key, Name varchar(20), Salary int)";
            pstmt = con.prepareStatement(createTableSql);
            pstmt.execute();
            System.out.println("Table Created Successfully!!!");

            // Insertion using PreparedStatement for batch
            String insertSql = "insert into Employee values (?, ?, ?)";
            pstmt = con.prepareStatement(insertSql);

            // Employee 1
            pstmt.setInt(1, 1);
            pstmt.setString(2, "Aditya");
            pstmt.setInt(3, 5000);
            pstmt.addBatch();

            // Employee 2
            pstmt.setInt(1, 2);
            pstmt.setString(2, "Snehit");
            pstmt.setInt(3, 4000);
            pstmt.addBatch();

            pstmt.executeBatch();
            pstmt.close();  // Close the PreparedStatement explicitly

            System.out.println("Insertion Successful");

            // Retrieving and printing all employee details
            String retrieveAllSql = "select * from Employee";
            pstmt = con.prepareStatement(retrieveAllSql);
            resultSet = pstmt.executeQuery();
            System.out.println("After Insertion Employee details:");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("Name");
                int salary = resultSet.getInt("Salary");

                System.out.println("ID: " + id + " Name: " + name + " Salary: " + salary);
                System.out.println("--------------------");
            }

            // Updating salary for employee with id 1
            String updateSql = "update Employee set Salary = 6000 where id = 1";
            pstmt = con.prepareStatement(updateSql);
            pstmt.executeUpdate();
            System.out.println("Update Successful");

            // Retrieving and printing all employee details after update
            resultSet = pstmt.executeQuery(retrieveAllSql);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("Name");
                int salary = resultSet.getInt("Salary");

                System.out.println("Retrieving and printing all employee details after update");
                System.out.println("ID: " + id + " Name: " + name + " Salary: " + salary);
                System.out.println("--------------------");
            }

            // Deleting employee with id 2
//            String deleteSql = "delete from Employee where id = 2";
//            pstmt = con.prepareStatement(deleteSql);
//            pstmt.executeUpdate();
//            System.out.println("Deletion Successful");
//
//            // Retrieving and printing all employee details after deletion
//            resultSet = pstmt.executeQuery(retrieveAllSql);
//
//            while (resultSet.next()) {
//                int id = resultSet.getInt("id");
//                String name = resultSet.getString("Name");
//                int salary = resultSet.getInt("Salary");
//
//                System.out.println("Deleting employee with id 2");
//                System.out.println("ID: " + id + " Name: " + name + " Salary: " + salary);
//                System.out.println("--------------------");
//            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Closing resources in the finally block to ensure they are closed even if an exception occurs
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
