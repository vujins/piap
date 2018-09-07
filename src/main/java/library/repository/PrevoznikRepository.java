package library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import library.domain.Prevoznik;

@Repository
public interface PrevoznikRepository extends JpaRepository<Prevoznik, Long> {

	@Query("select p from Prevoznik p where naziv = ?1")
	public Prevoznik findFromNaziv(String naziv);
	
}
