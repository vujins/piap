package library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import library.domain.Staje;
import library.domain.relation.StajalisteLinijaRelation;

@Repository
public interface StajeRepository extends JpaRepository<Staje, StajalisteLinijaRelation> {

}
