package library.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "cene")
public class Cene {

	public enum tip_karte {
		mesecna, godisnja
	}
	
	@Id
	@NotNull
	@Enumerated(EnumType.STRING)
	private tip_karte tip;
	
	@NotNull
	private int cena;

	public tip_karte getTip() {
		return tip;
	}

	public void setTip(tip_karte tip) {
		this.tip = tip;
	}

	public int getCena() {
		return cena;
	}

	public void setCena(int cena) {
		this.cena = cena;
	}
	
	
}
