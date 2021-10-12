package partie.DAO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Paiement {
	
	private long code;
	private Vente vente;
	private LocalDate date;
	private String type;
	double totalApayer;
	double TotalRestant;
	double totalPay�;
	private long numCheque;
    List<Traite> list = new ArrayList<>();
    
  
	@Override
	public String toString() {
		return "Paiement [code=" + code + ", vente=" + vente + ", date=" + date + ", type=" + type + ", totalApayer="
				+ totalApayer + ", TotalRestant=" + TotalRestant + ", totalPay�=" + totalPay� + ", numCheque="
				+ numCheque + "]";
	}
	public Paiement(long code, Vente vente, LocalDate date, String type, double totalApayer, double totalRestant,
			double totalPay�, long numCheque) {
		super();
		this.code = code;
		this.vente = vente;
		this.date = date;
		this.type = type;
		this.totalApayer = totalApayer;
		TotalRestant = totalRestant;
		this.totalPay� = totalPay�;
		this.numCheque=numCheque;
	}
	public Paiement(long code, Vente vente, LocalDate date, String type, double totalApayer,
			double totalPay�, long numCheque) {
		super();
		this.code = code;
		this.vente = vente;
		this.date = date;
		this.type = type;
		this.totalApayer = totalApayer;
		this.TotalRestant= totalApayer- totalPay�;
		this.totalPay� = totalPay�;
		this.numCheque=numCheque;
	}
	public long getNumCheque() {
		return numCheque;
	}
	public void setNumCheque(long numCheque) {
		this.numCheque = numCheque;
	}
	public long getCode() {
		return code;
	}
	public Vente getVente() {
		return vente;
	}
	public LocalDate getDate() {
		return date;
	}
	public String getType() {
		return type;
	}
	public double getTotalApayer() {
		
		return totalApayer;
	}
	public double getTotalRestant() {
		return TotalRestant;
	}
	public double getTotalPay�() {
		return totalPay�;
	}
	public List<Traite> getList() {
		return list;
	}
	public void setCode(long code) {
		this.code = code;
	}
	public void setVente(Vente vente) {
		this.vente = vente;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setTotalApayer(double totalApayer) {
		
		this.totalApayer = totalApayer;
	}
	public void setTotalRestant() {
		TotalRestant = this.totalApayer-this.totalPay�;
	}
	public void setTotalPay�(double totalPay�) {
		this.totalPay� = totalPay�;
	}
	public void setList(List<Traite> list) {
		this.list = list;
	}
    
    
}
