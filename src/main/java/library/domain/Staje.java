package library.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import library.domain.relation.StajalisteLinijaRelation;

@Entity
@Table(name = "staje")
public class Staje {
	
	@EmbeddedId
	private StajalisteLinijaRelation staje;
	
	public Staje() {
		super();
	}

	public StajalisteLinijaRelation getStaje() {
		return staje;
	}

	public void setStaje(StajalisteLinijaRelation staje) {
		this.staje = staje;
	}
	
}
