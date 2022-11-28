package fr.solutec.repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.Participation;
import fr.solutec.entities.Repas;
import fr.solutec.entities.User;

public interface RepasRepository extends CrudRepository<Repas, Long>{
	
	public Iterable<Repas> findAllByHote (User hote);
	@Query(value = "SELECT r FROM Repas r WHERE r.date > ?1")
	public List<Repas> getUpcomingRepas(LocalDate date);
	@Query(value = "SELECT r FROM Repas r WHERE r.date < ?1")
	public List<Repas> getPastRepas(LocalDate date);
}
