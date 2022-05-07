package sn.simplon.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import sn.simplon.entities.Produit;

public class ProduitImpl implements IProduit{

	private EntityManager em;
	
	public ProduitImpl() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("GestionStockPU");
		em = emf.createEntityManager();
	}

	public int addProduct(Produit produit) {
		try {
			em.getTransaction().begin();
			em.persist(produit);
			em.getTransaction().commit();
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Produit> listProducts() {
		try {
			return em.createQuery("Select p FROM Produit p").getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}


	public int updateProduct(Produit produit) {
		try {
			em.getTransaction().begin();
			em.merge(produit);
			em.getTransaction().commit();
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
	}

	public int deleteProduct(int id) {
		try {
			em.getTransaction().begin();
			em.remove(em.find(Produit.class, id));
			em.getTransaction().commit();
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
	}

}
