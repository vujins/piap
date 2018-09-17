package library.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import library.domain.Stajaliste;
import library.repository.StajalisteRepository;

@Service
public class StajalisteService {
	private StajalisteRepository stajalisteRepository;

	@Autowired
	public StajalisteService(StajalisteRepository stajalisteRepository) {
		this.stajalisteRepository = stajalisteRepository;
	}
	
	public Stajaliste save(Stajaliste stajaliste) {
		return stajalisteRepository.save(stajaliste);
	}
	
	public List<Stajaliste> findAll() {
		return stajalisteRepository.findAll();
	}
	
	public Stajaliste findByNaziv(String naziv) {
		return stajalisteRepository.findByNaziv(naziv);
	}
	
}
