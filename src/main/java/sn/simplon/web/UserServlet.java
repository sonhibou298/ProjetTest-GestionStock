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
		User user = new User();
		user.setNom("Sene");
		user.setPrenom("Sonhibou");
		user.setLogin("sonhibou@gmail.com");
		user.setPassword("passer");
		int result = userdao.add(user);
		response.getWriter().print(result);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
