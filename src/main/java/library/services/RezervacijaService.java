package library.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import library.domain.Rezervacija;
import library.repository.RezervacijaRepository;

@Service
public class RezervacijaService {

	private RezervacijaRepository rezervacijaRepository;
	
	@Autowired
	public RezervacijaService(RezervacijaRepository rezervacijaRepository) {
		this.rezervacijaRepository = rezervacijaRepository;
	}
	
	public List<Rezervacija> findAll() {
		return rezervacijaRepository.findAll();
	}
	
	public Rezervacija save(Rezervacija rezervacija) {
		return rezervacijaRepository.save(rezervacija);
	}
	
	public List<Rezervacija> findByKorisnik(String username) {
		return rezervacijaRepository.findByKorisnik(username);
	}
	
	public void delete(Long id) {
		rezervacijaRepository.delete(id);
	}
	
	public Rezervacija findOne(Long id) {
		return rezervacijaRepository.findOne(id);
	}
}
