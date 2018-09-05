package library.domain.relation;

import java.io.Serializable;

import javax.persistence.Embeddable;

import library.domain.Linija;
import library.domain.Stajaliste;

@Embeddable
public class StajalisteLinijaRelation implements Serializable {

	private static final long serialVersionUID = 1L;
	private Stajaliste stajaliste;
	private Linija linija;
	
	public StajalisteLinijaRelation() {

	}
	
	public StajalisteLinijaRelation(Stajaliste stajaliste, Linija linija) {
		super();
		this.stajaliste = stajaliste;
		this.linija = linija;
	}

	public Stajaliste getStajaliste() {
		return stajaliste;
	}
	public void setStajaliste(Stajaliste stajaliste) {
		this.stajaliste = stajaliste;
	}
	public Linija getLinija() {
		return linija;
	}
	public void setLinija(Linija linija) {
		this.linija = linija;
	}
	
}
