package library.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import library.domain.LinijaMedjugradska;
import library.repository.LinijaMedjugradskaRepository;

@Service
public class LinijaMedjugradskaService {
	
	private LinijaMedjugradskaRepository linijaMedjugradskaRepository;

	@Autowired
	public LinijaMedjugradskaService(LinijaMedjugradskaRepository linijaMedjugradskaRepository) {
		this.linijaMedjugradskaRepository = linijaMedjugradskaRepository;
	}
	
	public List<LinijaMedjugradska> findAll() { 
		return linijaMedjugradskaRepository.findAll();
	}
	
	public LinijaMedjugradska save(LinijaMedjugradska linijaMedjugradska) {
		return linijaMedjugradskaRepository.save(linijaMedjugradska);
	}
	
}
