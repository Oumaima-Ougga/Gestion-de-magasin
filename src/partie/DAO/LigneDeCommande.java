package partie.DAO;

public class LigneDeCommande {

	private Produit produit;
	
	private Vente vente;
	private int qte;
	private double sousTotal;
	
	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public Vente getVente() {
		return vente;
	}

	public void setVente(Vente vente) {
		this.vente = vente;
	}
    
	
	public int getQte() {
		return qte;
	}
	public double getTotal() {
		return sousTotal;
	}

	public void setQte(int qte) {
		this.qte = qte;
	}

	public LigneDeCommande() {
		super();
	}

	public LigneDeCommande(Produit produit, Vente vente, int qte) {
		super();
		this.produit = produit;
		this.vente = vente;
		this.qte = qte;
		this.sousTotal = produit.getPrixVente()*this.getQte();
	}
	public LigneDeCommande(long codeProduit, long codeVente, int qte) {
	
		this.produit = new Produit(codeProduit);
		this.vente = new Vente(codeVente);
		this.qte = qte;
		this.sousTotal = produit.getPrixVente()*this.getQte();
	}
	@Override
	public String toString() {
		return "LigneDeCommande [produit=" + produit + ", vente=" + vente + ", qte=" + qte + "]";
	}
	
	
	

}
