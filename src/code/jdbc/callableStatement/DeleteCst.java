package code.jdbc.callableStatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

public abstract class DeleteCst {

	public static void main(String[] args) {
		int tmpid;
		
		Scanner sc = new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCDB","root","root");
			CallableStatement cst = con.prepareCall("{call deleteUser(?)}");
			System.out.println("Enter which id to be deleted:");
			tmpid = sc.nextInt();
			cst.setInt(1, tmpid);
			
			int res = cst.executeUpdate();
			if (res==1) {
				System.out.println("Data deleted successfully");
			} else {
				System.out.println("Data deletion failed");
			}
			
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}