package fr.solutec.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.entities.Recette;
import fr.solutec.repository.RecetteRepository;

@RestController @CrossOrigin("*")
public class RecetteRest {
	
	@Autowired
	private RecetteRepository recetteRepos;
	
	@GetMapping("recette")
	public Iterable<Recette> getAll() {
		return recetteRepos.findAll();
	}
	
	@GetMapping("recette/{sub}")
	public Iterable<Recette> getbySub(@PathVariable String sub){
		return recetteRepos.getBySubTitle(sub);
	}
	
	
	

}
