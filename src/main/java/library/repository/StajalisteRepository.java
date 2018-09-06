package library.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import library.domain.Linija;
import library.domain.Stajaliste;

@Repository
public interface StajalisteRepository extends JpaRepository<Stajaliste, Long> {
	
	@Query("select l from Linija l where ?1 in (select id from l.stajalisteSet)")
	//@Query(value = "select linija_id from linija_stajaliste where stajaliste_id = ?1", nativeQuery = true)
	public Set<Linija> findLinijaFromStajaliste(String stajaliste_id);
	
	
}
