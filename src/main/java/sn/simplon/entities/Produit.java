package sn.simplon.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Produit implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; 
	@Column(length = 50, unique = true)
	private String nomProduit;
	public Produit(Categorie idCat) {
		super();
		this.idCat = idCat;
	}

	@Column
	private float prixUnitaire;
	@Column
	private int qteStock;
	@Temporal(TemporalType.DATE)
	private Date dateExpiration;
	@ManyToOne
	private Categorie idCat = new Categorie();
	
	
	public Produit() {
		super();
	}


	public Produit(int id, String nomProduit, float prixUnitaire, int qteStock, Date dateExpiration, Categorie idCat) {
		super();
		this.id = id;
		this.nomProduit = nomProduit;
		this.prixUnitaire = prixUnitaire;
		this.qteStock = qteStock;
		this.dateExpiration = dateExpiration;
		this.idCat = idCat;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNomProduit() {
		return nomProduit;
	}


	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}


	public float getPrixUnitaire() {
		return prixUnitaire;
	}


	public void setPrixUnitaire(float prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}


	public int getQteStock() {
		return qteStock;
	}


	public void setQteStock(int qteStock) {
		this.qteStock = qteStock;
	}


	public Date getDateExpiration() {
		return dateExpiration;
	}


	public void setDateExpiration(Date dateExpiration) {
		this.dateExpiration = dateExpiration;
	}


	public Categorie getIdCat() {
		return idCat;
	}


	public void setIdCat(Categorie idCat) {
		this.idCat = idCat;
	}
	
	
	
	
}
