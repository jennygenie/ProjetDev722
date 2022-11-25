package fr.solutec.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.entities.Demande;
import fr.solutec.entities.User;
import fr.solutec.repository.DemandeRepository;
import fr.solutec.repository.UserRepository;

@RestController @CrossOrigin("*")
public class UserRest {

		@Autowired
		private UserRepository userRepos;
		@Autowired
		private DemandeRepository demandeRepos;
		
		@GetMapping("user")
		public Iterable<User> getAll() {
			return userRepos.findAll();
		}
		
		@GetMapping("user/{login}")
		public Iterable<User> getByLogin(@PathVariable String login){
			return userRepos.getBylogin(login);
			
		}
		
		@PostMapping("login")
		public Optional<User> getByLoginAndId(@RequestBody User u){
			return userRepos.findByLoginAndMdp(u.getLogin(), u.getMdp());
		}
		
		@PostMapping("user")
		public User saveUser(@RequestBody User u) {
			return userRepos.save(u);
		}
		
		@GetMapping("user/friends/{id}")
		public List<User> getFriends (@PathVariable Long id) {
			Optional<User> u = userRepos.findById(id);
			List<User> result = new ArrayList<>();
			if (u.isPresent()) {
				User user = u.get();
				Iterable<Demande> demandes = demandeRepos.findByEnvoyeur(user);
				for (Demande demande : demandes) {
					result.add(demande.getReceveur());
				}
				Iterable<Demande> demandes2 = demandeRepos.findByReceveur(user);
				for (Demande demande : demandes2) {
					result.add(demande.getEnvoyeur());
				}
				return result;
			}
			return null;
		}
		
		@GetMapping("user/friends/friends/{id}")
		public List<User> getFriendsFriends (@PathVariable Long id) {
			List<User> friends = getFriends(id);
			friends.add(userRepos.findById(id).get());
			List<User> result = new ArrayList<>();
			for (User user : friends) {
				List<User> friendsFriends = getFriends(user.getId());
				for (User user2 : friendsFriends) {
					if (! friends.contains(user2) || result.contains(user2)) {
						result.add(user2);
					}
				}
			}
			return result;
		}
		
		

}