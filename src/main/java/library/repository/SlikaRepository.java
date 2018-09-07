package library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import library.domain.Slika;

@Repository
public interface SlikaRepository extends JpaRepository<Slika, Long> {

}
