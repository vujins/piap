package library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import library.domain.Korisnik;

@Repository
public interface KorisnikRepository extends JpaRepository<Korisnik, String> {

	
}
