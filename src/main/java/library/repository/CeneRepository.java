package library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import library.domain.Cene;
import library.domain.Cene.tip_karte;

@Repository
public interface CeneRepository extends JpaRepository<Cene, tip_karte> {
	
}
