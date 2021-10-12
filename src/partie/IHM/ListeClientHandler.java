package partie.IHM;

import java.util.List;

import partie.DAO.Client;
import partie.DAO.ClientDaoImpl;
import partie.DAO.IClientDao;


public class ListeClientHandler {
	
ListeClientWindow listWindow =null;
	
	public ListeClientHandler(ListeClientWindow listWindow) {
		this.listWindow=listWindow;
	}
	
	
	public void updateClientsListWindow() {
		IClientDao cdao = new ClientDaoImpl();
		List<Client> list=cdao.getALL();
		listWindow.clientsObservableList.addAll(list);
	}
	

}
