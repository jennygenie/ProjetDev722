package fr.solutec.repository;

import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.Favori;
import fr.solutec.entities.User;

public interface FavoriRepository extends CrudRepository<Favori, Long>{
	
	public Iterable<Favori> findAllByUser (User user);

}
