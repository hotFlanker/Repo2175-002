package Practice;
import java.sql.*;
public class DatabasePractice {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		}
		catch (ClassNotFoundException e) {
			System.out.println("problem in loading the driver");
			e.printStackTrace();
		}
		
		try {
			String dbName = "Employees.accdb";
			String dbURL = "jdbc:ucanaccess://" + dbName;
			conn = DriverManager.getConnection(dbURL);
			stat = conn.createStatement();
			String n = "Emily";
			double sa = 66000;
			String query;
			//String query = "INSERT INTO Table1 (EName,Salary) " + "values ('"+n+"',"+sa+")";
			//stat.executeUpdate(query);
			rs = stat.executeQuery("SELECT * FROM TABLE1");
			
			query = "UPDATE TABLE1 SET Salary = 12000 " + "Where EName = 'ABC'";
			stat.executeUpdate(query);
			
			query = "DELETE FROM TABLE1 Where EName = 'Emily'";
			stat.executeUpdate(query);
			
			int id;
			String name;
			double sal;
			while(rs.next()) {
				id = rs.getInt(1);
				name = rs.getString(2);
				sal = rs.getDouble(3);
				System.out.println("id " + id + " name " + name + " salary " + sal) ;
				System.out.println();
			}
			
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		finally {
			try {
				if(conn!=null) {
					rs.close();
					stat.close();
					conn.close();
				}
			}
			catch(SQLException ex) {
				ex.printStackTrace();
			}
		}
		
	}
}
