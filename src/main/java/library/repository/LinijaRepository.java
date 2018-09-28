package library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import library.domain.Linija;

@Repository
public interface LinijaRepository extends JpaRepository<Linija, Long> {

	@Query("select l from Linija l where l.polaziste.naziv = ?1 and l.odrediste.naziv = ?2")
	public Linija findByPolazisteAndOdrediste(String polaziste, String odrediste);
	
}
