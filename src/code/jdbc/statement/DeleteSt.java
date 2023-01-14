package code.jdbc.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteSt {

	public static void main(String[] args) {
		
		int id;
		Scanner sc = new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCDB","root","root");
			
			Statement st = con.createStatement();
			
			System.out.println("Enter which id to be deleted:");
			id = sc.nextInt();
			
			String sql = "DELETE FROM JDBC_TABLE WHERE ID="+id;
			
			int res = st.executeUpdate(sql);
			
			if (res==1) {
				System.out.println("ID "+id+" deleted sucessfully");
			} else {
				System.out.println("data deletion failed.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
