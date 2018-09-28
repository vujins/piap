package library.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import library.domain.Vozac;
import library.services.VozacService;

@RestController
@RequestMapping("/vozac")
@CrossOrigin(origins = "http://localhost:4200")
public class VozacController {

	private VozacService vozacService;

	@Autowired
	public VozacController(VozacService vozacService) {
		this.vozacService = vozacService;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(method = RequestMethod.GET)
	public List<Vozac> findAll() {
		return vozacService.findAll();
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(method = RequestMethod.POST)
	public Vozac save(@RequestBody Vozac vozac) {
		return vozacService.save(vozac);
	}
	
}
