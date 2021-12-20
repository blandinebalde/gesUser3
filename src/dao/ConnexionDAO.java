package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionDAO {
	
	static final String DB_URL ="jdbc:mysql://localhost/gesuser";
	static final String DB_USER ="root";
	static final String DB_PASSWORD="passer";

	
	
	public static  Connection getInstance() {
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(DB_URL, DB_USER,DB_PASSWORD);
			 
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erreur connexion");
		}
		return null;
		
	}
}
