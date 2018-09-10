package library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import library.domain.Prevoznik;

@Repository
public interface PrevoznikRepository extends JpaRepository<Prevoznik, Long> {

}
