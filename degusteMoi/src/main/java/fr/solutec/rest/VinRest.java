package fr.solutec.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.entities.Recette;
import fr.solutec.entities.Vin;
import fr.solutec.repository.VinRepository;

@RestController @CrossOrigin("*")
public class VinRest {
	
	@Autowired
	private VinRepository vinRepos;

	@GetMapping("vin")
	public Iterable<Vin> getVins () {
		return vinRepos.findAll();
	}
	
	@GetMapping("vins/{id}")
	public Optional<Vin> getVinById (@PathVariable Long id) {
		return vinRepos.findById(id);
	}
	
	@GetMapping("vin/region/{reg}")
	public Iterable<Vin> getbyRegion(@PathVariable String reg){
		return vinRepos.getByRegion(reg);
		
	}
	
	@GetMapping("vin/{titre}")
	public Iterable<Vin> getbytitre(@PathVariable String titre){
		return vinRepos.getByTitle(titre);
	}
}
