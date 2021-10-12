package partie.IHM;

import java.util.List;

import partie.DAO.IPaiementDao;
import partie.DAO.IPaiementDaoImpl;
import partie.DAO.Paiement;

public class ListPaiementHandler {
     
	ListPaiementWindow listWindow =null;
	IPaiementDao pdao = new IPaiementDaoImpl();	
	
	public ListPaiementHandler(ListPaiementWindow listWindow) {
		this.listWindow=listWindow;
	}
	public void deleteClick() {
		long code = Integer.valueOf(listWindow.paiementDeleteTextField.getText());
		pdao.delete(code);
		listWindow.paiementDeleteTextField.clear();
		listWindow.paiementsObservableList.clear();
		updatePaiementsListWindow();
	}
	
	
	public void updatePaiementsListWindow() {
		
		List<Paiement> list = pdao.getALL();
		listWindow.paiementsObservableList.addAll(list);
		
	}
}
