package code.jdbc.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class RetriveSt {

	public static void main(String[] args) {

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCDB", "root", "root");

			Statement st = con.createStatement();

			String sql = "SELECT * FROM JDBC_TABLE";
			
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				System.out.println("-----------------------");
				System.out.println("Employe ID :" + rs.getInt("id") + " " + rs.getInt(1));
				System.out.println("Employe Name :" + rs.getString("name"));
				System.out.println("Employe Email :" + rs.getString("email"));
				System.out.println("Employe Password :" + rs.getString("password"));
//				System.out.println("Employe Created Time :" + rs.getString("created"));
				System.out.println("-----------------------");
				System.out.println("\n\n");
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
