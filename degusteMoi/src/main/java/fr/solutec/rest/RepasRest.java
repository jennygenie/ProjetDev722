package fr.solutec.rest;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.entities.Repas;
import fr.solutec.entities.User;
import fr.solutec.repository.RepasRepository;

@RestController
public class RepasRest {

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
}
