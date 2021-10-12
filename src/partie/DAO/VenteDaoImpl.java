package partie.DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VenteDaoImpl extends AbstractDao implements IVenteDao{

	@Override
	public void add(Vente obj) {
		PreparedStatement pst=null;
		String sql="insert into vente (code, date, codeClient   ) values (?,?,?)";
		 try {
			pst= connection.prepareStatement(sql);
			pst.setLong(1, obj.getCode());
			Date date=Date.valueOf(obj.getDate());
			pst.setDate(2, date);
			pst.setDouble(3, obj.getClient().getCode());
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
		String sql=" delete from vente where code like ?";
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
	public Vente getOne(long code) {
		IClientDao cdao=new ClientDaoImpl();
		PreparedStatement pst=null;
		  ResultSet rs;
		  String  sql="select * from vente where code= ?";
		  try {
		    pst=connection.prepareStatement(sql);
		    pst.setLong(1, code);
			//System.out.println("succes d'exec de la requete !");
			rs=pst.executeQuery();
			if(rs.next()) {
				long codeVente=rs.getLong("code");
				Date date =rs.getDate("date");
				Client client=cdao.getOne(rs.getLong("codeClient"));
				return new Vente(codeVente,date.toLocalDate(),client);
			}
		} catch (SQLException exp) {
			System.out.println(exp.getMessage());
		}
		
		return null;
	}

	@Override
	public List<Vente> getALL() {
		IClientDao cdao = new ClientDaoImpl();
		
		List<Vente> list=new ArrayList<Vente>();
		PreparedStatement pst=null;
		ResultSet rs;
		 String sql=" select * from vente ";
		 try {
			pst= connection.prepareStatement(sql);
			//System.out.println("Succes d'execution de requete!!");
			rs=pst.executeQuery();
			while(rs.next()) {
				Date date=rs.getDate("date");
				long code =rs.getLong("codeClient");
				Client client = cdao.getOne(code);
				list.add(new Vente(rs.getLong("code"), date.toLocalDate(),client));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		 
		return list;
		
	}

	@Override
	public List<Vente> getALL(String des) {
		// TODO Auto-generated method stub
		return null;
	}

}
