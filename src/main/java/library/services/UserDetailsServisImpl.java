package library.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import library.domain.Korisnik;
import library.repository.KorisnikRepository;

@Service("customUserDetailsService")
public class UserDetailsServisImpl implements UserDetailsService {

	private KorisnikRepository korisnikRepository;
	
	@Autowired
	public UserDetailsServisImpl(KorisnikRepository korisnikRepository) {
		this.korisnikRepository = korisnikRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Korisnik korisnik = korisnikRepository.findByUsername(username);

		if (korisnik != null) {
			return korisnik;
		} else {
			throw new UsernameNotFoundException("Korisnik nije pronadjen");
		}
	}

}
