package library.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import library.domain.Korisnik;
import library.domain.MesecnaKarta;
import library.services.KorisnikService;
import library.services.MesecnaKartaService;

@RestController
@RequestMapping("/mesecnakarta")
@CrossOrigin(origins = "http://localhost:4200")
public class MesecnaKartaController {

	private MesecnaKartaService mesecnaKartaService;
	private KorisnikService korisnikService;

	@Autowired
	public MesecnaKartaController(MesecnaKartaService mesecnaKartaService, KorisnikService korisnikService) {
		this.mesecnaKartaService = mesecnaKartaService;
		this.korisnikService = korisnikService;
	}

	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
	@RequestMapping(method = RequestMethod.POST)
	public MesecnaKarta save(@RequestBody MesecnaKarta mesecnaKarta) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Korisnik korisnik = korisnikService.findOne(((Korisnik) auth.getPrincipal()).getUsername());
		mesecnaKarta.setKorisnik(korisnik);
		
		return mesecnaKartaService.save(mesecnaKarta);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(method = RequestMethod.PUT)
	public MesecnaKarta odobri(@RequestBody Long id) {

		MesecnaKarta m = mesecnaKartaService.findOne(id);
		m.setOdobren(true);

		return mesecnaKartaService.save(m);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(method = RequestMethod.GET)
	public List<MesecnaKarta> findAll() {
		return mesecnaKartaService.findAll();
	}

	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
	@RequestMapping(path="{odobrene}", method = RequestMethod.GET)
	public List<MesecnaKarta> findByUsername() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = ((Korisnik) auth.getPrincipal()).getUsername();
		return mesecnaKartaService.findByUsername(username);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(method = RequestMethod.DELETE)
	public void delete(@RequestParam(name="id") Long id) {
		mesecnaKartaService.delete(id);
	}
	
}
