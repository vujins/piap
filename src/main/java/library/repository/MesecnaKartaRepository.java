package library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import library.domain.MesecnaKarta;

@Repository
public interface MesecnaKartaRepository extends JpaRepository<MesecnaKarta, Long> {

	@Query("select m from MesecnaKarta m where m.korisnik.username = ?1 and odobren = true")
	public List<MesecnaKarta> findByUsername(String username);
}
