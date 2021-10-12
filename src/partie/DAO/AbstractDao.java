package partie.DAO;

import java.sql.Connection;

public abstract class AbstractDao {
	
	protected Connection connection=SingleConnection.getConnection();

}
