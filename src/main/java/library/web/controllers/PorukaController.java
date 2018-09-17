package library.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import library.domain.Korisnik;
import library.domain.Poruka;
import library.services.KorisnikService;
import library.services.PorukaService;

@RestController
@RequestMapping("/poruka")
@CrossOrigin(origins = "http://localhost:4200")
public class PorukaController {

	private PorukaService porukaService;
	private KorisnikService korisnikService;

	@Autowired
	public PorukaController(PorukaService porukaService, KorisnikService korisnikService) {
		super();
		this.porukaService = porukaService;
		this.korisnikService = korisnikService;
	}

	@RequestMapping(method = RequestMethod.POST)
	public Poruka save(@RequestBody Poruka poruka) {
		
		List<Korisnik> korisnici = korisnikService.findAll();

		for (Korisnik korisnik : korisnici) {
			korisnik.getPoruke().add(poruka);
		}

		return porukaService.save(poruka);
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Poruka> findAll() {
		return porukaService.findAll();
	}

}
