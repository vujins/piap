package library.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "medjugradska")
public class LinijaMedjugradska extends BaseEntity {

	@NotNull
	private Date polazak;
	@NotNull
	private Date dolazak;
	
	@NotNull
	@ManyToOne
	private Vozac vozac;
	@NotNull
	@ManyToOne
	private Prevoznik prevoznik;
	@NotNull
	@ManyToOne 
	private Autobus autobus;
	
	@NotNull
	@ManyToMany
	@JoinTable(
			name = "medjugradska_linija", 
			joinColumns = @JoinColumn(name = "medjugradska_id", referencedColumnName = "id"), 
			inverseJoinColumns = @JoinColumn(name = "linija_id", referencedColumnName = "id")
	)
	private List<Linija> medjulinije;

	public List<Linija> getMedjulinije() {
		return medjulinije;
	}

	public void setMedjulinije(List<Linija> medjulinije) {
		this.medjulinije = medjulinije;
	}

	public Vozac getVozac() {
		return vozac;
	}

	public void setVozac(Vozac vozac) {
		this.vozac = vozac;
	}

	public Prevoznik getPrevoznik() {
		return prevoznik;
	}

	public void setPrevoznik(Prevoznik prevoznik) {
		this.prevoznik = prevoznik;
	}

	public Autobus getAutobus() {
		return autobus;
	}

	public void setAutobus(Autobus autobus) {
		this.autobus = autobus;
	}

	public Date getPolazak() {
		return polazak;
	}

	public void setPolazak(Date polazak) {
		this.polazak = polazak;
	}

	public Date getDolazak() {
		return dolazak;
	}

	public void setDolazak(Date dolazak) {
		this.dolazak = dolazak;
	}

}
