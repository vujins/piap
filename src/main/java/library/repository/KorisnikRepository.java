package library.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import library.domain.Korisnik;

@Repository
public interface KorisnikRepository extends JpaRepository<Korisnik, String> {

	public Korisnik findByUsername(String username);
	
	public List<Korisnik> findByOdobrenFalse();
}
