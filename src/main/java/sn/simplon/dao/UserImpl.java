package sn.simplon.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import sn.simplon.entities.User;

public class UserImpl implements IUser{

	private EntityManager em;
	
	public UserImpl() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("GestionStockPU");
		em = emf.createEntityManager();
	}

	public int add(User user) {
		try {
			em.getTransaction().begin();
			em.persist(user);
			em.getTransaction().commit();
			return 1;
		} catch (Exception e) {
			return 0;
		}
		
	}

	@SuppressWarnings("unchecked")
	public List<User> listeUsers() {
		try {
			return em.createQuery("SELECT u FROM User u").getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}


	public int updateUser(User user) {
		try {
			em.getTransaction().begin();
			em.merge(user);
			em.getTransaction().commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		
	}

	public int deleteUser(int id) {
		try {
			em.getTransaction().begin();
			em.remove(em.find(User.class, id));
			em.getTransaction().commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public User get(int id) {
		
		return em.find(User.class, id);
	}

}
