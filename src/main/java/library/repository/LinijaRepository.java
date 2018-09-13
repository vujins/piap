package library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import library.domain.Linija;

@Repository
public interface LinijaRepository extends JpaRepository<Linija, Long> {

}
