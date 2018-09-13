package library.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tip_korisnika")
public class TipKorisnika {

	public enum Tip {
		KORISNIK, ADMIN
	}
	
	@Id
	@Enumerated(EnumType.STRING)
	public Tip tip;

	public Tip getTip() {
		return tip;
	}

	public void setTip(Tip tip) {
		this.tip = tip;
	}
	
}
