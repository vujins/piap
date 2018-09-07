package library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import library.domain.Linija;
import library.domain.Stajaliste;

@Repository
public interface LinijaRepository extends JpaRepository<Linija, Long> {

	@Query("select l from Linija l where odrediste = ?1")
	public Linija findOdredisteFromStajaliste(Stajaliste stajalaiste);

	@Query("select l from Linija l where polaziste = ?1")
	public Linija findPolazisteFromStajaliste(Stajaliste stajaliste);
}
