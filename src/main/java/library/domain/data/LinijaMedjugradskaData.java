package library.domain.data;

import java.util.Date;
import java.util.List;

import org.jtransfo.DomainClass;
import org.jtransfo.MappedBy;

import com.fasterxml.jackson.annotation.JsonFormat;

import library.domain.BaseEntity;
import library.domain.LinijaMedjugradska;

@DomainClass(domainClass = LinijaMedjugradska.class)
public class LinijaMedjugradskaData extends BaseEntity {

	@MappedBy(readOnly = true)
	private PrevoznikData prevoznik;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
	@MappedBy(readOnly = true)
	private Date polazak;

	@MappedBy(readOnly = true)
	private List<LinijaData> medjulinije;

	public Date getPolazak() {
		return polazak;
	}

	public void setPolazak(Date polazak) {
		this.polazak = polazak;
	}

	public PrevoznikData getPrevoznik() {
		return prevoznik;
	}

	public void setPrevoznik(PrevoznikData prevoznik) {
		this.prevoznik = prevoznik;
	}

	public List<LinijaData> getMedjulinije() {
		return medjulinije;
	}

	public void setMedjulinije(List<LinijaData> medjulinije) {
		this.medjulinije = medjulinije;
	}

}
