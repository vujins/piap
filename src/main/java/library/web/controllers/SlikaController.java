package library.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import library.domain.Slika;
import library.services.SlikaService;

@RestController
@RequestMapping("/slika")
public class SlikaController {
	
	private SlikaService slikaService;

	@Autowired
	public SlikaController(SlikaService slikaService) {
		this.slikaService = slikaService;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Slika save(@RequestBody Slika slika) {
		return slikaService.save(slika);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Slika> findAll() {
		return slikaService.findAll();
	}
}
