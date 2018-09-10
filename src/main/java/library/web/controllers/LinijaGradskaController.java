package library.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
public class LinijaGradskaController {
	private LinijaGradskaService linijaGradskaService;

	@Autowired
	public LinijaGradskaController(LinijaGradskaService linijaGradskaService) {
		this.linijaGradskaService = linijaGradskaService;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public LinijaGradska save(@RequestBody LinijaGradska linijaGradska) {
		return linijaGradskaService.save(linijaGradska);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<LinijaGradska> findAll() {
		return linijaGradskaService.findAll();
	}
	
	@RequestMapping(path = "{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id ) {
		linijaGradskaService.delete(id);
	}
	
	@RequestMapping(path = "{pretraga}", method = RequestMethod.GET)
	public List<LinijaGradska> pretraga(
			@RequestParam(name = "broj_linije", required = false) Integer broj_linije, 
			@RequestParam(name = "polaziste", required = false) String polaziste, 
			@RequestParam(name = "odrediste", required = false) String odrediste) {
		return linijaGradskaService.pretraga(broj_linije, polaziste, odrediste);
	}
}
