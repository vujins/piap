package library.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import library.domain.LinijaMedjugradska;

@Repository
public interface LinijaMedjugradskaRepository extends JpaRepository<LinijaMedjugradska, Long> {
	
	@Query("select m from LinijaMedjugradska m "
			+ "where "
			+ "m.polazak > ?1 and "
			+ "(m.prevoznik.naziv = ?2 or ?2 is null) and "
			+ "(?3 in (select l.polaziste.naziv from m.medjulinije l) or ?3 is null) and "
			+ "(?4 in (select l.odrediste.naziv from m.medjulinije l) or ?4 is null)"
			+ "order by polazak asc")
	public List<LinijaMedjugradska> pretraga(Date polazak, String prevoznik, String polaziste, String odrediste);
	
}
