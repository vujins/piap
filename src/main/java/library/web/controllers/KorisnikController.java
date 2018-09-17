package library.web.controllers;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import library.domain.Korisnik;
import library.domain.Role;
import library.domain.Role.Tip;
import library.services.KorisnikService;

@RestController
@RequestMapping("/korisnik")
@CrossOrigin(origins = "http://localhost:4200")
public class KorisnikController {
	private KorisnikService korisnikService;

	@Autowired
	public KorisnikController(KorisnikService korisnikService) {
		this.korisnikService = korisnikService;
	}

	@RequestMapping(method = RequestMethod.POST)
	public Korisnik save(@RequestBody Korisnik user) {
		Role user_role = new Role();
		user_role.setId(new Long(1));
		user_role.setTip(Tip.ROLE_USER);
		Set<Role> tipovi = new HashSet<>();
		tipovi.add(user_role);
		user.setTipovi(tipovi);
	
		return korisnikService.save(user);
	}
	
	@RequestMapping(path = "postoji", method = RequestMethod.GET)
	public boolean postoji(@RequestParam(name = "username") String username) {
		if (korisnikService.findOne(username) != null) return true;
		else return false;
	}

	@PreAuthorize("isAuthenticated()")
	@RequestMapping(path = "login", method = RequestMethod.GET)
	public Collection<? extends GrantedAuthority> login() {

		return SecurityContextHolder.getContext().getAuthentication().getAuthorities();
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(path = "odobren", method = RequestMethod.GET)
	public List<Korisnik> findByOdobrenFlase() {
		return korisnikService.findByOdobrenFalse();
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(path = "odobri", method = RequestMethod.PUT)
	public Korisnik odobri(@RequestParam(name = "korisnik") String username) {
		Korisnik k = korisnikService.findOne(username);
		k.setOdobren(true);
		save(k);
		return k;
	}

}
