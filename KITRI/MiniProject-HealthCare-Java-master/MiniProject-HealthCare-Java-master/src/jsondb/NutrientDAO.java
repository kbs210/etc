package jsondb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class NutrientDAO {
	static final String JDBC_DRIVER = "org.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mariadb://localhost:3306/test";
	
	//  Database credentials
	static final String USER = "root";
	static final String PASS = "1234";
	
	Connection conn = null;
	Statement stmt = null;
	
	public void connectDB() {
		System.out.println("Nutrient Database ����...");
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			if(conn != null) System.out.println("conn ����");
			else System.out.println("conn ����");
			stmt = conn.createStatement();
	
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // ConncectDB
	
	public void closeDB() {
		System.out.println("Nutrient Database Close...");
		try {
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	// Nutrient ��ü �޾Ƽ� DB�ȿ� �ֱ�
//	public void insertNutrient(Nutrient n) {
//		
//		
//		try {
//			Class.forName("org.mariadb.jdbc.Driver");
//			System.out.println("Connecting to database...");
//			conn = DriverManager.getConnection(DB_URL, USER, PASS);
//			
//			if(conn != null) System.out.println("conn ����");
//			else System.out.println("conn ����");
//			
//			System.out.println(sql); // ����� ������ ���
//			
//			stmt = conn.createStatement();
//			stmt.executeUpdate(sql);
//			
//			stmt.close();
//			conn.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			 try{
//		         if(stmt!=null)
//		            stmt.close();
//		      }catch(SQLException se2){
//		      }// nothing we can do
//		      try{
//		         if(conn!=null)
//		            conn.close();
//		      }catch(SQLException se){
//		         se.printStackTrace();
//		      }//end finally try
//		 } // end try
//	
//		
//	}
}