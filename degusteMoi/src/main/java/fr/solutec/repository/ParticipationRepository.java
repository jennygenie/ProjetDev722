package fr.solutec.repository;



import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.Participation;
import fr.solutec.entities.Repas;
import fr.solutec.entities.User;

public interface ParticipationRepository extends CrudRepository<Participation, Long>{
	
	public Iterable<Participation> findByUser (User user);
	public Iterable<Participation> findByUserAndAccept (User user, boolean accept);
	public List<Participation> findByRepasAndUserAndAccept (Repas repas, User user, boolean accept);
	
}
