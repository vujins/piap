package library.domain.data;

import java.util.Date;
import java.util.List;

import org.jtransfo.DomainClass;
import org.jtransfo.MappedBy;

import library.domain.Linija;
import library.domain.LinijaMedjugradska;

@DomainClass(domainClass = LinijaMedjugradska.class)
public class LinijaMedjugradskaData extends BaseEntityData {

	@MappedBy(readOnly = true)
	private PrevoznikData prevoznik;

	@MappedBy(readOnly = true)
	private Date polazak;
	@MappedBy(readOnly = true)
	private Date dolazak;
	
	@MappedBy(readOnly = true)
	private List<Linija> medjulinije;

	public Date getPolazak() {
		return polazak;
	}

	public void setPolazak(Date polazak) {
		this.polazak = polazak;
	}

	public Date getDolazak() {
		return dolazak;
	}

	public void setDolazak(Date dolazak) {
		this.dolazak = dolazak;
	}

	public PrevoznikData getPrevoznik() {
		return prevoznik;
	}

	public void setPrevoznik(PrevoznikData prevoznik) {
		this.prevoznik = prevoznik;
	}

	public List<Linija> getMedjulinije() {
		return medjulinije;
	}

	public void setMedjulinije(List<Linija> medjulinije) {
		this.medjulinije = medjulinije;
	}

}
