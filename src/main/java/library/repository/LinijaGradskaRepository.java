package library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import library.domain.LinijaGradska;

@Repository
public interface LinijaGradskaRepository extends JpaRepository<LinijaGradska, Long> {

}
