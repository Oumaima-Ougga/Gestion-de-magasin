package partie.DAO;

import java.util.ArrayList;
import java.util.List;

public class Client {
	private long code;
	private String nom;
	private String prenom;
	private long telephone;
	private String email;
	private String adresse;
	private List<Vente> list = new ArrayList();
	
	public Client(){
		
	}
public Client(long code){
		this.code=code;
	}
	public long getCode() {
		return code;
	}
	public void setCode(long code) {
		this.code = code;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public long getTelephone() {
		return telephone;
	}
	public void setTelephone(long telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public Client(long code, String nom, String prenom, long telephone, String email, String adresse) {
		super();
		this.code = code;
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.email = email;
		this.adresse = adresse;
	}
	@Override
	public String toString() {
		return this.code+" " ;
	}
   
	

}
