package library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import library.domain.Poruka;

@Repository
public interface PorukaRepository extends JpaRepository<Poruka, Long> {

}
