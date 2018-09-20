package library.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "rezervacija")
public class Rezervacija extends BaseEntity {

	@ManyToOne(targetEntity = LinijaMedjugradska.class)
	@NotNull
	private LinijaMedjugradska linija;
	
	@ManyToOne(targetEntity = Korisnik.class)
	@NotNull
	private Korisnik korisnik;
	
	@NotNull
	@Column(columnDefinition = "BIT default 0")
	private boolean odobren;

	public Rezervacija() {
		super();
	}

	public Rezervacija(LinijaMedjugradska linija, Korisnik korisnik) {
		super();
		this.linija = linija;
		this.korisnik = korisnik;
	}

	public LinijaMedjugradska getLinija() {
		return linija;
	}

	public void setLinija(LinijaMedjugradska linija) {
		this.linija = linija;
	}

	public Korisnik getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

	public boolean isOdobren() {
		return odobren;
	}

	public void setOdobren(boolean odobren) {
		this.odobren = odobren;
	}
	
}
