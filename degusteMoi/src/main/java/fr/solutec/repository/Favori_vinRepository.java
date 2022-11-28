package fr.solutec.repository;

import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.Favori_vin;
import fr.solutec.entities.User;

public interface Favori_vinRepository extends CrudRepository<Favori_vin, Long>{
	
	public Iterable<Favori_vin> findAllByUser (User user);

}
