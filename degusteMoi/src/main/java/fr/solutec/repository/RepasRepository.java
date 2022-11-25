package fr.solutec.repository;

import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.Repas;
import fr.solutec.entities.User;

public interface RepasRepository extends CrudRepository<Repas, Long>{
	
	public Iterable<Repas> findAllByHote (User hote);
}
