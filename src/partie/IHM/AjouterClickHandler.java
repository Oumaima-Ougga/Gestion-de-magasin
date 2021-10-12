package partie.IHM;

import java.time.LocalDate;
import java.util.List;
import partie.DAO.Client;
import partie.DAO.ClientDaoImpl;
import partie.DAO.IClientDao;
import partie.DAO.ILigneCmdDao;
import partie.DAO.IProduitDao;
import partie.DAO.IVenteDao;
import partie.DAO.LigneDeCommande;
import partie.DAO.LignedeCommandeDaoImpl;
import partie.DAO.Produit;
import partie.DAO.ProduitDaoImpl;
import partie.DAO.Vente;
import partie.DAO.VenteDaoImpl;

public class AjouterClickHandler {
	
	NouvelleVenteWindow nvl=null;
	ILigneCmdDao ldao =new LignedeCommandeDaoImpl();
	
	public AjouterClickHandler(NouvelleVenteWindow nvl) {
		this.nvl=nvl;
	}
	
	public void ajouterLcClick(){
		
		ILigneCmdDao ldao = new LignedeCommandeDaoImpl();
		long codeProduit = Integer.valueOf(nvl.codeProduitTextField.getText());
		long codeVente = Integer.valueOf(nvl.venteCodeTextField.getText());
		int qte =Integer.valueOf(nvl.qteProduitTextField.getText());
		LigneDeCommande l = new LigneDeCommande(codeProduit, codeVente, qte);  
	
		for (LigneDeCommande l1: nvl.lcObservableList) {
			if(l1.getProduit().getCode()==l.getProduit().getCode()) {
				l1.setQte(qte+l1.getQte());
				nvl.lcObservableList.set(0, l1);
				updateVentesListWindow();
			}
		}
		ldao.add(l);
	
        nvl.codeProduitTextField.clear();
        nvl.qteProduitTextField.clear();
        updateVentesListWindow();
	}
	public void supprimerLcClick() {
		
		ILigneCmdDao ldao = new LignedeCommandeDaoImpl();
		long codeProduit = Integer.valueOf(nvl.codeProduitTextField.getText());
		long codeVente = Integer.valueOf(nvl.venteCodeTextField.getText());	 
		ldao.delete(codeProduit,codeVente);
        nvl.codeProduitTextField.clear();
        updateVentesListWindow();
		
	}
	public void ajouterVente() {
		IVenteDao vdao = new VenteDaoImpl();
		long codeVente = Integer.valueOf(nvl.venteCodeTextField.getText());
		LocalDate date = nvl.venteDateDatePicker.getValue();
		long codeClient = Integer.valueOf(nvl.venteCodeClientTextField.getText());
	    Vente v = new Vente(codeVente, date, codeClient);	
	    vdao.add(v);
	    nvl.venteCodeClientTextField.clear();
	    
	  
	}
	public void modifierVente() {
		IVenteDao vdao = new VenteDaoImpl();
		long codeVente = Integer.valueOf(nvl.venteCodeTextField.getText());
		LocalDate date = nvl.venteDateDatePicker.getValue();
		long codeClient = Integer.valueOf(nvl.venteCodeClientTextField.getText());
	    Vente v = new Vente(codeVente, date, codeClient);	
	    vdao.delete(codeVente);
	    vdao.add(v);
	    nvl.window.close();
	}
	public void updateClientsListWindow() {
		IClientDao cdao = new ClientDaoImpl();
		List<Client> list=cdao.getALL();
		nvl.clientsObservableList.addAll(list);
	}
	public void updateProduitsListWindow() {
		IProduitDao pdao = new ProduitDaoImpl();
		List<Produit> list=pdao.getALL();
		nvl.produitsObservableList.addAll(list);
	}
	public void mouseClickClient() {
		 nvl.venteCodeClientTextField.clear();
		Client c = nvl.clientsTableView.getSelectionModel().getSelectedItem(); 
		if (c!=null) {
		long code=c.getCode();
		 nvl.venteCodeClientTextField.setText(String.valueOf(code));
		 }
		}
	
		public void mouseClickProduit() {
			 nvl.codeProduitTextField.clear();
			Produit p = nvl.produitsTableView.getSelectionModel().getSelectedItem(); 
			if (p!=null) {
			long code=p.getCode();
			 nvl.codeProduitTextField.setText(String.valueOf(code));
			}
	}

		public void updateVentesListWindow() {
			nvl.lcObservableList.clear();
			int code =Integer.valueOf(nvl.venteCodeTextField.getText());
		    List<LigneDeCommande> list = ldao.getALL(code);
			nvl.lcObservableList.addAll(list);
		}
}
