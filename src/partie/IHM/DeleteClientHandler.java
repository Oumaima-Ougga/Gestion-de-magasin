package partie.IHM;

import partie.DAO.ClientDaoImpl;
import partie.DAO.IClientDao;

public class DeleteClientHandler {
	
	
IClientDao cdao = new ClientDaoImpl();
	
   DeleteClientWindow client =null;

	public DeleteClientHandler(DeleteClientWindow client) {
		this.client = client;
	}
	public void deleteClick() {
		long code= Integer.valueOf(client.clientDeleteTextField.getText());
		cdao.delete(code);
	}


}
