package partie.DAO;

import java.util.List;


public interface IProduitDao extends IDao<Produit>{
	
	public List<Produit> getALL(String des);

}
