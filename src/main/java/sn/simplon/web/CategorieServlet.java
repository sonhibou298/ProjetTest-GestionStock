package sn.simplon.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sn.simplon.dao.CategorieImpl;
import sn.simplon.dao.ICategorie;
import sn.simplon.entities.Categorie;

import java.io.IOException;
import java.util.List;

@WebServlet("/Categorie")
public class CategorieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private ICategorie categoriedao;
    public CategorieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public void init() throws ServletException {
    	categoriedao = new CategorieImpl();
    
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page");
		if(page.equals("delete"))
		{
			int id = Integer.parseInt(request.getParameter("id"));
			categoriedao.deleteCategorie(id);
		}
		request.setAttribute("list_Categorie", categoriedao.listCategorie());
		request.getRequestDispatcher("WEB-INF/views/categories/list.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String libelle = request.getParameter("libelle").toString();
		
		Categorie categorie = new Categorie();
		categorie.setLibelle(libelle);
		categoriedao.addCategorie(categorie);
		response.sendRedirect("Categorie");
	}

}
