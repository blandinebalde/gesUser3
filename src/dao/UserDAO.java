package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.User;

public class UserDAO {
	
	private static int  lastId = 0;
	private static final ArrayList<User> utilisateurs = new ArrayList<User>();
	
	private static Connection conn ;
	private	static Statement statement ;
	private static	ResultSet result;
	
	public static boolean ajouter(User user) {
		conn = ConnexionDAO.getInstance();
		boolean bool = false ;
	    String sql = "insert into user(nom,prenom,username,password) values (?,?,?,?)";
	 

		 if (conn !=null) {
			 try {
				   PreparedStatement stmt = conn.prepareStatement(sql);
				   stmt.setString(1, user.getNom());
				   stmt.setString(2, user.getPrenom());
				   stmt.setString(3, user.getUsername());
				   stmt.setString(4, user.getPassword());
				   if(stmt.executeUpdate() == 1 ) {
					   
					   bool =true;
					   System.out.println("done");
				   };
				
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		 return bool ;
	}
	
	public static boolean update(User u) {
		conn = ConnexionDAO.getInstance();
		boolean bool = false ;
	    String sql = "update user set nom = ? , prenom = ? , username = ? , password = ? where id = ?";

		 if (conn !=null) {
			 try {
				   PreparedStatement stmt = conn.prepareStatement(sql);
				   stmt.setString(1, u.getNom());
				   stmt.setString(2, u.getPrenom());
				   stmt.setString(3, u.getUsername());
				   stmt.setString(4, u.getPassword());
				   stmt.setInt(5, u.getId());
				   if(stmt.executeUpdate() == 1 ) {
					   
					   bool =true;
				   };
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return bool;
		
		
	}
	
	public static  User get(int id) {
		conn = ConnexionDAO.getInstance();
		boolean bool = false ;
	    String sql = "select * from user where id = ?";
	    User u = null;

		 if (conn !=null) {
			 try {
				   PreparedStatement stmt = conn.prepareStatement(sql);
				   stmt.setInt(1, id);
				  ResultSet rs =  stmt.executeQuery();
				  while (rs.next()) {
					  u = new User(rs.getInt("id"), rs.getString("nom"),rs.getString("prenom"),rs.getString("username"),rs.getString("password"));				
					  
				  }
				   
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return u ; 
	}
	
	
	
	public static boolean delete(int id) {
		conn = ConnexionDAO.getInstance();
		boolean bool = false ;
	    String sql = "delete from user where id=?";
	 

		 if (conn !=null) {
			 try {
				   PreparedStatement stmt = conn.prepareStatement(sql);
				   stmt.setInt(1, id);
				   if(stmt.executeUpdate() == 1 ) {
					   
					   bool =true;
				   };
				
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		 return bool;	
	}
	
	
	public static ArrayList<User> lister() {
		ArrayList<User> utilisateurs = new ArrayList<User>();
		 conn = ConnexionDAO.getInstance();
		 if (conn !=null) {
			 try {
				statement = conn.createStatement();
				result = statement.executeQuery("SELECT * FROM user");
				
				while (result.next()) {
					int id ;
					String nom , prenom , username, password;
					id = result.getInt("id");
					nom = result.getString("nom");
					prenom = result.getString("prenom");
					username = result.getString("username");
					password = result.getString("password");
					
					User u = new User(id, nom, prenom, username, password);
					utilisateurs.add(u);
				}
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		 

			return utilisateurs;
	}

	public static User get(String login) {
		conn = ConnexionDAO.getInstance();
		boolean bool = false ;
	    String sql = "select * from user where username = ?";
	    User u = null;

		 if (conn !=null) {
			 try {
				   PreparedStatement stmt = conn.prepareStatement(sql);
				   stmt.setString(1, login);
				  ResultSet rs =  stmt.executeQuery();
				  while (rs.next()) {
					  u = new User(rs.getInt("id"), rs.getString("nom"),rs.getString("prenom"),rs.getString("username"),rs.getString("password"));				
					  
				  }
				   
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return u ; 

	}
}
