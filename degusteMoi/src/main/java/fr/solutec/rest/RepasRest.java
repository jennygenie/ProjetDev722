package fr.solutec.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.entities.Repas;
import fr.solutec.entities.User;
import fr.solutec.repository.RepasRepository;

@RestController @CrossOrigin("*")
public class RepasRest {
	
	@Autowired
	private RepasRepository repasRepos;
	
	@GetMapping("repas")
	public Iterable<Repas> getAllRepas () {
		return repasRepos.findAll();
	}
	
	@GetMapping("repas/hote/{hote}")
	public Iterable<Repas> getByHote (@PathVariable User hote) {
		return repasRepos.findAllByHote(hote);
	}
	
	@GetMapping("repas/id/{id}")
	public Optional<Repas> getById (@PathVariable Long id) {
		return repasRepos.findById(id);
	}
	
	@PostMapping("repas")
	public Repas createRepas (@RequestBody Repas r) {
		return repasRepos.save(r);
	}
}
