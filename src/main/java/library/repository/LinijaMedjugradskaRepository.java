package library.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import library.domain.Korisnik;
import library.domain.LinijaMedjugradska;

@Repository
public interface LinijaMedjugradskaRepository extends JpaRepository<LinijaMedjugradska, Long> {
	
	@Query("")
	public Set<Korisnik> findKorisnikForLinijaMedjugradska(String id);
}
