package fr.solutec.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.RecettesDetaillees;

public interface RecetteDetailleesRepository extends CrudRepository<RecettesDetaillees, Long> {

	@Query(value = "SELECT r From RecettesDetaillees r WHERE r.id = ?1 ")
	public Optional<RecettesDetaillees> getById(Long id);
}
