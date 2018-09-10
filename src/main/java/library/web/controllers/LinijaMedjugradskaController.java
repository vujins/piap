package library.web.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

	@RequestMapping(method = RequestMethod.GET)
	public List<LinijaMedjugradska> findAll() {
		// TODO vrati jtransfo objekte ako korisnik nije ulogovan, ako je gost samo 10 najskorijih
		return linijaMedjugradskaService.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public LinijaMedjugradska save(@RequestBody LinijaMedjugradska linijaMedjugradska) {
		return linijaMedjugradskaService.save(linijaMedjugradska);
	}


	@RequestMapping(path = "{pretraga}", method = RequestMethod.GET)
	public List<LinijaMedjugradska> pretraga(@RequestParam(name = "polazak") Date polazak,
			@RequestParam(name = "prevoznik", required = false) String prevoznik,
			@RequestParam(name = "polaziste", required = false) String polaziste,
			@RequestParam(name = "odrediste", required = false) String odrediste) {

		// TODO vrati jtransfo objekte ako korisnik nije ulogovan

//		if (ulogovan) {
//
//		} else {
//
//		}

		return linijaMedjugradskaService.pretraga(polazak, prevoznik, polaziste, odrediste);
	}

}
