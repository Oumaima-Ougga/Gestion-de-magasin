package partie.IHM;

import partie.DAO.IProduitDao;
import partie.DAO.Produit;
import partie.DAO.ProduitDaoImpl;

public class ProduitModifierHandler {
IProduitDao pdao = new ProduitDaoImpl();
	
ModifierProduitWindow formProduit =null;

	public ProduitModifierHandler(ModifierProduitWindow produit) {
		this.formProduit = produit;
	}
	public void updateClick() {
		long code= Integer.valueOf(formProduit.produitCodeTextField.getText());
		String designation=formProduit.produitDesignationTextField.getText();
		String categorie=formProduit.produitCategorieTextField.getText();
		double prixVente= Double.valueOf(formProduit.produitPrixVenteTextField.getText());
		double prixAchat= Double.valueOf(formProduit.produitPrixAchatTextField.getText());
		Produit P = new Produit(code, designation, categorie, prixVente, prixAchat);
		pdao.delete(code);
		pdao.add(P);
	}
}
