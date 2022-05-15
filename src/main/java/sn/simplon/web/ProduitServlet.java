package sn.simplon.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sn.simplon.dao.CategorieImpl;
import sn.simplon.dao.ICategorie;
import sn.simplon.dao.IProduit;
import sn.simplon.dao.ProduitImpl;
import sn.simplon.entities.Categorie;
import sn.simplon.entities.Produit;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.eclipse.persistence.jpa.jpql.parser.SimpleCaseExpressionBNF;

@WebServlet("/Produit")
public class ProduitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
        
    /**
     * @see HttpServlet#HttpServlet()
     */
	private IProduit produitdao;
	private ICategorie categoriedao;
    public ProduitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	produitdao = new ProduitImpl();
    	categoriedao = new CategorieImpl();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Produit> produits = produitdao.listProducts();
		request.setAttribute("list_produits", produits);
		List<Categorie> categories = categoriedao.listCategorie();
		request.setAttribute("list_categories", categories);
		request.getRequestDispatcher("WEB-INF/views/produits/list.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nomProduit = request.getParameter("nomProduit").toString();
		float prix = Float.parseFloat(request.getParameter("prix"));
		int quantite = Integer.parseInt(request.getParameter("qte"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		try {
			Date date = sdf.parse(request.getParameter("date"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Produit produit = new Produit();
		produit.setNomProduit(nomProduit);
		produit.setPrixUnitaire(prix);
		produit.setQteStock(quantite);
		produit.setIdCat(null);
		produitdao.addProduct(produit);
		response.sendRedirect("Produit?page=list");  
		
	}

}
