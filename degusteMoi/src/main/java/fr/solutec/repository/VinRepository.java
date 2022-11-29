package fr.solutec.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.Recette;
import fr.solutec.entities.Vin;

public interface VinRepository extends CrudRepository<Vin, Long>{
	
	public Optional<Vin> findById (Long id);
	
	@Query(value = "SELECT v From Vin v WHERE v.region like %?1% ")
	public Iterable<Vin> getByRegion(String sub);
	
	@Query(value = "SELECT v From Vin v WHERE v.titre like %?1% ")
	public Iterable<Vin> getByTitle(String titre);
}
