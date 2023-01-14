package code.jdbc.callableStatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
import java.util.Scanner;

public class RetrivrByNameCst {

	public static void main(String[] args) {
		int tmpid;
		String tmpname,tmpemail;
		Scanner sc = new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCDB", "root", "root");
			CallableStatement cst = con.prepareCall("{call getNameAndEmail(?,?,?)}");
			System.out.println("Enter which id's data to be show:");
			tmpid = sc.nextInt();
			cst.setInt(1, tmpid);
			cst.registerOutParameter(2, Types.VARCHAR);
			cst.registerOutParameter(3, Types.VARCHAR);
			cst.execute();
			
			System.out.println("Name :" + cst.getString(2));
			System.out.println("Email :" + cst.getString(3));
			
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
