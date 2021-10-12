package partie.IHM;

import java.util.ArrayList;
import java.util.List;

import partie.DAO.IProduitDao;
import partie.DAO.Produit;
import partie.DAO.ProduitDaoImpl;


public class ProduitsListHandler {
	
	FormListProduitWindow listWindow =null;
	
	public ProduitsListHandler(FormListProduitWindow listWindow) {
		this.listWindow=listWindow;
	}
	
	
	public void updateProduitsListWindow() {
		IProduitDao pdao = new ProduitDaoImpl();
		List<Produit> list=pdao.getALL();
		listWindow.produitsObservableList.addAll(list);
	}
	public void updateTotal() {

		double total=0;
		for(Produit p:listWindow.produitsObservableList)
			total+=p.getPrixVente();
		listWindow.totalLabelValue.setText(total+" ");
	}
}
