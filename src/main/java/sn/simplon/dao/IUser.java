package sn.simplon.dao;

import java.util.List;

import sn.simplon.entities.User;

public interface IUser {
	public int add(User user);
	public List<User> listeUsers();
	public int deleteUser(int id);
	public int updateUser(User user);
	public User get(int id);
	
}
