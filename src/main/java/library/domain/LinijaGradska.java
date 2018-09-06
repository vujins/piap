package library.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "gradska")
//@PrimaryKeyJoinColumn(name = "linija_id")
public class LinijaGradska extends Linija {
	private int linija;
	private String red_voznje;
	
	public LinijaGradska() {
		
	}

	public int getBroj_linije() {
		return linija;
	}

	public void setBroj_linije(int broj_linije) {
		this.linija = broj_linije;
	}

	public String getRed_voznje() {
		return red_voznje;
	}

	public void setRed_voznje(String red_voznje) {
		this.red_voznje = red_voznje;
	}
	
}
