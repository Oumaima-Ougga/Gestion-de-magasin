package partie.DAO;

import java.util.ArrayList;
import java.util.List;

public class Categorie {
	
	private long code;
	private String intitule;
	List<Produit> TabProduitCategorie = new ArrayList<>();
	
	public List<Produit> getTabProduitCategorie() {
		return TabProduitCategorie;
	}
	public void setTabProduitCategorie(List<Produit> tabProduitCategorie) {
		TabProduitCategorie = tabProduitCategorie;
	}
	public long getCode() {
		return code;
	}
	public void setCode(long code) {
		this.code = code;
	}
	public String getIntitule() {
		return intitule;
	}
	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}
	public Categorie(long code, String intitule, List<Produit> tabProduitCategorie) {
		this.code = code;
		this.intitule = intitule;
		TabProduitCategorie = tabProduitCategorie;
	}
	public Categorie(String intitule) {
		this.intitule=intitule;
	}
	@Override
	public String toString() {
		return  intitule ;
	}
	
	

}
