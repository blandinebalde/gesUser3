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
 * Servlet implementation class FormAction
 */
@WebServlet(name="operation" , urlPatterns= {"/update","/delete"})
public class FormAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE_UPDATE = "/WEB-INF/update.jsp";
	static String id ;
	private User u;
	private User modif ;
       
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			StringBuffer url = request.getRequestURL();
			int o = url.indexOf("update");
			if (o != -1) {
				id = request.getParameter("id");
				modif= UserDAO.get(Integer.parseInt(id));
				
				if (modif != null) {
					request.setAttribute("user", modif);
					this.getServletContext().getRequestDispatcher(VUE_UPDATE).forward(request, response);
				}else {
					 response.sendRedirect(request.getContextPath()+"/Acceuil");

				}

				
				
			}else {
				
				id = request.getParameter("id");
				
				if (id != null && id.matches("[0-9]+")) {
					UserDAO.delete(Integer.parseInt(id));
					 response.sendRedirect(request.getContextPath()+"/Acceuil");
				}
			}
			
			
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuffer url = request.getRequestURL();
		int o = url.indexOf("update");

		if (o != -1) {
			AddUserForm form = new  AddUserForm(request);
			request.setAttribute("user", modif);

			if (form.update(modif)) {
				response.sendRedirect(request.getContextPath()+"/Acceuil");

			}else {
				request.setAttribute("form", form);
				getServletContext().getRequestDispatcher(VUE_UPDATE).forward(request, response);
			}
			
			}
			

			
			
		}
			
			
		
		
	}


