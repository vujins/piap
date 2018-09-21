package library.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import library.domain.Cene;
import library.domain.Cene.tip_karte;
import library.repository.CeneRepository;

@Service
public class CeneService {

	private CeneRepository ceneRepository;
	
	@Autowired
	public CeneService(CeneRepository ceneRepository) {
		this.ceneRepository = ceneRepository;
	}
	
	public Cene findOne(tip_karte tip) {
		return ceneRepository.findOne(tip);
	}
}
