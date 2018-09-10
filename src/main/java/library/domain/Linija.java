package library.domain;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Linija extends BaseEntity {
	
	//TODO zbog pretrage ne sme da bude @NotNull
	
	@ManyToOne
	@NotNull
	private Stajaliste polaziste;
	@ManyToOne
	@NotNull
	private Stajaliste odrediste;

	public Stajaliste getPolaziste() {
		return polaziste;
	}

	public void setPolaziste(Stajaliste polaziste) {
		this.polaziste = polaziste;
	}

	public Stajaliste getOdrediste() {
		return odrediste;
	}

	public void setOdrediste(Stajaliste odrediste) {
		this.odrediste = odrediste;
	}
	
}
