package library.domain.data;

import org.jtransfo.DomainClass;

import library.domain.Linija;

@DomainClass(domainClass = Linija.class)
public class LinijaData {

	private StajalisteData polaziste;
	private StajalisteData odrediste;
	
	public StajalisteData getPolaziste() {
		return polaziste;
	}
	public void setPolaziste(StajalisteData polaziste) {
		this.polaziste = polaziste;
	}
	public StajalisteData getOdrediste() {
		return odrediste;
	}
	public void setOdrediste(StajalisteData odrediste) {
		this.odrediste = odrediste;
	}
	
}
