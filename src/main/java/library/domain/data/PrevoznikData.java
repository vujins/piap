package library.domain.data;

import org.jtransfo.DomainClass;
import org.jtransfo.MappedBy;

import library.domain.Prevoznik;

@DomainClass(domainClass = Prevoznik.class)
public class PrevoznikData extends BaseEntityData {
	
	@MappedBy(readOnly = true)
	private String naziv;

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	
}
