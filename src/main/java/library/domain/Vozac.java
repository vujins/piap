package library.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "vozac")
public class Vozac extends BaseEntity {
	
	private String ime;
	private String prezime;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
	private Date rodjendan;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
	private Date datum_zaposlenja;
	
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public Date getRodjendan() {
		return rodjendan;
	}
	public void setRodjendan(Date rodjendan) {
		this.rodjendan = rodjendan;
	}
	public Date getDatum_zaposlenja() {
		return datum_zaposlenja;
	}
	public void setDatum_zaposlenja(Date datum_zaposlenja) {
		this.datum_zaposlenja = datum_zaposlenja;
	}
	
}
