package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;

/**
 * Servlet implementation class Acceuil
 */
@WebServlet("/Acceuil")
public class Acceuil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE_TABLE = "/index.html";
	private static final String VUE_ACCEUIL = "/WEB-INF/Acceuil.jsp";
	private static final String VUE_ATH = "/WEB-INF/Auth.jsp";
      
    /**
     * @see HttpServlet#HttpServlet()
     */
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		if ( request.getSession().getAttribute("utilisateur") != null) {
			request.setAttribute("user", UserDAO.lister());
	        request.getServletContext().getRequestDispatcher(VUE_ACCEUIL).forward(request, response);
		}else {
	        request.getServletContext().getRequestDispatcher(VUE_ATH).forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
