package partie.DAO;

import java.util.List;

public interface IPaiementDao extends IDao<Paiement> {
	
	public List<Paiement> getALL(long code);

}
