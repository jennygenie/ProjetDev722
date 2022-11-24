package fr.solutec.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.entities.User;
import fr.solutec.repository.UserRepository;

@RestController
public class UserRest {

		@Autowired
		private UserRepository userRepos;
		
		@GetMapping("user")
		public Iterable<User> getAll() {
			return userRepos.findAll();
		}
		
		@PostMapping("login")
		public Optional<User> getByLoginAndId(@RequestBody User u){
			return userRepos.findByLoginAndMdp(u.getLogin(), u.getMdp());
		}
		
		@PostMapping("user")
		public User saveUser(@RequestBody User u) {
			return userRepos.save(u);
		}
		
		

}