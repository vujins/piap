package library.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "korisnik")
public class Korisnik {
	
	public enum Zaposlen {
		nezaposlen, zaposlen, student, lice_sa_invaliditetom, penzioner
	}
	
	@Id
	@NotNull
	@Column(nullable = false)
	private String username;
	
	@NotNull
	@Column(nullable = false)
	private String password;

	//TODO staviti da budu svi @NotNull osim email-a
	
	private String ime;
	private String prezime;
	
	private String opstina;
	private String grad;
	private String adresa;
	
	private Date rodjendan;
	private String telefon;
	private Zaposlen zaposlen;
	
	//flagovi
	@Column(columnDefinition = "BIT default 0")
	private boolean admin;
	@Column(columnDefinition = "BIT default 0")
	private boolean odobren;
	
	public Korisnik() {
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getOpstina() {
		return opstina;
	}

	public void setOpstina(String opstina) {
		this.opstina = opstina;
	}

	public String getGrad() {
		return grad;
	}

	public void setGrad(String grad) {
		this.grad = grad;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public Date getRodjendan() {
		return rodjendan;
	}

	public void setRodjendan(Date rodjendan) {
		this.rodjendan = rodjendan;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public Zaposlen getZaposlen() {
		return zaposlen;
	}

	public void setZaposlen(Zaposlen zaposlen) {
		this.zaposlen = zaposlen;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public boolean isOdobren() {
		return odobren;
	}

	public void setOdobren(boolean odobren) {
		this.odobren = odobren;
	}

}
