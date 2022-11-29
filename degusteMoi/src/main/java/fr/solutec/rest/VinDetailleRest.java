package fr.solutec.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import fr.solutec.entities.VinDetaillees;
import fr.solutec.repository.VinDetailleesRepository;

@RestController @CrossOrigin("*")
public class VinDetailleRest {
	@Autowired
	private VinDetailleesRepository vinDetailRepos;
	
	@GetMapping("vin-detail")
	public Iterable<VinDetaillees> getAll() {
		return vinDetailRepos.findAll();
	}
	
	@GetMapping("vin-detail/{id}")
	public Optional<VinDetaillees> getbySub(@PathVariable Long id){
		return vinDetailRepos.getById(id);
	}

}
