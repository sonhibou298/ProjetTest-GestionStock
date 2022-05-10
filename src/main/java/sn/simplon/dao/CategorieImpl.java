package sn.simplon.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Persistence;

import sn.simplon.entities.Categorie;

public class CategorieImpl implements ICategorie {

	private EntityManager em;
	
	public CategorieImpl() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("GestionStockPU");
		em = emf.createEntityManager();
	}

	public int addCategorie(Categorie categorie) {
		try {
			em.getTransaction().begin();
			em.persist(categorie);
			em.getTransaction().commit();
			return 1;
			 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Categorie> listCategorie() {
		// TODO Auto-generated method stub
		try {
			return em.createQuery("SELECT c FROM Categorie c").getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	public int updateCategorie(Categorie categorie) {
		try {
			em.getTransaction().begin();
			em.merge(categorie);
			em.getTransaction().commit();
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
	}


	public int deleteCategorie(int id) {
		try {
			em.getTransaction().begin();
			em.remove(em.find(Categorie.class, id));
			em.getTransaction().commit();
			return 1;
			
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
	}

	public Categorie getId(int id) {
		try {
			return em.find(Categorie.class, id);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
	}

}
