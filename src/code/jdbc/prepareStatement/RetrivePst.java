package code.jdbc.prepareStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class RetrivePst {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCDB", "root", "root");
			
			String sql = "SELECT * FROM JDBC_TABLE";
			
			PreparedStatement pst = con.prepareStatement(sql);
			
			ResultSet rs = pst.executeQuery(sql);
			
			while(rs.next()) {
				System.out.println("-----------------------");
				System.out.println("Employe ID :"+rs.getInt("id")+" "+rs.getInt(1));
				System.out.println("Employe Name :"+rs.getString("name"));
				System.out.println("Employe Email :"+rs.getString("email"));
				System.out.println("Employe Password :"+rs.getString("password"));
				System.out.println("-----------------------");
				System.out.println("\n\n");
			}
			//step5 close connection after operation
			con.close();
			} catch (Exception e) {
			System.out.println("RetrivePst.main()"+e);
		}
	}
}
