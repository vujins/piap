package library.web.controllers;

import java.util.Date;
import java.util.List;

import org.jtransfo.internal.JTransfoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import library.domain.LinijaMedjugradska;
import library.domain.data.LinijaMedjugradskaData;
import library.services.LinijaMedjugradskaService;

@RestController
@RequestMapping("/medjugradska")
public class LinijaMedjugradskaController {

	private LinijaMedjugradskaService linijaMedjugradskaService;

	@Autowired
	public LinijaMedjugradskaController(LinijaMedjugradskaService linijaMedjugradskaService) {
		this.linijaMedjugradskaService = linijaMedjugradskaService;
	}

	@RequestMapping(path="unsorted", method = RequestMethod.GET)
	public Page<LinijaMedjugradska> findAll() {
		// TODO vrati jtransfo objekte ako korisnik nije ulogovan, ako je gost samo 10 najskorijih
		return linijaMedjugradskaService.findAll();
	}
	
//	@PreAuthorize("hasAnyRole('KORISNIK', 'ADMIN')")
	@RequestMapping(method = RequestMethod.GET)
	public Page<LinijaMedjugradska> findAllOrderByPolazakAsc(@RequestParam(name = "stranica") int stranica) {
		
		Authentication auth =  SecurityContextHolder.getContext().getAuthentication();
		
		//TODO imas metodu get authorities
		if (auth.isAuthenticated()) {
			return linijaMedjugradskaService.findAllOrderByPolazakAsc(stranica); 
		} else {
			System.out.println("nije ulogovan");
			return null;
		}
		
		
	}

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

		return linijaMedjugradskaService.pretraga(polazak, prevoznik, polaziste, odrediste, stranica);
	}
	
	//-------------------------------GOST---------------------------------
	
//	@RequestMapping(path="gost", method = RequestMethod.GET)
//	public Page<LinijaMedjugradskaData> findAllGost(@RequestParam(name = "stranica") int stranica) {
//		return new JTransfoImpl().convertList(linijaMedjugradskaService.findAllOrderByPolazakAsc(stranica), LinijaMedjugradskaData.class);
//	}
	
	@RequestMapping(path = "pretraga/gost", method = RequestMethod.GET)
	public List<LinijaMedjugradskaData> pretragaGost(@RequestParam(name = "polazak") Date polazak,
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

		return new JTransfoImpl().convertList(linijaMedjugradskaService.pretraga(polazak, prevoznik, polaziste, odrediste, stranica), LinijaMedjugradskaData.class);
	}
	


}
