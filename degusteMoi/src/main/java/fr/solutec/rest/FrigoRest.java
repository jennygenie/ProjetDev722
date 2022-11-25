package fr.solutec.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.entities.Frigo;
import fr.solutec.entities.User;
import fr.solutec.repository.FrigoRepository;

@RestController
public class FrigoRest {
	
	@Autowired
	private FrigoRepository frigoRepos;

	@GetMapping("frigo")
	public Iterable<Frigo> getAll () {
		return frigoRepos.findAll();
	}
	
	@GetMapping("frigo/{user}")
	public Iterable<Frigo> getAllByUser(@PathVariable User user) {
		return frigoRepos.findAllByUser(user);
	}
	
	@PostMapping("frigo")
	public boolean addFrigo (@RequestBody Frigo frigo) {
		Iterable<Frigo> list = frigoRepos.findAllByUser(frigo.getUser());
		
		for (Frigo frigo2 : list) {
			if (frigo2.getProduit().equals(frigo.getProduit())) {
				frigo2.setQuantity(frigo2.getQuantity() + frigo.getQuantity());
				frigoRepos.save(frigo2);
				return true;
			}
		}
		
		frigoRepos.save(frigo);
		return true;
	}
	
	@DeleteMapping("frigo/{id}")
	public boolean deleteFrigo (@PathVariable Long id) {
		Optional<Frigo> f = frigoRepos.findById(id);
		if (f.isPresent()) {
			frigoRepos.deleteById(id);
			return true;
		}
		return false;
	}
}
