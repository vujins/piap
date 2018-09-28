package library.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "gradska")
public class LinijaGradska extends BaseEntity {
	
	@NotNull
	private Integer broj_linije;
	@NotNull
	private String red_voznje;
	
	@NotNull
	@ManyToOne
	private Vozac vozac;
	
	@NotNull
	@ManyToMany
	@JoinTable(
			name = "gradska_linija", 
			joinColumns = @JoinColumn(name = "gradska_id", referencedColumnName = "id"), 
			inverseJoinColumns = @JoinColumn(name = "linija_id", referencedColumnName = "id")
	)
	private List<Linija> medjulinije;

	public List<Linija> getMedjulinije() {
		return medjulinije;
	}

	public void setMedjulinije(List<Linija> medjulinije) {
		this.medjulinije = medjulinije;
	}

	public String getRed_voznje() {
		return red_voznje;
	}

	public void setRed_voznje(String red_voznje) {
		this.red_voznje = red_voznje;
	}

	public int getBroj_linije() {
		return broj_linije;
	}

	public void setBroj_linije(int broj_linije) {
		this.broj_linije = broj_linije;
	}

	public Vozac getVozac() {
		return vozac;
	}

	public void setVozac(Vozac vozac) {
		this.vozac = vozac;
	}
	
}
