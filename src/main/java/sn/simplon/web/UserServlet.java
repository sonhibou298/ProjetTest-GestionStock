package sn.simplon.web;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sn.simplon.dao.IUser;
import sn.simplon.dao.UserImpl;
import sn.simplon.entities.User;

import java.io.IOException;
import java.util.List;

@WebServlet("/User")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private IUser userdao;
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    	
   @Override
	public void init(ServletConfig config) throws ServletException {
		userdao = new UserImpl();  
	}
    	 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page");
		if(page.equals("delete")) {
			int id = Integer.parseInt(request.getParameter("id"));
			userdao.deleteUser(id);
			
			
		}
		request.setAttribute("users", userdao.listeUsers());
		request.getRequestDispatcher("WEB-INF/views/users/list.jsp").forward(request, response);

			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("nom").toString();
		String prenom = request.getParameter("prenom").toString();
		String login = request.getParameter("login").toString();
		String password = request.getParameter("password").toString();
		
		User user = new User();
		user.setNom(nom);
		user.setPrenom(prenom);
		user.setLogin(login);
		user.setPassword(password);
		
		userdao.add(user);
		
		response.sendRedirect("User?page=list");
		
	}

}
