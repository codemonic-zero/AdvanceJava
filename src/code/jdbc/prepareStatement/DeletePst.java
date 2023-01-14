package code.jdbc.prepareStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DeletePst {

	public static void main(String[] args) {

		int tmpid;
		try (Scanner sc = new Scanner(System.in)) {
			try {
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCDB","root","root");
				
				String sql = "DELETE FROM JDBC_TABLE WHERE ID=?";
				
				PreparedStatement pst = con.prepareStatement(sql);
				
				System.out.println("Enter Which id to be deleted?");
				tmpid = sc.nextInt();
				
				pst.setInt(1, tmpid);
				
				int res = pst.executeUpdate();
				if (res==1) {
					System.out.println("Data Deleted Successfully");
				} else {
					System.out.println("Data deletion Failed..");
				}

			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
}
