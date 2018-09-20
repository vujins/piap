package library.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import library.domain.LinijaGradska;
import library.services.LinijaGradskaService;

@RestController
@RequestMapping("/gradska")
@CrossOrigin(origins = "http://localhost:4200")
public class LinijaGradskaController {
	private LinijaGradskaService linijaGradskaService;

	@Autowired
	public LinijaGradskaController(LinijaGradskaService linijaGradskaService) {
		this.linijaGradskaService = linijaGradskaService;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(method = RequestMethod.POST)
	public LinijaGradska save(@RequestBody LinijaGradska linijaGradska) {
		return linijaGradskaService.save(linijaGradska);
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
	@RequestMapping(method = RequestMethod.GET)
	public Page<LinijaGradska> findAll(@RequestParam(name = "stranica") int stranica) {
		return linijaGradskaService.findAll(new PageRequest(stranica, 10));
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(path = "{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id ) {
		linijaGradskaService.delete(id);
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
	@RequestMapping(path = "{pretraga}", method = RequestMethod.GET)
	public Page<LinijaGradska> pretraga(
			@RequestParam(name = "broj_linije", required = false) Integer broj_linije, 
			@RequestParam(name = "polaziste", required = false) String polaziste, 
			@RequestParam(name = "odrediste", required = false) String odrediste,
			@RequestParam(name = "stranica") int stranica) {
		return linijaGradskaService.pretraga(broj_linije, polaziste, odrediste, new PageRequest(stranica, 10));
	}
}
