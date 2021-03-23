package UIpractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/* STEPS for Database Testing
1.Create Connection
2.Create statement
3.Execute Statement
4. Close Connection*/

public class DatabaseTestingMySQL{


	public static void main(String[] args) throws InterruptedException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		

		String dbURL = "jdbc:mysql://localhost/learningsql";
		String username ="root";
	    String password = "teste1";
	        //Load MS SQL JDBC Driver
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        //Creating connection to the database
	        Connection con = DriverManager.getConnection(dbURL);
	        System.out.println("Entered connection");
	        //Creating statement object
	    	Statement st = con.createStatement();
	    	String selectquery = "select * from Employee where DeptNo = 20  ";
	        //Executing the SQL Query and store the results in ResultSet
	    	ResultSet rs = st.executeQuery(selectquery);
	    	//While loop to iterate through all data and print results
	    	while (rs.next()) {
	    		System.out.println(rs.getString(1)+"    "+rs.getString(2)+"    "+rs.getString(3));
	    	}
	        System.out.println("Closing DB Connection");
	    	con.close();
		
	
	}
}
