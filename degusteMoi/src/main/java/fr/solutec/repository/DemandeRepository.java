package fr.solutec.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.Demande;
import fr.solutec.entities.User;

public interface DemandeRepository extends CrudRepository<Demande, Long>{
	
	public Optional<Demande> findById (Long id);
	public Iterable<Demande> findAllByEnvoyeur (User u);
	public Iterable<Demande> findAllByReceveur (User u);
	public Iterable<Demande> findAllByEnvoyeurAndValide(User u, boolean v);
	

}
