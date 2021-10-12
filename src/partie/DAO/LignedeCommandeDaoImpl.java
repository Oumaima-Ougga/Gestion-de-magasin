package partie.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LignedeCommandeDaoImpl extends AbstractDao implements ILigneCmdDao{
	
	@Override
	public void add(LigneDeCommande obj) {
		PreparedStatement pst=null;	
		 String  sql="insert into lignecommande (codeProduit, Qte, codeVente) values (?,?,?)";
		  try {
		    pst=connection.prepareStatement(sql);
		    pst.setLong(1, obj.getProduit().getCode());
		    pst.setInt(2, obj.getQte());
		    pst.setLong(3, obj.getVente().getCode());
		 //   System.out.println("succes d'exec de la requete !");
			pst.executeUpdate();
		} catch (SQLException exp) {
			System.out.println(exp.getMessage());
		}	
		
	}

	@Override
	public void delete(long codeVente) {
		PreparedStatement pst=null;	
		 String  sql="delete from lignecommande where codeVente = ?";
		  try {
		    pst=connection.prepareStatement(sql);
		    pst.setLong(1, codeVente);
			//System.out.println("succes d'exec de la requete !");
			pst.executeUpdate();

		} catch (SQLException exp) {
			System.out.println(exp.getMessage());
		}	
		
	}
	
	@Override
	public void delete(long codeProduit, long codeVente) {
		PreparedStatement pst=null;	
		 String  sql="delete from lignecommande where codeProduit = ? and codeVente = ?";
		  try {
		    pst=connection.prepareStatement(sql);
		    pst.setLong(1, codeProduit);
		    pst.setLong(2, codeVente);
			//System.out.println("succes d'exec de la requete !");
			pst.executeUpdate();

		} catch (SQLException exp) {
			System.out.println(exp.getMessage());
		}	
		
	}


	public void update(long code, LigneDeCommande obj) {
		PreparedStatement pst=null;	
		 String  sql="update lignecommande set codeProduit = ?, Qte = ?, codeVente = ?";
		  try {
		    pst=connection.prepareStatement(sql);
		    pst.setLong(1, obj.getProduit().getCode());
		    pst.setInt(2, obj.getQte());
		    pst.setDouble(3, obj.getVente().getCode());
		    //System.out.println("succes d'exec de la requete !");
			pst.executeUpdate();
		} catch (SQLException exp) {
			System.out.println(exp.getMessage());
		}	
		
	}

	@Override
	public LigneDeCommande getOne(long id) {
		PreparedStatement pst=null;
		  ResultSet rs;
		  String  sql="select * from lignecommande where codeProduit=?";
		  try {
		    pst=connection.prepareStatement(sql);
		    pst.setLong(1, id);
			//System.out.println("succes d'exec de la requete !");
			rs=pst.executeQuery();
			if(rs.next()) {
				return new LigneDeCommande(rs.getLong("codeProduit"),rs.getLong("codeVente"),rs.getInt("Qte"));
			}
		} catch (SQLException exp) {
			System.out.println(exp.getMessage());
		}
		return null;
	}



	@Override
	public List<LigneDeCommande> getALL() {
		List<LigneDeCommande> list=new ArrayList <LigneDeCommande>();
		IProduitDao pdao = new ProduitDaoImpl();
		IVenteDao vdao = new VenteDaoImpl();  
		PreparedStatement pst=null;
		  ResultSet rs;
		  String  sql="select * from lignecommande";
		  try {
		    pst=connection.prepareStatement(sql);
			//System.out.println("succes d'exec de la requete !");
			rs=pst.executeQuery();
			while(rs.next()) {
				Produit p =pdao.getOne(rs.getLong("codeProduit"));
				Vente v = vdao.getOne(rs.getLong("codeVente"));
				list.add(new LigneDeCommande(p,v,rs.getInt("Qte")));
			}
		} catch (SQLException exp) {
			System.out.println(exp.getMessage());
		}
		return list;
	}

	@Override
	public List<LigneDeCommande> getALL(long code) {
		List<LigneDeCommande> list=new ArrayList <LigneDeCommande>();
		IProduitDao pdao = new ProduitDaoImpl();
		IVenteDao vdao = new VenteDaoImpl();
		PreparedStatement pst=null;
		  ResultSet rs;
		  String  sql="select * from lignecommande where codeVente like ? ";
		  try {
			    pst=connection.prepareStatement(sql);
			    pst.setLong(1, code);
				//System.out.println("succes d'exec de la requete !");
				rs=pst.executeQuery();
				while(rs.next()) {
					Produit p =pdao.getOne(rs.getLong("codeProduit"));
					Vente v = vdao.getOne(rs.getLong("codeVente"));
					list.add(new LigneDeCommande(p,v,rs.getInt("Qte")));
				}
			} catch (SQLException exp) {
				System.out.println(exp.getMessage());
			}
		
		return list;
	}

	

	
}
