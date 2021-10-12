package partie.DAO;

import java.util.List;

public interface ILigneCmdDao extends IDao<LigneDeCommande> {
	
	public List<LigneDeCommande> getALL(long code);
	public void delete(long codeProduit,long codeVente);

}
