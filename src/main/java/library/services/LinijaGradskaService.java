package library.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	
	public Page<LinijaGradska> findAll(Pageable page) {
		return linijaGradskaRepository.findAll(page);
	}
	
	public void delete(Long id) {
		linijaGradskaRepository.delete(id);
	}
	
	public Page<LinijaGradska> pretraga(Integer broj_linije, String polaziste, String odrediste, Pageable page){
		return linijaGradskaRepository.pretraga(broj_linije, polaziste, odrediste, page);
	}
	
}
