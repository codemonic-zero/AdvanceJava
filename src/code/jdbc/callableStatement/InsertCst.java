package code.jdbc.callableStatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

public abstract class InsertCst {

	public static void main(String[] args) {
		String tmpname,tmpemail,tmppass;
		Scanner sc = new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCDB","root","root");

			CallableStatement cst = con.prepareCall("{call addUser(?,?,?)}");
			
			System.out.println("Enter you name:");
			tmpname = sc.next();
			System.out.println("Enter Your email:");
			tmpemail = sc.next();
			System.out.println("Enter Your Passsword;");
			tmppass = sc.next();
			cst.setString(1, tmpname);
			cst.setString(2, tmpemail);
			cst.setString(3, tmppass);
			
			int res = cst.executeUpdate();
			if (res==1) {
				System.out.println("Data inserted successfully");
			} else {
				System.out.println("Data insertion failed");
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}