package partie.IHM;

import partie.DAO.IProduitDao;
import partie.DAO.Produit;
import partie.DAO.ProduitDaoImpl;

public class ProduitAddHandler {
	IProduitDao pdao = new ProduitDaoImpl();
	
	FormProduitWindow formProduit =null;

	public ProduitAddHandler(FormProduitWindow produit) {
		this.formProduit = produit;
	}
	public void addClick() {
		String designation=formProduit.produitDesignationTextField.getText();
		String categorie=formProduit.produitCategorieTextField.getText();
		double prixVente= Double.valueOf(formProduit.produitPrixVenteTextField.getText());
		double prixAchat= Double.valueOf(formProduit.produitPrixAchatTextField.getText());
		Produit P = new Produit(0, designation, categorie, prixVente, prixAchat);
		pdao.add(P);
	}

}
