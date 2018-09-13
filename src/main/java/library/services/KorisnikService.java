package library.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import library.domain.Korisnik;
import library.repository.KorisnikRepository;

@Service
public class KorisnikService {
	private KorisnikRepository korisnikRepository;

	@Autowired
	public KorisnikService(KorisnikRepository korisnikRepository) {
		this.korisnikRepository = korisnikRepository;
	}
	
	public Korisnik save(Korisnik user) {
		return korisnikRepository.save(user);
	}
	
	public List<Korisnik> findAll() {
		return korisnikRepository.findAll();
	}
	
	public Korisnik findOne(String username) {
		return korisnikRepository.findOne(username);
	}
	
	public void delete(String username) {
		korisnikRepository.delete(username);
	}
}
