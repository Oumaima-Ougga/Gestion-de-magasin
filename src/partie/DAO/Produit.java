package partie.DAO;

import java.util.ArrayList;
import java.util.List;

public class Produit {
	private long code;
	private String designation;
	private double prixVente;
	private double prixAchat;
	
	private Categorie categorie;
	
	private List<LigneDeCommande> list= new ArrayList<>();
	
    public Produit(){
    	
    }
public Produit(long code){
    	this.code=code;
    }
	public Produit(long code, String designation, String categorie,double prixVente, double prixAchat) {
		this.setCode(code);
		this.setDesignation(designation);
		this.categorie = new Categorie(categorie);
		this.setPrixVente(prixVente);
		this.setPrixAchat(prixAchat);
	}

	public Produit(String designation, double prixVente,String categorie) {
		this.setDesignation(designation);
		this.setPrixVente(prixVente);
		this.setPrixAchat(prixVente);
		this.categorie = new Categorie(categorie);
	}

	public long getCode() {
		return code;
	}

	public void setCode(long code) {
		this.code = code;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public double getPrixVente() {
		return prixVente;
	}

	public void setPrixAchat(double prix) {
		this.prixAchat = prix;
	}
	
	public double getPrixAchat() {
		return prixAchat;
	}

	public void setPrixVente(double prix) {
		this.prixVente = prix;
	}

	public Categorie getCategorie() {
		return categorie;
	}
	
	public void setCategorie(Categorie Categorie) {
		this.categorie = Categorie;
	}
    
	@Override
	public String toString() {
		return "\t  Code= " + code + " \n Designation = "+designation+ "   Prix de vente = " + prixVente ;
	}
	
}
