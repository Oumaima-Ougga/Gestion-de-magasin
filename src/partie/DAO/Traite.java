package partie.DAO;

import java.time.LocalDate;

public class Traite {
	
	LocalDate date;
	double montant;
	Cheque cheque;
	public LocalDate getDate() {
		return date;
	}
	public double getMontant() {
		return montant;
	}
	public Cheque getCheque() {
		return cheque;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public void setCheque(Cheque cheque) {
		this.cheque = cheque;
	}
	@Override
	public String toString() {
		return "Traite [date=" + date + ", montant=" + montant + ", cheque=" + cheque + "]";
	}
	public Traite(LocalDate date, double montant, Cheque cheque) {
		super();
		this.date = date;
		this.montant = montant;
		this.cheque = cheque;
	}
	
	

}
