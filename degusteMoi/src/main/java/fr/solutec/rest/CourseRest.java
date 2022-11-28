package fr.solutec.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.entities.Course;
import fr.solutec.entities.User;
import fr.solutec.repository.CourseRepository;

@RestController @CrossOrigin("*")
public class CourseRest {
	
	@Autowired
	private CourseRepository courseRepos;

	@GetMapping("course")
	public Iterable<Course> getAll () {
		return courseRepos.findAll();
	}
	
	@GetMapping("course/{user}")
	public Iterable<Course> getAllByUser(@PathVariable User user) {
		return courseRepos.findAllByUser(user);
	}
	
	@PostMapping("course")
	public boolean addCourse (@RequestBody Course course) {
		Iterable<Course> list = courseRepos.findAllByUser(course.getUser());
		
		for (Course course2 : list) {
			if (course2.getProduit().equals(course.getProduit())) {
				course2.setQuantity(course2.getQuantity() + course.getQuantity());
				courseRepos.save(course2);
				return true;
			}
		}
		
		courseRepos.save(course);
		return true;
	}
	
	@DeleteMapping("course/{id}")
	public boolean deleteFrigo (@PathVariable Long id) {
		Optional<Course> f = courseRepos.findById(id);
		if (f.isPresent()) {
			courseRepos.deleteById(id);
			return true;
		}
		return false;
	}
}
