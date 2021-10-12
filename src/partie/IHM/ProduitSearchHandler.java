package partie.IHM;

import partie.DAO.IProduitDao;
import partie.DAO.Produit;
import partie.DAO.ProduitDaoImpl;

public class ProduitSearchHandler {
	IProduitDao pdao=new ProduitDaoImpl();
	SearchProduitWindow searchProduit=null;

	
	public ProduitSearchHandler(SearchProduitWindow searchProduit) {
		this.searchProduit = searchProduit;
	}


	public void searchClick() {
		int id=Integer.valueOf(searchProduit.produitSearchTextField.getText());
		Produit p=pdao.getOne(id);
		searchProduit.produitsObservableList.addAll(p);
		
	}
}