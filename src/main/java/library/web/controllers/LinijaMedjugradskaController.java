package library.web.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import library.domain.BaseEntity;
import library.domain.LinijaMedjugradska;
import library.services.LinijaMedjugradskaService;

@RestController
@RequestMapping("/medjugradska")
@CrossOrigin(origins = "http://localhost:4200")
public class LinijaMedjugradskaController {

	private LinijaMedjugradskaService linijaMedjugradskaService;

	@Autowired
	public LinijaMedjugradskaController(LinijaMedjugradskaService linijaMedjugradskaService) {
		this.linijaMedjugradskaService = linijaMedjugradskaService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public Page<BaseEntity> findAllOrderByPolazakAsc(@RequestParam(name = "stranica") int stranica) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		Pageable pageable = new PageRequest(stranica, 10);
//		if (!"anonymousUser".equals(auth.getPrincipal().toString())) {
//			pageable = new PageRequest(stranica, 20);
//		} else {
//			pageable = new PageRequest(stranica, 10);
//		}
		
		return linijaMedjugradskaService.findAllOrderByPolazakAsc(pageable);

	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(method = RequestMethod.POST)
	public LinijaMedjugradska save(@RequestBody LinijaMedjugradska linijaMedjugradska) {
		return linijaMedjugradskaService.save(linijaMedjugradska);
	}

	@RequestMapping(path = "pretraga", method = RequestMethod.GET)
	public Page<LinijaMedjugradska> pretraga(@RequestParam(name = "polazak") Date polazak,
			@RequestParam(name = "prevoznik", required = false) String prevoznik,
			@RequestParam(name = "polaziste", required = false) String polaziste,
			@RequestParam(name = "odrediste", required = false) String odrediste,
			@RequestParam(name = "stranica") int stranica) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		Pageable pageable;
		// TODO promeni broj stranica
		if (!"anonymousUser".equals(auth.getPrincipal().toString())) {
			pageable = new PageRequest(stranica, 20);
		} else {
			pageable = new PageRequest(stranica, 10);
		}

		return linijaMedjugradskaService.pretraga(polazak, prevoznik, polaziste, odrediste, pageable);
	}

}
