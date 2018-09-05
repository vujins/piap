package library.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "stajaliste")
public class Stajaliste extends BaseEntity {

	private String naziv;

	public Stajaliste() {
		
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	
}
