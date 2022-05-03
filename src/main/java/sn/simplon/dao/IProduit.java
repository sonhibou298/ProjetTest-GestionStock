package sn.simplon.dao;

import java.util.List;

import sn.simplon.entities.Produit;

public interface IProduit {
	public int addProduct(Produit produit);
	public List<Produit> listProducts();
	public int deleteProduct(Produit produit);
	public int updateProduct(Produit produit);
}
