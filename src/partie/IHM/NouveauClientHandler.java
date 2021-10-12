package partie.IHM;

import partie.DAO.Client;
import partie.DAO.ClientDaoImpl;
import partie.DAO.IClientDao;

public class NouveauClientHandler {
	
IClientDao pdao = new ClientDaoImpl();
	
	NouveauClientWindow NvClient =null;

	public NouveauClientHandler(NouveauClientWindow client) {
		this.NvClient = client;
	}
	public void addClick() {
		String nom=NvClient.clientNomTextField.getText();
		String prenom=NvClient.clientPrenomTextField.getText();
		long telephone= Integer.valueOf(NvClient.clientTelephoneTextField.getText());
		String email=NvClient.clientEmailTextField.getText();
		String adresse=NvClient.clientAdresseTextField.getText();
		Client C = new Client(0, nom, prenom, telephone, email, adresse);
		pdao.add(C);
	}

}
