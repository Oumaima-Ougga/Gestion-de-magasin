package partie.DAO;

import java.util.List;

public interface IClientDao extends IDao<Client>{
	
	public List<Client> getALL(String des);

}
