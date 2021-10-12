package partie.IHM;

import java.util.List;

import partie.DAO.ILigneCmdDao;
import partie.DAO.IVenteDao;
import partie.DAO.LigneDeCommande;
import partie.DAO.LignedeCommandeDaoImpl;
import partie.DAO.Vente;
import partie.DAO.VenteDaoImpl;

public class SearchVenteHandler {
	
	
IVenteDao vdao = new VenteDaoImpl();
ILigneCmdDao ldao =new LignedeCommandeDaoImpl();
	
   SearchVenteWindow vente =null;

	public SearchVenteHandler(SearchVenteWindow vente) {
		this.vente = vente;
	}
	
	public void searchClick() {
		vente.venteObservableList.clear();
		int code =Integer.valueOf(vente.venteSearchTextField.getText());
	    List<LigneDeCommande> list = ldao.getALL(code);
		vente.venteObservableList.addAll(list);
		updateTotal();
	}
	public void updateTotal() {
		double total=0;
		for (LigneDeCommande l:vente.venteObservableList)
			total+=l.getTotal();
		vente.totalLabelValue.setText(total+" ");
	}



}
