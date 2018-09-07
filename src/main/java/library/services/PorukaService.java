package library.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import library.domain.Poruka;
import library.repository.PorukaRepository;

@Service
@Transactional
public class PorukaService {

	private PorukaRepository porukaRepository;

	@Autowired
	public PorukaService(PorukaRepository porukaRepository) {
		super();
		this.porukaRepository = porukaRepository;
	}
	
	public Poruka save (Poruka poruka) {
		return porukaRepository.save(poruka);
	}
	
	public List<Poruka> findAll() {
		return porukaRepository.findAll();
	}
}
