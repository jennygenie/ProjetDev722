package fr.solutec.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.entities.Demande;
import fr.solutec.repository.DemandeRepository;

@RestController
public class DemandeRest {
	
	@Autowired
	private DemandeRepository demanderepos;
	
	@GetMapping("demande")
	private Iterable<Demande> getAll() {
		return demanderepos.findAll();
	}
	
	@PostMapping("demande")
	private boolean createDemande(@RequestBody Demande d) {
		for (Demande demande : demanderepos.findByEnvoyeur(d.getEnvoyeur())) {
			if (demande.getReceveur().equals(d.getReceveur())) {
				return false;
			}
		}
		for (Demande demande2 : demanderepos.findByReceveur(d.getEnvoyeur())) {
			if (demande2.getEnvoyeur().equals(d.getReceveur())) {
				return false;
			}
		}
		demanderepos.save(d);	
		return true;
	}
	
	@PatchMapping("demande/accept/{id}")
	private boolean acceptDemande(@PathVariable Long id) {
		Optional<Demande> od = demanderepos.findById(id);
		if (od.isPresent()) {
			Demande d = od.get();
			d.setValide(true);
			demanderepos.save(d);
			return true;
		}
		return false;
	}
}