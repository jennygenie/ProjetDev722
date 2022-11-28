package fr.solutec.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.entities.Favori_vin;
import fr.solutec.entities.User;
import fr.solutec.repository.Favori_vinRepository;

@RestController
public class Favori_vinRest {
	
	@Autowired
	private Favori_vinRepository favRepos;
	
	@GetMapping("favori/vin")
	public Iterable<Favori_vin> getAll () {
		return favRepos.findAll();
	}
	
	@GetMapping("favori/vin/user/{user}")
	public Iterable<Favori_vin> getAllByUser (@PathVariable User user) {
		return favRepos.findAllByUser(user);
	}
	
	@PostMapping("favori/vin")
	public boolean addFavori (@RequestBody Favori_vin fav) {
		Iterable<Favori_vin> list = favRepos.findAllByUser(fav.getUser());
		for (Favori_vin favori : list) {
			if (favori.getVin().equals(fav.getVin())) {
				return false;
			}
		}
		favRepos.save(fav);
		return true;
	}
	
	@DeleteMapping("favori/vin/{id}")
	public boolean deleteFavori (@PathVariable Long id) {
		Optional<Favori_vin> fav = favRepos.findById(id);
		if (fav.isPresent()) {
			favRepos.deleteById(id);
			return true;
		}
		return false;
	}
}
