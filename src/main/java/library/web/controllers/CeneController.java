package library.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import library.domain.Cene.tip_karte;
import library.domain.Korisnik;
import library.domain.Korisnik.Zaposlen;
import library.services.CeneService;

@RestController
@RequestMapping("/cene")
@CrossOrigin(origins = "http://localhost:4200")
public class CeneController {

	private CeneService ceneService;

	@Autowired
	public CeneController(CeneService ceneService) {
		this.ceneService = ceneService;
	}

	@PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
	@RequestMapping(method = RequestMethod.GET)
	public int mesecnaCena(@RequestParam(name = "tip") tip_karte tip) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Zaposlen tip_zaposlenja = ((Korisnik) auth.getPrincipal()).getZaposlen();
		int cena = ceneService.findOne(tip).getCena();
		int popust = 0;

		switch (tip_zaposlenja) {
		case nezaposlen: {
			popust = 20;
			break;
		}
		case lice_sa_invaliditetom: {
			popust = 50;
			break;
		}
		case penzioner: {
			popust = 40;
			break;
		}
		case student: {
			popust = 30;
			break;
		}
		case zaposlen: {
			popust = 0;
			break;
		}
		default:
			break;
		}
		
		cena = cena - cena*popust/100;

		return cena;
	}

}
