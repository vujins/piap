package library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import library.domain.Autobus;

@Repository
public interface AutobusRepository extends JpaRepository<Autobus, Long> {

}
