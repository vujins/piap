package library.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import library.domain.Linija;
import library.repository.LinijaRepository;

@Service
public class LinijaService {
	
	private LinijaRepository linijaRepository;

	@Autowired
	public LinijaService(LinijaRepository linijaRepository) {
		super();
		this.linijaRepository = linijaRepository;
	}
	
	public Linija save(Linija linija) {
		return linijaRepository.save(linija);
	}
	
	public List<Linija> findAll() {
		return linijaRepository.findAll();
	}
	
	public Linija findByPolazisteAndOdrediste(String polaziste, String odrediste) {
		Linija l =linijaRepository.findByPolazisteAndOdrediste(polaziste, odrediste);
		System.out.println(l);
		return l;
	}
	
}
