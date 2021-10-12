package partie.DAO;

import java.util.List;

public interface IVenteDao extends IDao<Vente>{
	
	public List<Vente> getALL(String des);

}