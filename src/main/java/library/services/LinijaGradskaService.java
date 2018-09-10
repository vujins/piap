package library.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import library.domain.LinijaGradska;
import library.repository.LinijaGradskaRepository;

@Service
public class LinijaGradskaService {
	
	private LinijaGradskaRepository linijaGradskaRepository;

	@Autowired
	public LinijaGradskaService(LinijaGradskaRepository linijaGradskaRepository) {
		this.linijaGradskaRepository = linijaGradskaRepository;
	}
	
	public LinijaGradska save(LinijaGradska linijaGradska) {
		return linijaGradskaRepository.save(linijaGradska);
	}
	
	public List<LinijaGradska> findAll() {
		return linijaGradskaRepository.findAll();
	}
	
	public void delete(Long id) {
		linijaGradskaRepository.delete(id);
	}
	
	public List<LinijaGradska> pretraga(Integer broj_linije, String polaziste, String odrediste){
		return linijaGradskaRepository.pretraga(broj_linije, polaziste, odrediste);
	}
	
}
