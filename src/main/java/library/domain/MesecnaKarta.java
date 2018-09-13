package library.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "mesecna_karta")
public class MesecnaKarta extends BaseEntity {
	
	public enum tip_karte {
		mesecna, godisnja
	}
	
	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
	private Date pocetak;
	@NotNull
	@Enumerated(EnumType.STRING)
	private tip_karte tip;
	
	public Date getPocetak() {
		return pocetak;
	}
	public void setPocetak(Date pocetak) {
		this.pocetak = pocetak;
	}
	public tip_karte getTip() {
		return tip;
	}
	public void setTip(tip_karte tip) {
		this.tip = tip;
	}
	
}
