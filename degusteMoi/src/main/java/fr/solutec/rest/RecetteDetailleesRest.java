package fr.solutec.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.entities.Recette;
import fr.solutec.entities.RecettesDetaillees;
import fr.solutec.repository.RecetteDetailleesRepository;

@RestController @CrossOrigin("*")
public class RecetteDetailleesRest {
	
	@Autowired
	private RecetteDetailleesRepository recetteDetailRepos;
	
	@GetMapping("recette-detail")
	public Iterable<RecettesDetaillees> getAll() {
		return recetteDetailRepos.findAll();
	}
	
	@GetMapping("recette-detail/{id}")
	public Optional<RecettesDetaillees> getbySub(@PathVariable Long id){
		return recetteDetailRepos.getById(id);
	}
	

}
