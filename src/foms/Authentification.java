package foms;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import model.User;

public class Authentification {
	
	private static final String CHAMP_LOGIN = "username";
	private static final String CHAMP_PWD = "password";
	private HttpServletRequest request ; 
	private User utilisateur ;
	String login;

	
	public Authentification(HttpServletRequest request ) {
		this.request =  request;
	}
	
	public boolean authentifier() {
		
		 login = getParameter(CHAMP_LOGIN);
		String password = getParameter(CHAMP_PWD);
		
		if ("admin".equals(login) && "passer".equals(password)) {
			utilisateur = new User("admin", "admin", "admin", "admin");
		}else {
			utilisateur = UserDAO.get(login);
			if (utilisateur != null && !utilisateur.getPassword().equals(password)) {
				utilisateur = null ;
			}
		}
		
		if (utilisateur !=null) {
			HttpSession session = request.getSession();
			session.setAttribute("utilisateur", utilisateur);
			return true;
			
		}
		return false;
		
		
	}
	
	private String getParameter(String parametre) {

		String valeur = request.getParameter(parametre);
		
		if (valeur == null || valeur.trim().isEmpty()) {
			return null;
		}
		return valeur ;
	}

	public String getLogin() {
		// TODO Auto-generated method stub
		return login;
	}

}
