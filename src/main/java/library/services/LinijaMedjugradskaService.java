package library.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import library.domain.BaseEntity;
import library.domain.LinijaMedjugradska;
import library.repository.LinijaMedjugradskaRepository;

@Service
public class LinijaMedjugradskaService {

	private LinijaMedjugradskaRepository linijaMedjugradskaRepository;

	@Autowired
	public LinijaMedjugradskaService(LinijaMedjugradskaRepository linijaMedjugradskaRepository) {
		this.linijaMedjugradskaRepository = linijaMedjugradskaRepository;
	}

	public Page<LinijaMedjugradska> findAll() {
		Pageable page = new PageRequest(2, 2);
		return linijaMedjugradskaRepository.findAll(page);
	}

	public LinijaMedjugradska save(LinijaMedjugradska linijaMedjugradska) {
		return linijaMedjugradskaRepository.save(linijaMedjugradska);
	}

	public Page<LinijaMedjugradska> pretraga(Date polazak, String prevoznik, String polaziste, String odrediste, Pageable page) {
		return linijaMedjugradskaRepository.pretraga(polazak, prevoznik, polaziste, odrediste, page);
	}
	
	public Page<BaseEntity> findAllOrderByPolazakAsc(Pageable page) {
		return linijaMedjugradskaRepository.findAllOrderByPolazakAsc(page);
	}
}
