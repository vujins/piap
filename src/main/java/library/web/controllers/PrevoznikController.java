package library.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import library.domain.Prevoznik;
import library.services.PrevoznikService;

@RestController
@RequestMapping("/prevoznik")
@CrossOrigin(origins = "http://localhost:4200")
public class PrevoznikController {

	private PrevoznikService prevoznikService;

	@Autowired
	public PrevoznikController(PrevoznikService prevoznikService) {
		super();
		this.prevoznikService = prevoznikService;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(method = RequestMethod.POST)
	public Prevoznik save(@RequestBody Prevoznik prevoznik) {
		return prevoznikService.save(prevoznik);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(method = RequestMethod.GET)
	public List<Prevoznik> findAll() {
		return prevoznikService.findAll();
	}
	
}
