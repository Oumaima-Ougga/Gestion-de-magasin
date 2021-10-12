package partie.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class ProduitDaoImpl extends AbstractDao implements IProduitDao{

	@Override
	public void add(Produit obj) {
		PreparedStatement pst=null;
		String sql="insert into produit (code, designation, categorie , prixAchat, prixVente  ) values (?,?,?,?,?)";
		 try {
			pst= connection.prepareStatement(sql);
			pst.setLong(1, obj.getCode());
			pst.setString(2, obj.getDesignation());
			pst.setDouble(4, obj.getPrixAchat());
			pst.setDouble(5, obj.getPrixVente());
			pst.setString(3, obj.getCategorie().getIntitule());
		//	System.out.println("Succes d'execution de requete!!");
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void delete(long code) {
		PreparedStatement pst=null;
		String sql=" delete from produit where code like ?";
		 try {
			pst= connection.prepareStatement(sql);
			pst.setLong(1, code);
			//System.out.println("Succes d'execution de requete!!");
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

	@Override
	public Produit getOne(long code) {
		Produit produit=new Produit();
		PreparedStatement pst=null;
		
		ResultSet rs;
		 String sql=" select * from produit where code=? ";
		 try { 
			pst= connection.prepareStatement(sql);
			pst.setLong(1,code);
		//	System.out.println("Succes d'execution de requete!!");
			rs=pst.executeQuery();
			if(rs.next()) {
				//System.out.println(rs.getLong("code")+" "+rs.getString("designation"));
				return new Produit(rs.getLong("code"), rs.getString("designation") , rs.getString("categorie"),rs.getDouble("prixVente") , rs.getDouble("prixAchat") );
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		 
		return null;
	}

	@Override
	public List<Produit> getALL() {
		List<Produit> list=new ArrayList<Produit>();
		PreparedStatement pst=null;
		ResultSet rs;
		 String sql=" select * from produit ";
		 try {
			pst= connection.prepareStatement(sql);
			//System.out.println("Succes d'execution de requete!!");
			rs=pst.executeQuery();
			while(rs.next()) {
				list.add(new Produit(rs.getLong("code"), rs.getString("designation") ,  rs.getString("categorie"),rs.getDouble("prixVente") ,rs.getDouble("prixAchat")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		 
		return list;
	}

	@Override
	public List<Produit> getALL(String des) {
		List<Produit> list=new ArrayList<Produit>();
		PreparedStatement pst=null;
		ResultSet rs;
		String sql=" select * from produit where designation like ?";
		 try {
			pst= connection.prepareStatement(sql);
			pst.setString(1, des+"%");
		//	System.out.println("Succes d'execution de requete!!");
			rs=pst.executeQuery();
			while(rs.next()) {
				//System.out.println(rs.getLong("code")+" "+rs.getString("designation"));
				list.add(new Produit(rs.getLong("code"), rs.getString("designation") , rs.getString("categorie"),rs.getDouble("prixAchat") , rs.getDouble("prixVente")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		 
		return list;
	}
	
	

}
