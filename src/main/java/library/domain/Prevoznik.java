package library.domain;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "prevoznik")
public class Prevoznik extends BaseEntity {
	
	//TODO mozda @NotNull?????
	
	private String naziv;
	private String adresa;
	private String telefon;
	
	@OneToOne
	private Slika slika;
	
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	public Slika getSlika() {
		return slika;
	}
	public void setSlika(Slika slika) {
		this.slika = slika;
	}
	
}
