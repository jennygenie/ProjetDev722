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

import fr.solutec.entities.Demande;
import fr.solutec.entities.Favori;
import fr.solutec.entities.User;
import fr.solutec.repository.FavoriRepository;

@RestController
public class FavoriRest {
	
	@Autowired
	private FavoriRepository favRepos;
	
	@GetMapping("favori")
	public Iterable<Favori> getAll () {
		return favRepos.findAll();
	}
	
	@GetMapping("favori/user/{user}")
	public Iterable<Favori> getAllByUser (@PathVariable User user) {
		return favRepos.findAllByUser(user);
	}
	
	@PostMapping("favori")
	public boolean addFavori (@RequestBody Favori fav) {
		Iterable<Favori> list = favRepos.findAllByUser(fav.getUser());
		for (Favori favori : list) {
			if (favori.getRecette().equals(fav.getRecette())) {
				return false;
			}
		}
		favRepos.save(fav);
		return true;
	}
	
	@DeleteMapping("favori/{id}")
	public boolean deleteFavori (@PathVariable Long id) {
		Optional<Favori> fav = favRepos.findById(id);
		if (fav.isPresent()) {
			favRepos.deleteById(id);
			return true;
		}
		return false;
	}
}
