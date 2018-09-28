package library.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import library.domain.Linija;
import library.services.LinijaService;

@RestController
@RequestMapping("/linija")
@CrossOrigin(origins = "http://localhost:4200")
public class LinijaController {
	
	private LinijaService linijaService;

	@Autowired
	public LinijaController(LinijaService linijaService) {
		super();
		this.linijaService = linijaService;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(method = RequestMethod.POST)
	public Linija save(@RequestBody Linija linija) {
		return linijaService.save(linija);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(method = RequestMethod.GET)
	public List<Linija> findAll() {
		return linijaService.findAll();
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(path = "pronadji",method = RequestMethod.GET)
	public Linija findByPolazisteAndOdrediste(
			@RequestParam(name = "polaziste") String polazisteNaziv, 
			@RequestParam(name = "odrediste") String odredisteNaziv
			) {

		
		return linijaService.findByPolazisteAndOdrediste(polazisteNaziv, odredisteNaziv);
	}
	
}
