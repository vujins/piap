package library.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import library.domain.Prevoznik;
import library.repository.PrevoznikRepository;

@Service
public class PrevoznikService {
	
	private PrevoznikRepository prevoznikRepository;

	@Autowired
	public PrevoznikService(PrevoznikRepository prevoznikRepository) {
		this.prevoznikRepository = prevoznikRepository;
	}
	
	public Prevoznik save(Prevoznik prevoznik) {
		return prevoznikRepository.save(prevoznik);
	}
	
	public List<Prevoznik> findAll() {
		return prevoznikRepository.findAll();
	}
	
	
}
