package library.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import library.domain.Slika;
import library.repository.SlikaRepository;

@Service
public class SlikaService {
	
	private SlikaRepository slikaRepository;

	@Autowired
	public SlikaService(SlikaRepository slikaRepository) {
		this.slikaRepository = slikaRepository;
	}
	
	public Slika save(Slika slika) {
		return slikaRepository.save(slika);
	}
	
	public List<Slika> findAll() {
		return slikaRepository.findAll();
	}
	
}
