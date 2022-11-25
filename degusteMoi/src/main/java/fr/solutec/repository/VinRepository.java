package fr.solutec.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.Vin;

public interface VinRepository extends CrudRepository<Vin, Long>{
	
	public Optional<Vin> findById (Long id);
}
