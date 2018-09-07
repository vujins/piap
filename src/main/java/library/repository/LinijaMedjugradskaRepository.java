package library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import library.domain.Linija;
import library.domain.LinijaMedjugradska;
import library.domain.Prevoznik;

@Repository
public interface LinijaMedjugradskaRepository extends JpaRepository<LinijaMedjugradska, Long> {
	
	//select * from medjugradska where prevoznik_id in (select id from prevoznik where naziv = 'Autoprevoz Kikinda');
	@Query("select m from LinijaMedjugradska m where m.prevoznik = ?1")
	public List<LinijaMedjugradska> findFromPrevoznik(Prevoznik prevoznik);
	
	@Query("select m from LinijaMedjugradska m where ?1 in m.medjulinije")
	public List<LinijaMedjugradska> findFromLinija(Linija linija);
}
