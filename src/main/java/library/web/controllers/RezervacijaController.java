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

import library.domain.LinijaMedjugradska;
import library.domain.Rezervacija;
import library.services.KorisnikService;
import library.services.RezervacijaService;

@RestController
@RequestMapping("/rezervacija")
@CrossOrigin(origins = "http://localhost:4200")
public class RezervacijaController {

	private RezervacijaService rezervacijaService;
	private KorisnikService korisnikService;
	
	@Autowired
	public RezervacijaController(RezervacijaService rezervacijaService, KorisnikService korisnikService) {
		this.rezervacijaService = rezervacijaService;
		this.korisnikService = korisnikService;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(method = RequestMethod.GET)
	public List<Rezervacija> findAll() {
		return rezervacijaService.findAll();
	}
	
	@PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
	@RequestMapping(method = RequestMethod.POST)
	public Rezervacija save(@RequestBody LinijaMedjugradska linija, @RequestParam(name = "username") String username) {
		Rezervacija rezervacija = new Rezervacija(linija, korisnikService.findOne(username));
		return rezervacijaService.save(rezervacija);
	}
	
	@PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
	@RequestMapping(path = "{korisnik}", method = RequestMethod.GET)
	public List<Rezervacija> findByKorisnik(@RequestParam(name = "username") String username) {
		return rezervacijaService.findByKorisnik(username);
	}
	
	@PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
	@RequestMapping(method = RequestMethod.DELETE)
	public void delete(@RequestParam(name="id") Long id) {
		rezervacijaService.delete(id);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(method = RequestMethod.PUT)
	public Rezervacija odobri(@RequestBody Long id) {
		Rezervacija rezervacija = rezervacijaService.findOne(id);
		rezervacija.setOdobren(true);
		return rezervacijaService.save(rezervacija);
	}
	
}
