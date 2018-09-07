package library.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import library.domain.Vozac;
import library.repository.VozacRepository;

@Service
public class VozacService {
	
	private VozacRepository vozacRepository;

	@Autowired
	public VozacService(VozacRepository vozacRepository) {
		this.vozacRepository = vozacRepository;
	}
	
	public List<Vozac> findAll() {
		return vozacRepository.findAll();
	}
	
	public Vozac save(Vozac vozac) {
		return vozacRepository.save(vozac);
	}
}
