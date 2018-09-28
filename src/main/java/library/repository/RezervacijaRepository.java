package library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import library.domain.Rezervacija;

@Repository
public interface RezervacijaRepository extends JpaRepository<Rezervacija, Long> {

	@Query("select r from Rezervacija r where r.korisnik.username = ?1 and r.odobren = true")
	public List<Rezervacija> findByKorisnik(String username);
}
