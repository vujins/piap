package library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import library.domain.Vozac;

@Repository
public interface VozacRepository extends JpaRepository<Vozac, Long> {

}
