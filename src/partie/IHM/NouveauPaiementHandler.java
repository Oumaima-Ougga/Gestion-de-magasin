package partie.IHM;

import java.time.LocalDate;
import java.util.List;

import partie.DAO.ILigneCmdDao;
import partie.DAO.IPaiementDao;
import partie.DAO.IPaiementDaoImpl;
import partie.DAO.IVenteDao;
import partie.DAO.LigneDeCommande;
import partie.DAO.LignedeCommandeDaoImpl;
import partie.DAO.Paiement;
import partie.DAO.Vente;
import partie.DAO.VenteDaoImpl;

public class NouveauPaiementHandler {
	
	NouveauPaiementWindow nv=null;
	ILigneCmdDao ldao =new LignedeCommandeDaoImpl();
	IVenteDao vdao = new VenteDaoImpl();
	IPaiementDao pdao = new IPaiementDaoImpl();
	
	public NouveauPaiementHandler(NouveauPaiementWindow nv){
		this.nv = nv;
	}
	
	public void updateVentesListWindow() {
		IVenteDao vdao = new VenteDaoImpl();
		List<Vente> list=vdao.getALL();
		nv.ventesObservableList.addAll(list);
	}
	
	public void mouseClick() {
		nv.lcObservableList.clear();
		Vente v = nv.ventesTableView.getSelectionModel().getSelectedItem(); 
		if (v!=null) {
		long code=v.getCode();
		 List<LigneDeCommande> list = ldao.getALL(code);
		nv.lcObservableList.addAll(list);
		nv.paiementVenteCodeTextField.clear();
		nv.paiementVenteCodeTextField.setText(String.valueOf(code));
		updateTotal();}
	}
	public void mouseClickTotal() {
		double total =Double.valueOf( nv.totalLabelValue.getText());
		nv.TotalApayéTextField.clear();
		nv.TotalApayéTextField.setText(String.valueOf(total));
	}
	public void updateTotal() {

		double total=0;
		for(LigneDeCommande l:nv.lcObservableList)
			total+=l.getTotal();
		nv.totalLabelValue.setText(total+" ");
		
	}
    
	public void ajouterPaiement() {
		long code = Integer.valueOf(nv.paiementCodeTextField.getText());
		long codeVente = Integer.valueOf(nv.paiementVenteCodeTextField.getText());
		Vente v = vdao.getOne(codeVente);
		int numCheque=Integer.valueOf(nv.numChequeTextField.getText());
		LocalDate date = nv.paiementDateDatePicker.getValue();
		String type = nv.TypeTextField.getText();
		double totalApayer = Double.valueOf(nv.TotalApayéTextField.getText());
		double totalPaye = Double.valueOf(nv.TotalPayéTextField.getText());
		
		Paiement p = new Paiement(code, v, date, type, totalApayer,  totalPaye, numCheque);
	    pdao.add(p);
	    nv.paiementCodeTextField.clear();
		nv.paiementVenteCodeTextField.clear();
		nv.numChequeTextField.clear();
		nv.TotalApayéTextField.clear();
		nv.TotalPayéTextField.clear();
		nv.TypeTextField.clear();
	}
	public void modifierPaiement() {
		long code = Integer.valueOf(nv.paiementCodeTextField.getText());
		long codeVente = Integer.valueOf(nv.paiementVenteCodeTextField.getText());
		Vente v = vdao.getOne(codeVente);
		int numCheque=Integer.valueOf(nv.numChequeTextField.getText());
		LocalDate date = nv.paiementDateDatePicker.getValue();
		String type = nv.TypeTextField.getText();
		double totalApayer = Double.valueOf(nv.TotalApayéTextField.getText());
		double totalPaye = Double.valueOf(nv.TotalPayéTextField.getText());
		Paiement p = new Paiement(code, v, date, type, totalApayer,  totalPaye, numCheque);
	    pdao.delete(code);
		pdao.add(p);
		nv.paiementCodeTextField.clear();
		nv.paiementVenteCodeTextField.clear();
		nv.numChequeTextField.clear();
		nv.TotalApayéTextField.clear();
		nv.TotalPayéTextField.clear();
		nv.TypeTextField.clear();
		
	}
}
