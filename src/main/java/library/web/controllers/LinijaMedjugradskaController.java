package library.web.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import library.domain.LinijaMedjugradska;
import library.services.LinijaMedjugradskaService;

@RestController
@RequestMapping("/medjugradska")
public class LinijaMedjugradskaController {

	private LinijaMedjugradskaService linijaMedjugradskaService;

	@Autowired
	public LinijaMedjugradskaController(LinijaMedjugradskaService linijaMedjugradskaService) {
		this.linijaMedjugradskaService = linijaMedjugradskaService;
	}


//	@PreAuthorize("hasAnyRole('KORISNIK', 'ADMIN')")
	@RequestMapping(method = RequestMethod.GET)
	public Page<LinijaMedjugradska> findAllOrderByPolazakAsc(@RequestParam(name = "stranica") int stranica) {
		// TODO promeni broj stranica
		//TODO ubaci jtransfo, mozda da baseentity bude base klasa pa polimorfno
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		Pageable pageable;
		
		//TODO proveri sa rolama
		if (!"anonymousUser".equals(auth.getPrincipal().toString())) {
			pageable = new PageRequest(stranica, 3);
		} else {
			pageable = new PageRequest(stranica, 2);
		}
		return linijaMedjugradskaService.findAllOrderByPolazakAsc(pageable);

	}

//	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(method = RequestMethod.POST)
	public LinijaMedjugradska save(@RequestBody LinijaMedjugradska linijaMedjugradska) {
		return linijaMedjugradskaService.save(linijaMedjugradska);
	}

	@RequestMapping(path = "pretraga", method = RequestMethod.GET)
	public List<LinijaMedjugradska> pretraga(@RequestParam(name = "polazak") Date polazak,
			@RequestParam(name = "prevoznik", required = false) String prevoznik,
			@RequestParam(name = "polaziste", required = false) String polaziste,
			@RequestParam(name = "odrediste", required = false) String odrediste,
			@RequestParam(name = "stranica") int stranica) {

		// TODO vrati jtransfo objekte ako korisnik nije ulogovan

//		if (ulogovan) {
//
//		} else {
//
//		}

		return linijaMedjugradskaService.pretraga(polazak, prevoznik, polaziste, odrediste, new PageRequest(stranica, 2));
	}

	// -------------------------------GOST---------------------------------

//	@RequestMapping(path="gost", method = RequestMethod.GET)
//	public Page<LinijaMedjugradskaData> findAllGost(@RequestParam(name = "stranica") int stranica) {
//		return new JTransfoImpl().convertList(linijaMedjugradskaService.findAllOrderByPolazakAsc(stranica), LinijaMedjugradskaData.class);
//	}

//	@RequestMapping(path = "pretraga/gost", method = RequestMethod.GET)
//	public List<LinijaMedjugradskaData> pretragaGost(@RequestParam(name = "polazak") Date polazak,
//			@RequestParam(name = "prevoznik", required = false) String prevoznik,
//			@RequestParam(name = "polaziste", required = false) String polaziste,
//			@RequestParam(name = "odrediste", required = false) String odrediste,
//			@RequestParam(name = "stranica") int stranica) {
//
//		// TODO vrati jtransfo objekte ako korisnik nije ulogovan
//
////		if (ulogovan) {
////
////		} else {
////
////		}
//
//		return new JTransfoImpl().convertList(
//				linijaMedjugradskaService.pretraga(polazak, prevoznik, polaziste, odrediste, stranica),
//				LinijaMedjugradskaData.class);
//	}

}
