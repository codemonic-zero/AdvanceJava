package code.jdbc.prepareStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertPst {

	public static void main(String[] args) {

		String tmpname, tmpemail, tmppass;
		Scanner sc = new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCDB", "root", "root");

			String sql = "INSERT INTO JDBC_TABLE(NAME,EMAIL,PASSWORD)VALUES(?,?,?)";

			PreparedStatement pst = con.prepareStatement(sql);

			System.out.println("Enter your name:");
			tmpname = sc.next();

			System.out.println("Enter your email:");
			tmpemail = sc.next();

			System.out.println("Enter your password:");
			tmppass = sc.next();

			pst.setString(1, tmpname);
			pst.setString(2, tmpemail);
			pst.setString(3, tmppass);

			int res = pst.executeUpdate();
			if (res == 1) {
				System.out.println("Data inserted sucessfully");
			} else {
				System.out.println("data Insertion failed");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
