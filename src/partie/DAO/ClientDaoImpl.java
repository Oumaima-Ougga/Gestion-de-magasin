package partie.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientDaoImpl extends AbstractDao implements IClientDao{

	@Override
	public void add(Client obj) {
		PreparedStatement pst=null;
		String sql="insert into client (code, nom, prenom , telephone, email , adresse  ) values (?,?,?,?,?,?)";
		 try {
			pst= connection.prepareStatement(sql);
			pst.setLong(1, obj.getCode());
			pst.setString(2, obj.getNom());
			pst.setString(3, obj.getPrenom());
			pst.setLong(4, obj.getTelephone());
			pst.setString(5, obj.getEmail());
			pst.setString(6, obj.getAdresse());
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
		String sql=" delete from client where code like ?";
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
	public Client getOne(long code) {
		Client client=new Client();
		PreparedStatement pst=null;
		
		ResultSet rs;
		 String sql=" select * from client where code=? ";
		 try { 
			pst= connection.prepareStatement(sql);
			pst.setLong(1,code);
			//System.out.println("Succes d'execution de requete!!");
			rs=pst.executeQuery();
			if(rs.next()) {
				//System.out.println(rs.getLong("code")+" "+rs.getString("designation"));
				return new Client(rs.getLong("code"), rs.getString("nom"), rs.getString("prenom"),rs.getLong("telephone"),  rs.getString("email"),  rs.getString("adresse"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		 
		return null;
	}

	@Override
	public List<Client> getALL() {
		List<Client> list=new ArrayList<Client>();
		PreparedStatement pst=null;
		ResultSet rs;
		 String sql=" select * from client ";
		 try {
			pst= connection.prepareStatement(sql);
			//System.out.println("Succes d'execution de requete!!");
			rs=pst.executeQuery();
			while(rs.next()) {
				list.add(new Client(rs.getLong("code"), rs.getString("nom"), rs.getString("prenom"),rs.getLong("telephone"),  rs.getString("email"),  rs.getString("adresse")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		 
		return list;
	}

	@Override
	public List<Client> getALL(String des) {
		List<Client> list=new ArrayList<Client>();
		PreparedStatement pst=null;
		ResultSet rs;
		String sql=" select * from client where designation like ?";
		 try {
			pst= connection.prepareStatement(sql);
			pst.setString(1, des+"%");
			//System.out.println("Succes d'execution de requete!!");
			rs=pst.executeQuery();
			while(rs.next()) {
				list.add(new Client(rs.getLong("code"), rs.getString("nom"), rs.getString("prenom"),rs.getLong("telephone"),  rs.getString("email"),  rs.getString("adresse")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		 
		return list;
	}

	

}
