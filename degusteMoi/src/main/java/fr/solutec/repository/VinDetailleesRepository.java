package fr.solutec.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import fr.solutec.entities.VinDetaillees;

public interface VinDetailleesRepository extends CrudRepository<VinDetaillees, Long> {

	@Query(value = "SELECT v From VinDetaillees v WHERE v.id = ?1 ")
	public Optional<VinDetaillees> getById(Long id);
}
	
	


