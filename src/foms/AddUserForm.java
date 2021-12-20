package foms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import dao.UserDAO;
import model.User;

public class AddUserForm {
	
    private static final String CHAMP_NOM = "nom";	
    private static final String CHAMP_PRENOM = "prenom";	
    private static final String CHAMP_LOGIN = "username";	
    private static final String CHAMP_PASSWORD = "pwd";	
    private static final String CHAMP_PASSWORD_BIS = "pwdBis";
    
	private HttpServletRequest request;	
	private Map<String, String> erreurs;
	private User utilisateur ;
	private boolean status = false ; 
	private String statusMessage ; 
    
    
    public AddUserForm(HttpServletRequest resquest) {
    	
    	this.status = false;
		this.request = resquest;
		this.erreurs = new HashMap<String , String>();
    }
    
	public boolean ajouter() {
		String nom = getParameter(CHAMP_NOM);
		String prenom = getParameter(CHAMP_PRENOM);
		String login = getParameter(CHAMP_LOGIN);
		String pwd = getParameter(CHAMP_PASSWORD);
		String pwdBis = getParameter(CHAMP_PASSWORD_BIS);
		
		utilisateur = new User(nom, prenom, login, pwd);
		
		validerChamps(CHAMP_NOM, CHAMP_PRENOM, CHAMP_LOGIN, CHAMP_PASSWORD, CHAMP_PASSWORD_BIS);
		validerPassword();
		statusMessage = "echec de l'ajout d'utilisatur";
		
		if (erreurs.isEmpty()) {
			
			status= UserDAO.ajouter(utilisateur);
			if (status) {
				statusMessage = "Ajout effectué avec succés";
			}
			
		}
		
		return status ;
	}
	
	public boolean update(User u) {
		
		
		
		validerChamps(CHAMP_NOM, CHAMP_PRENOM, CHAMP_LOGIN, CHAMP_PASSWORD);
		statusMessage = "echec de la modification de l'utilisatur";
		u.setNom(getUpdate(CHAMP_NOM));
		u.setPrenom(getUpdate(CHAMP_PRENOM));
		u.setUsername(getUpdate(CHAMP_LOGIN));
		u.setPassword(getUpdate(CHAMP_PASSWORD));
		
		
		if (erreurs.isEmpty()) {
			
			status= UserDAO.update(u);
			if (status) {
				statusMessage = "Modification effectué avec succés";
			}
			
		}
		
		return status ;

	}
	
	private void validerPassword() {
		
		String pwd = getParameter(CHAMP_PASSWORD);
		String pwdBis = getParameter(CHAMP_PASSWORD_BIS);
		
		if (pwd !=null && !pwd.equals(pwdBis)) {
			erreurs.put(CHAMP_PASSWORD, "Les deux mot de passe ne correspondent pas");
			erreurs.put(CHAMP_PASSWORD_BIS, "Les deux mot de passe ne correspondent pas");

		}
	}
	private void validerChamps(String ...champs) {
		
		for (String champ : champs) {
			
			if (getParameter(champ) == null) {
				
				erreurs.put(champ, "Vous devez remplir ce champ");
				
			}
			
		}
		
	}

	private String getParameter(String parametre) {

		String valeur = request.getParameter(parametre);
		
		if (valeur == null || valeur.trim().isEmpty()) {
			return null;
		}
		return valeur ;
	}
	
	private String getUpdate(String parametre) {

		String valeur = request.getParameter(parametre);
		
		return valeur ;
	}

	public Map<String, String> getErreurs() {
		return erreurs;
	}

	public User getUtilisateur() {
		return utilisateur;
	}

	public boolean isStatus() {
		return status;
	}

	public String getStatusMessage() {
		return statusMessage;
	}
	
	

}
