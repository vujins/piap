package library.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import library.domain.Stajaliste;
import library.services.StajalisteService;

@RestController
@RequestMapping("/stajaliste")
@CrossOrigin(origins = "http://localhost:4200")
public class StajalisteController {
	private StajalisteService stajalisteService;

	@Autowired
	public StajalisteController(StajalisteService stajalisteService) {
		this.stajalisteService = stajalisteService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Stajaliste> findAll() {
		return stajalisteService.findAll();
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
	@RequestMapping(method = RequestMethod.POST)
	public Stajaliste save(@RequestBody Stajaliste stajaliste) {
		return stajalisteService.save(stajaliste);
	}
	
}
