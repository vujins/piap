package library.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import library.domain.Linija;
import library.domain.LinijaMedjugradska;
import library.domain.Prevoznik;
import library.repository.LinijaMedjugradskaRepository;

@Service
public class LinijaMedjugradskaService {
	
	private LinijaMedjugradskaRepository linijaMedjugradskaRepository;

	@Autowired
	public LinijaMedjugradskaService(LinijaMedjugradskaRepository linijaMedjugradskaRepository) {
		this.linijaMedjugradskaRepository = linijaMedjugradskaRepository;
	}
	
	public List<LinijaMedjugradska> findAll(String prevoznik) {
		LinijaMedjugradska lm = new LinijaMedjugradska();
		Prevoznik p = new Prevoznik();
		p.setNaziv(prevoznik);
		lm.setPrevoznik(p);
		
		return linijaMedjugradskaRepository.findAll(Example.of(lm));
	}
	
	public LinijaMedjugradska save(LinijaMedjugradska linijaMedjugradska) {
		return linijaMedjugradskaRepository.save(linijaMedjugradska);
	}
	
	public List<LinijaMedjugradska> findFromPrevoznik (Prevoznik prevoznik) {
		return linijaMedjugradskaRepository.findFromPrevoznik(prevoznik);
	}
	
	public List<LinijaMedjugradska> findFromLinija(Linija linija) {
		return linijaMedjugradskaRepository.findFromLinija(linija);
	}
}
