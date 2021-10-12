package partie.IHM;

import partie.DAO.IProduitDao;
import partie.DAO.Produit;
import partie.DAO.ProduitDaoImpl;

public class ProduitDeleteHandler {
	
IProduitDao pdao = new ProduitDaoImpl();
	
	DeleteProduitWindow formProduit =null;

	public ProduitDeleteHandler(DeleteProduitWindow produit) {
		this.formProduit = produit;
	}
	public void deleteClick() {
		long code= Integer.valueOf(formProduit.produitDeleteTextField.getText());
		pdao.delete(code);
	}

}
