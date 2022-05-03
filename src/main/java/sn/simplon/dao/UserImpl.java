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

	public List<User> listeUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	public int deleteUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

}
