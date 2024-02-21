package first.java;
import java.util.*;
import java.sql.*;
public class Practical4 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Employee1 emp;
		ArrayList<Employee1> al=new ArrayList<Employee1>();
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","sys as sysdba","1234");
		String sql="select * from Employee";
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next()) {
			emp=new Employee1(rs.getInt(1),rs.getString(2),rs.getInt(3));
			al.add(emp);
		}
		Iterator itr=al.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
	}

}
