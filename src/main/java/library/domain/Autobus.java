package library.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "autobus")
public class Autobus extends BaseEntity {

	private String marka;
	private String model;
	private int broj_sedista;
	
	@OneToMany
	@JoinTable(
			name = "autobus_slika", 
			joinColumns = @JoinColumn(name = "autobus_id", referencedColumnName = "id"), 
			inverseJoinColumns = @JoinColumn(name = "slika_id", referencedColumnName = "id")
	)
	private List<Slika> slike;

	public String getMarka() {
		return marka;
	}

	public void setMarka(String marka) {
		this.marka = marka;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getBroj_sedista() {
		return broj_sedista;
	}

	public void setBroj_sedista(int broj_sedista) {
		this.broj_sedista = broj_sedista;
	}

	public List<Slika> getSlike() {
		return slike;
	}

	public void setSlike(List<Slika> slike) {
		this.slike = slike;
	}
	
}
