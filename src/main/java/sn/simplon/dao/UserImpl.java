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
		List<User> listeUsers = em.createQuery("select u from User u ").getResultList();
		return listeUsers;
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
