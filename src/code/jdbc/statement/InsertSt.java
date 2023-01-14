package code.jdbc.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class InsertSt {

	public static void main(String[] args) {
		
		String tmpname,tmpemail,tmppass;
		Scanner sc = new Scanner(System.in);
		//All the JDBC code should be in try and catch block
		try {
			
			//step 1:load JDBC Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//step 2:connection established
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCDB", "root", "root");
			
			//step 3:Create Statement Object
			Statement st = con.createStatement();
			System.out.println("Enter your name:");
			tmpname = sc.next();
			System.out.println("Enter your email:");
			tmpemail = sc.next();
			System.out.println("Enter your password:");
			tmppass = sc.next();
			String sql = "INSERT INTO JDBC_TABLE(NAME,EMAIL,PASSWORD)VALUES('"+tmpname+"','"+tmpemail+"','"+tmppass+"')";
			
			//step 4:Execute Query
			int result = st.executeUpdate(sql);
			if (result == 1) {
				System.out.println("Data Inserted Successfully");
			} else {
				System.out.println("Data Insertion Failed...");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
