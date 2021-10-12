package partie.IHM;

import partie.DAO.IClientDao;
import partie.DAO.Client;
import partie.DAO.ClientDaoImpl;

public class SearchClientHandler {
	
	IClientDao cdao=new ClientDaoImpl();
	SearchClientWindow searchClient=null;

	
	public SearchClientHandler(SearchClientWindow searchClient) {
		this.searchClient = searchClient;
	}


	public void searchClick() {
		int id=Integer.valueOf(searchClient.clientSearchTextField.getText());
		Client c=cdao.getOne(id);
		searchClient.clientsObservableList.addAll(c);
		
	}

}
