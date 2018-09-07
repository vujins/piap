package library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import library.domain.LinijaMedjugradska;

@Repository
public interface LinijaMedjugradskaRepository extends JpaRepository<LinijaMedjugradska, Long> {
	

}
