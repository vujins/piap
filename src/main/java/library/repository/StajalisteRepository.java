package library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import library.domain.Stajaliste;

@Repository
public interface StajalisteRepository extends JpaRepository<Stajaliste, Long> {
	
	public Stajaliste findByNaziv(String naziv);
}
