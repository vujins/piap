package library.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Linija extends BaseEntity {

	@ManyToMany(targetEntity = Stajaliste.class)
	@JoinTable(
			name = "linija_stajaliste",
			joinColumns = @JoinColumn(
					name = "linija_id",
					referencedColumnName = "id"
			),
			inverseJoinColumns = @JoinColumn(
					name = "stajaliste_id",
					referencedColumnName = "id"
			)
	)
	private Set<Stajaliste> stajalisteSet;
	
	@ManyToOne
	@NotNull
	private Stajaliste polaziste;
	@ManyToOne
	@NotNull
	private Stajaliste odrediste;

	public Set<Stajaliste> getStajalisteSet() {
		return stajalisteSet;
	}

	public void setStajalisteSet(Set<Stajaliste> stajalisteSet) {
		this.stajalisteSet = stajalisteSet;
	}

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
