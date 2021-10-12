package partie.IHM;

import java.util.List;

import partie.DAO.*;

public class ListHandlerVente {
	
ListeVenteWindow listWindow =null;
IVenteDao vdao = new VenteDaoImpl();

ILigneCmdDao ldao =new LignedeCommandeDaoImpl();
	
	public ListHandlerVente(ListeVenteWindow listWindow) {
		this.listWindow=listWindow;
	}
	public void deleteClick() {
		long code= Integer.valueOf(listWindow.venteDeleteTextField.getText());
		ldao.delete(code);
		vdao.delete(code);
		listWindow.venteDeleteTextField.clear();
	    listWindow.ventesObservableList.clear();
		updateVentesListWindow();
	}
	
	public void mouseClick() {
		listWindow.lcObservableList.clear();
		Vente v = listWindow.ventesTableView.getSelectionModel().getSelectedItem(); 
		if (v!=null) {
		long code=v.getCode();
		 List<LigneDeCommande> list = ldao.getALL(code);
		// System.out.println(list);
		listWindow.lcObservableList.addAll(list);
		updateTotal();}
	}
	
	public void updateVentesListWindow() {
		IVenteDao vdao = new VenteDaoImpl();
		List<Vente> list=vdao.getALL();
		//System.out.println(list);
		listWindow.ventesObservableList.addAll(list);
	}
	public void updateTotal() {

		double total=0;
		for(LigneDeCommande l:listWindow.lcObservableList)
			total+=l.getTotal();
		listWindow.totalLabelValue.setText(total+" ");
		
	}

}
