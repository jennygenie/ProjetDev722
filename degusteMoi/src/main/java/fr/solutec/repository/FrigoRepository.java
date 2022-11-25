package fr.solutec.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.Frigo;
import fr.solutec.entities.User;

public interface FrigoRepository extends CrudRepository<Frigo, Long>{

	public Iterable<Frigo> findAllByUser (User user);
	public Optional<Frigo> findByUser (User user);
}
