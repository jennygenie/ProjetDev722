package fr.solutec.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
	public Optional<User> findByLoginAndMdp(String login, String mdp);
	public Optional<User> findById (Long id);
	
	@Query(value = "SELECT u From User u WHERE u.login = ?1 AND u.mdp = ?2")
	public Optional<User> getByConnexion(String login, String mdp);
	
	@Query(value = "SELECT u From User u WHERE u.login like ?1%")
	public Iterable<User> getBylogin(String login);
	
	

}
