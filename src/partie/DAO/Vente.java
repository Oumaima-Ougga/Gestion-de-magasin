package partie.DAO;

import java.sql.Date;
import java.time.*;
import java.util.ArrayList;
import java.util.List;

public class Vente {
	private long code;
	private LocalDate date;
	private Client client;
	double total;
	private List<LigneDeCommande> list = new ArrayList();
	
	public Vente(long code, LocalDate date, Client client, List<LigneDeCommande> list) {
		super();
		this.code = code;
		this.date = date;
		this.client = client;
		this.list = list;
	}
	
	public Vente(long code, LocalDate date, long codeClient) {
		super();
		this.code = code;
		this.date = date;
	    this.client= new Client(codeClient);
	}
	public Vente(long code) {
		super();
		this.code = code;
		
	}
	public long getCode() {
		return code;
	}
	public void setCode(long code) {
		this.code = code;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public List<LigneDeCommande> getList() {
		return list;
	}
	public void setList(List<LigneDeCommande> list) {
		this.list = list;
	}
	public Vente(long code, LocalDate date, List<LigneDeCommande> list) {
		super();
		this.code = code;
		this.date = date;
		this.list = list;
	}
	public Vente(long codeVente, LocalDate date, Client client) {
		this.code=codeVente;
		this.date=date;
		this.client=client;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return ""+ code ;
	}
	
	

}
