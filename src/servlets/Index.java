package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import foms.Authentification;

/**
 * Servlet implementation class Index
 */
@WebServlet({"/login" , "/logout"})
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE_CONNEXION= "/index.jsp";
	private static final String VUE_ACCEUIL = "/WEB-INF/Acceuil.jsp";

       
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		switch (request.getServletPath()) {
		case "/login":
			getServletContext().getRequestDispatcher(VUE_CONNEXION).forward(request, response);
			break;

		default:
			request.getSession().invalidate();
			response.sendRedirect(request.getContextPath()+"/login");
			break;
		} 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Authentification form = new Authentification(request);
		
		if (form.authentifier()) {
			response.sendRedirect(request.getContextPath()+"/Acceuil");
		}else {
			if (!(form.getLogin() == null)) {
				response.sendRedirect(request.getContextPath()+"/login?login="+form.getLogin());
			}else {
				response.sendRedirect(request.getContextPath()+"/login");

			}
			
		}
	}

}
