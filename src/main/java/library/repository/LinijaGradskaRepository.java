package library.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import library.domain.LinijaGradska;

@Repository
public interface LinijaGradskaRepository extends JpaRepository<LinijaGradska, Long> {

	@Query("select g from LinijaGradska g "
			+ "where "
			+ "(broj_linije = ?1 or ?1 is null) and "
			+ "(?2 in (select l.polaziste.naziv from g.medjulinije l) or ?2 is null) and "
			+ "(?3 in (select l.odrediste.naziv from g.medjulinije l) or ?3 is null)")
	public Page<LinijaGradska> pretraga(Integer broj_linije, String polaziste, String odrediste, Pageable page);
	
	public Page<LinijaGradska> findAll(Pageable page);
}
