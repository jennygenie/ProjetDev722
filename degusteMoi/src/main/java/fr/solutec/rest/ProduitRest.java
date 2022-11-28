package fr.solutec.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.entities.Produit;
import fr.solutec.repository.ProduitRepository;

@RestController @CrossOrigin("*")
public class ProduitRest {
	
	@Autowired
	private ProduitRepository pRepos;
	
	@GetMapping("/produit")
	public Iterable<Produit> getAllProduits () {
		return pRepos.findAll();
	}
}
