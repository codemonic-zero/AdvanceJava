package code.jdbc.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateSt {

	public static void main(String[] args) {
		
		int tmpid;
		String tmpname,tmpemail,tmppass;
		Scanner sc = new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCDB", "root", "root");
			
			Statement st = con.createStatement();
			System.out.println("Enter which id to be updated:");
			tmpid = sc.nextInt();
			System.out.println("Enter your name:");
			tmpname = sc.next();
			System.out.println("Enter your email:");
			tmpemail = sc.next();
			System.out.println("Enter your password:");
			tmppass = sc.next();
			
			String sql = "UPDATE JDBC_TABLE SET NAME='"+tmpname+"',EMAIL='"+tmpemail+"',PASSWORD='"+tmppass+"' WHERE ID="+tmpid;
			
			int result = st.executeUpdate(sql);
			if (result == 1) {
				System.out.println("Data Updated Sucessfully");
			} else {
				System.out.println("Data Updation Failed");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
