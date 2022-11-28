package fr.solutec.rest;


import java.util.ArrayList;
import java.util.List;

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
	
	@GetMapping("recette/id/{id}")
	public Recette getbyId(@PathVariable Long id){
		return recetteRepos.getById(id);
	}
	
	@GetMapping("recette/titre/{titre}")
	public Iterable<Recette> getbytitre(@PathVariable String titre){
		return recetteRepos.getByTitle(titre);
	}
	
	@GetMapping("recette/random")
	public Recette randomRecette () {
		Iterable<Recette> recettes = recetteRepos.findAll();
		List<Recette> list = new ArrayList<>();
		int length = 0;
		for (Recette recette : recettes) {
			list.add(recette);
			length += 1;
		}
		double rand = Math.floor(Math.random()*length+1);
		return list.get((int) rand);
		
	}
	
	

}
