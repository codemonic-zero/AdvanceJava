package code.jdbc.prepareStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdatePst {

	public static void main(String[] args) {
		
		int id;
		String tmpname,tmpemail,tmppass;
		Scanner sc = new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCDB","root","root");
			
			String sql = "UPDATE JDBC_TABLE SET NAME=?,EMAIL=?,PASSWORD=? WHERE ID=?";
			
			PreparedStatement pst = con.prepareStatement(sql);
			
			System.out.println("Enter which id to be updated:");
			id = sc.nextInt();
			
			System.out.println("Enter Your Name:");
			tmpname = sc.next();
			
			System.out.println("Enter Your Email:");
			tmpemail = sc.next();
			
			System.out.println("Enter Your Password:");
			tmppass = sc.next();
			
			pst.setString(1, tmpname);
			pst.setString(2, tmpemail);
			pst.setString(3, tmppass);
			pst.setInt(4, id);
			
			int res = pst.executeUpdate();
			if (res==1) {
				System.out.println("Data updated sucessfully");
			} else {
				System.out.println("Data updation failed");
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
