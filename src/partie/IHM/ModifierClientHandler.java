package partie.IHM;

import partie.DAO.Client;
import partie.DAO.ClientDaoImpl;
import partie.DAO.IClientDao;


public class ModifierClientHandler {
	IClientDao cdao = new ClientDaoImpl();
	ModifierClientWindow UpdateClient =null;

	public ModifierClientHandler(ModifierClientWindow Updateclient) {
		this.UpdateClient = Updateclient;
	}
	public void updateClick() {
		long code= Integer.valueOf(UpdateClient.clientCodeTextField.getText());
		String nom=UpdateClient.clientNomTextField.getText();
		String prenom=UpdateClient.clientPrenomTextField.getText();
		long telephone= Integer.valueOf(UpdateClient.clientTelephoneTextField.getText());
		String email=UpdateClient.clientEmailTextField.getText();
		String adresse=UpdateClient.clientAdresseTextField.getText();
		Client C = new Client(code, nom, prenom, telephone, email, adresse);
		cdao.delete(code);
		cdao.add(C);
	}

}
