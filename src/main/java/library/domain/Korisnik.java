package library.domain;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
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
	private String username;

	@NotNull
	private String password;

	// TODO staviti da budu svi @NotNull osim email-a

	@NotNull
	private String ime;
	@NotNull
	private String prezime;

	@NotNull
	private String opstina;
	@NotNull
	private String grad;
	@NotNull
	private String adresa;

	@NotNull
	private Date rodjendan;
	@NotNull
	private String telefon;
	private String email;
	@NotNull
	@Enumerated(EnumType.STRING)
	private Zaposlen zaposlen;
	
	@OneToOne
	private MesecnaKarta mesecna;

	// flagovi
	@NotNull
	@Column(columnDefinition = "BIT default 0")
	private boolean admin;
	@NotNull
	@Column(columnDefinition = "BIT default 0")
	private boolean odobren;

	// TODO zavrsi rezervaciju

	@ManyToMany(targetEntity = LinijaMedjugradska.class)
	@JoinTable(name = "korisnik_rezervacija", joinColumns = @JoinColumn(name = "korisnik_username", referencedColumnName = "username"), inverseJoinColumns = @JoinColumn(name = "medjugradska_id", referencedColumnName = "id"))
	private Set<LinijaMedjugradska> rezervacija;

	@ManyToMany
	@JoinTable(name = "korisnik_poruka", joinColumns = @JoinColumn(name = "korisnik_username", referencedColumnName = "username"), inverseJoinColumns = @JoinColumn(name = "poruka_id", referencedColumnName = "id"))
	private List<Poruka> poruke;

	public MesecnaKarta getMesecna() {
		return mesecna;
	}

	public void setMesecna(MesecnaKarta mesecna) {
		this.mesecna = mesecna;
	}

	public Set<LinijaMedjugradska> getRezervacijaSet() {
		return rezervacija;
	}

	public void setRezervacijaSet(Set<LinijaMedjugradska> rezervacija) {
		this.rezervacija = rezervacija;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<LinijaMedjugradska> getRezervacija() {
		return rezervacija;
	}

	public void setRezervacija(Set<LinijaMedjugradska> rezervacija) {
		this.rezervacija = rezervacija;
	}

	public List<Poruka> getPoruke() {
		return poruke;
	}

	public void setPoruke(List<Poruka> poruke) {
		this.poruke = poruke;
	}

}
