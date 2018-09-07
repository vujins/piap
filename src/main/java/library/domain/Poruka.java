package library.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "poruka")
public class Poruka extends BaseEntity {

	@NotNull
	private String poruka;
	@NotNull
	@OneToOne
	private LinijaGradska gradska;
	@NotNull
	private Date datum_od;
	@NotNull
	private Date datum_do;

	public String getPoruka() {
		return poruka;
	}

	public void setPoruka(String poruka) {
		this.poruka = poruka;
	}

	public LinijaGradska getGradska() {
		return gradska;
	}

	public void setGradska(LinijaGradska gradska) {
		this.gradska = gradska;
	}

	public Date getDatum_od() {
		return datum_od;
	}

	public void setDatum_od(Date datum_od) {
		this.datum_od = datum_od;
	}

	public Date getDatum_do() {
		return datum_do;
	}

	public void setDatum_do(Date datum_do) {
		this.datum_do = datum_do;
	}

}
