package sn.simplon.dao;

import java.util.List;

import sn.simplon.entities.Categorie;

public interface ICategorie {
	public int addCategorie(Categorie categorie);
	public List<Categorie> listCategorie();
	public int updateCategorie(Categorie categorie);
	public int deleteCategorie(int id);
}
