package partie.DAO;

import java.util.List;

public interface IDao <T>{
	
	public void add(T obj);
	public void delete(long code);
	public T getOne(long code);
	public List<T> getALL();

}
