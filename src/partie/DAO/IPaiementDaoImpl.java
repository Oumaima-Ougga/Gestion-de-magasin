package partie.DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class IPaiementDaoImpl extends AbstractDao implements IPaiementDao {

	@Override
	public void add(Paiement obj) {
		PreparedStatement pst=null;	
		 String  sql="insert into paiement (code, codeVente , type , totalApayer,totalRestant,totalPaye,date,numCheque) values (?,?,?,?,?,?,?,?)";
		  try {
		    pst=connection.prepareStatement(sql);
		    pst.setLong(1, obj.getCode());
		    pst.setLong(2, obj.getVente().getCode()); 
		    pst.setString(3, obj.getType());
		    pst.setDouble(4, obj.getTotalApayer());
		    pst.setDouble(5, obj.getTotalRestant());
		    pst.setDouble(6, obj.getTotalPayé());
		    Date date=Date.valueOf(obj.getDate());
		    pst.setDate(7,date);
		    pst.setLong(8,obj.getNumCheque());
		    System.out.println("succes d'exec de la requete !");
			pst.executeUpdate();
		} catch (SQLException exp) {
			System.out.println(exp.getMessage());
		}	
	}

	@Override
	public void delete(long code) {
		PreparedStatement pst=null;	
		 String  sql="delete from paiement where code = ?";
		  try {
		    pst=connection.prepareStatement(sql);
		    pst.setLong(1, code);
			//System.out.println("succes d'exec de la requete !");
			pst.executeUpdate();

		} catch (SQLException exp) {
			System.out.println(exp.getMessage());
		}	
	}

	@Override
	public Paiement getOne(long code) {
		PreparedStatement pst=null;
		IVenteDao vdao = new VenteDaoImpl();
		  ResultSet rs;
		  String  sql="select * from paiement where code=?";
		  try {
		    pst=connection.prepareStatement(sql);
		    pst.setLong(1, code);
			System.out.println("succes d'exec de la requete !");
			rs=pst.executeQuery();
			if(rs.next()) {
				Date date =rs.getDate("date");
				long codeVente = rs.getLong("codeVente");
				Vente v = vdao.getOne(codeVente);
				return new Paiement(code, v, date.toLocalDate(), rs.getString("type"),  rs.getDouble("totalApayer"), rs.getDouble("totalRestant"), rs.getDouble("totalPaye"), rs.getLong("numCheque"));
			}
		} catch (SQLException exp) {
			System.out.println(exp.getMessage());
		}
		return null;
	}

	@Override
	public List<Paiement> getALL() {
		List<Paiement> list=new ArrayList <Paiement>();
		IVenteDao vdao = new VenteDaoImpl();  
		PreparedStatement pst=null;
		  ResultSet rs;
		  String  sql="select * from paiement";
		  try {
		    pst=connection.prepareStatement(sql);
			//System.out.println("succes d'exec de la requete !");
			rs=pst.executeQuery();
			while(rs.next()) {
				Vente v = vdao.getOne(rs.getLong("codeVente"));
				Date date =rs.getDate("date");
				list.add(new Paiement(rs.getLong("code"), v, date.toLocalDate(), rs.getString("type"),  rs.getDouble("totalApayer"), rs.getDouble("totalRestant"), rs.getDouble("totalPaye"), rs.getLong("numCheque")));
			}
		} catch (SQLException exp) {
			System.out.println(exp.getMessage());
		}
		return list;
	}

	@Override
	public List<Paiement> getALL(long code) {
		List<Paiement> list=new ArrayList <Paiement>();
		IVenteDao vdao = new VenteDaoImpl();
		PreparedStatement pst=null;
		  ResultSet rs;
		  String  sql="select * from paiement where code like ? ";
		  try {
			    pst=connection.prepareStatement(sql);
			    pst.setLong(1, code);
				//System.out.println("succes d'exec de la requete !");
				rs=pst.executeQuery();
				while(rs.next()) {
					Vente v = vdao.getOne(rs.getLong("codeVente"));
					Date date =rs.getDate("date");
					list.add(new Paiement(rs.getLong("code"), v, date.toLocalDate(), rs.getString("type"),  rs.getDouble("totalApayer"), rs.getDouble("totalRestant"), rs.getDouble("totalPaye"), rs.getLong("numCheque")));
				}
			} catch (SQLException exp) {
				System.out.println(exp.getMessage());
			}
		
		return list;
	}

}
