package library.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import library.domain.Staje;
import library.repository.StajeRepository;

@Service
public class StajeService {
	private StajeRepository stajeRepository;

	@Autowired
	public StajeService(StajeRepository stajeRepository) {
		this.stajeRepository = stajeRepository;
	}
	
	public Staje save(Staje staje) {
		return stajeRepository.save(staje);
	}
	
	public List<Staje> findAll() {
		return stajeRepository.findAll();
	}
	
	//TODO dodaj delete, po cemu da ga pretrazuje i po cemu da ga brise?
}
