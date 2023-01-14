package code.jdbc.callableStatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public abstract class RetrivalCst {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCDB","root","root");

			CallableStatement cst = con.prepareCall("{call getAllUsers}");
			ResultSet rs = cst.executeQuery();
			while (rs.next()) {
				System.out.println("-----------------------");
				System.out.println("Employe ID :" + rs.getInt("id") + " " + rs.getInt(1));
				System.out.println("Employe Name :" + rs.getString("name"));
				System.out.println("Employe Email :" + rs.getString("email"));
				System.out.println("Employe Password :" + rs.getString("password"));
				System.out.println("-----------------------");
				System.out.println("\n\n");
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}