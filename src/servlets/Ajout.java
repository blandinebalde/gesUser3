package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import foms.AddUserForm;
import model.User;

/**
 * Servlet implementation class Ajout
 */
@WebServlet("/Ajout")
public class Ajout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final String VUE_AJOUT = "/WEB-INF/Ajout.jsp";


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        this.getServletContext().getRequestDispatcher(VUE_AJOUT).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AddUserForm form = new  AddUserForm(request);
		
		if (form.ajouter()) {
			response.sendRedirect(request.getContextPath()+"/Acceuil");

		}else {
			request.setAttribute("form", form);
			getServletContext().getRequestDispatcher(VUE_AJOUT).forward(request, response);
		}
		
		 
		 
     	
	}

}
