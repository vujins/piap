package library.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import library.domain.Vozac;
import library.services.VozacService;

@RestController
@RequestMapping("/vozac")
public class VozacController {

	private VozacService vozacService;

	@Autowired
	public VozacController(VozacService vozacService) {
		this.vozacService = vozacService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Vozac> findAll() {
		return vozacService.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Vozac save(@RequestBody Vozac vozac) {
		return vozacService.save(vozac);
	}
	
}
