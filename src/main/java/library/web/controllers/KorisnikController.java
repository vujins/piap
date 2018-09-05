package library.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import library.domain.Korisnik;
import library.services.KorisnikService;

@RestController
@RequestMapping("/korisnik")
public class KorisnikController {
	private KorisnikService korisnikService;

	@Autowired
	public KorisnikController(KorisnikService korisnikService) {
		this.korisnikService = korisnikService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Korisnik> findAll() {
		return korisnikService.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Korisnik save(@RequestBody Korisnik user) {
		return korisnikService.save(user);
	}
	
	@RequestMapping(path = "{username}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("username") String username) {
		korisnikService.delete(username);
	}
	
}
