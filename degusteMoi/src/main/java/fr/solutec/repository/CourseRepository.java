package fr.solutec.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.Course;
import fr.solutec.entities.User;

public interface CourseRepository extends CrudRepository<Course, Long>{
	
	public Iterable<Course> findAllByUser (User user);
	public Optional<Course> findByUser (User user);

}
