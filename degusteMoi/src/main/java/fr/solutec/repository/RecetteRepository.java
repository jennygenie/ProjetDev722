package fr.solutec.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.Recette;

public interface RecetteRepository extends CrudRepository<Recette, Long>{
	
	@Query(value = "SELECT r From Recette r WHERE r.sub_title like %?1% ")
	public Iterable<Recette> getBySubTitle(String sub);
	
	@Query(value = "SELECT r From Recette r WHERE r.titre like %?1% ")
	public Iterable<Recette> getByTitle(String titre);
	
	@Query(value = "SELECT r From Recette r WHERE r.id= ?1 ")
	public Recette getById(Long id);
	

	

}
