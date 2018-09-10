package library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import library.domain.Linija;
import library.domain.Stajaliste;

@Repository
public interface LinijaRepository extends JpaRepository<Linija, Long> {

}
