
package partie.DAO;

import java.time.LocalDate;
import java.util.*;
import java.util.List;

public class Program {

	public static void main(String[] args) {
		IVenteDao vdao = new VenteDaoImpl();
		IPaiementDao pdao = new IPaiementDaoImpl();
	//    Vente v = vdao.getOne(2);	
//		Paiement p = new Paiement(0, v, LocalDate.now() , "Comptant", 3000, 3000, 1);
		//pdao.add(p);
	//	Paiement p2 =pdao.getOne(0);
	//	System.out.println(p2);
	//	pdao.delete(2);
		List<Paiement> list =pdao.getALL();
		for (Paiement p1:list) {
			System.out.println(p1);
		}
		
	/*	ILigneCmdDao ldao = new LignedeCommandeDaoImpl();
		ldao.delete(3, 3);
		
		
	/*	IVenteDao  vdao =new VenteDaoImpl();
		System.out.println("-------------");
		List<Vente> list=vdao.getALL();
		for(Vente v:list) {
			System.out.println(v);
		}
		IClientDao cdao= new ClientDaoImpl();
		Client client = cdao.getOne(3);
		
	//	Vente v=new Vente(3, LocalDate.now(), client);
//		vdao.add(v);
		
		System.out.println("-------------");
		List<Vente> list1=vdao.getALL();
		for(Vente v1:list1) {
			System.out.println(v1);
		}
		
	/*	IClientDao cdao = new ClientDaoImpl();
		System.out.println("-------------");
		List<Client> list=cdao.getALL();
		for (Client c:list) {
			System.out.println(c);}*/
	/*	ILigneCmdDao ldao = new LignedeCommandeDaoImpl();
		System.out.println("-------------");
		List<LigneDeCommande> list1=ldao.getALL();
		for (LigneDeCommande l:list1) {
			System.out.println(l);}
		ldao.delete(2);
		
		List<LigneDeCommande> list2=ldao.getALL();
		for (LigneDeCommande l:list2) {
			System.out.println(l);}*/
		
	/*	List<LigneDeCommande> list3=ldao.getALL();
		for (LigneDeCommande l:list3) {
			System.out.println(l);}
		IProduitDao pdao = new ProduitDaoImpl();
		System.out.println("-------------");
		List<Produit> list2=pdao.getALL();
		for (Produit p:list2) {
			System.out.println(p);
		}
		
		/*System.out.println("-------------");
		Produit p;
		p=pdao.getOne(2);
		if(p!=null)
		  System.out.println(p);
		else
			System.out.println("produit non trouvé");
		
		
		System.out.println("-------------");
		List<Produit> list1=pdao.getALL("G");
		for (Produit p1:list1) {
			System.out.println(p1);
		}	
		
		System.out.println("-------------");
		pdao.delete(1);
		
		
		System.out.println("-------------");
		Produit pr;
		pr=pdao.getOne(2);
		if(pr!=null)
		   System.out.println(pr);
		else
			System.out.println("inexistant");
	
		Produit P3=new Produit(2, "TV2", "Television",2354.8,2500.35);
		System.out.println("-------------");
		pdao.add(P3);
	    
		System.out.println("-------------");
		List<Produit> list3=pdao.getALL();
		for (Produit p3:list3) {
			System.out.println(p3);	
		}
		
		System.out.println("-------------");
		List<Produit> list4=pdao.getALL("G");
		for (Produit p4:list4) {
			System.out.println(p4);
		}
		Produit P4=new Produit("TV3", 2500.35, "Television");
		System.out.println("-------------");
		pdao.add(P4);
		
		System.out.println("-------------");
		List<Produit> list5=pdao.getALL();
		for (Produit p5:list5) {
			System.out.println(p5);	
		}*/
		}
	    
	
	}


