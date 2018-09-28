package library.domain.data;

import org.jtransfo.DomainClass;

import library.domain.Stajaliste;

@DomainClass(domainClass = Stajaliste.class)
public class StajalisteData {
	
	private String naziv;

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	
	
}
