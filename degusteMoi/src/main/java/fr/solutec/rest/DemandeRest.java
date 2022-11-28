package fr.solutec.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.entities.Demande;
import fr.solutec.entities.User;
import fr.solutec.repository.DemandeRepository;
import fr.solutec.repository.UserRepository;

@RestController
public class DemandeRest {
	
	@Autowired
	private DemandeRepository demanderepos;
	@Autowired
	private UserRepository userRepos;
	
	@GetMapping("demande")
	private Iterable<Demande> getAll() {
		return demanderepos.findAll();
	}
	
	@GetMapping("demande/envoyeur/{user}")
	private Iterable<Demande> getAllByEnvoyeur(@PathVariable User user) {
		return demanderepos.findAllByEnvoyeur(user);
	}
	
	@GetMapping("demande/receveur/{user}")
	private Iterable<Demande> getAllByReceveur(@PathVariable User user) {
		return demanderepos.findAllByReceveur(user);
	}
	
	@PostMapping("demande")
	private boolean createDemande(@RequestBody Demande d) {
		for (Demande demande : demanderepos.findAllByEnvoyeur(d.getEnvoyeur())) {
			if (demande.getReceveur().equals(d.getReceveur())) {
				return false;
			}
		}
		for (Demande demande2 : demanderepos.findAllByReceveur(d.getEnvoyeur())) {
			if (demande2.getEnvoyeur().equals(d.getReceveur())) {
				return false;
			}
		}
		demanderepos.save(d);	
		return true;
	}
	
	@PatchMapping("demande/accept/{u}/{id}")
	private boolean acceptDemande(@PathVariable User u, @PathVariable Long id) {
		Optional<Demande> od = demanderepos.findById(id);
		if (od.isPresent()) {
			Demande d = od.get();
			if (d.getReceveur().equals(u)) {
				d.setValide(true);
				demanderepos.save(d);
				return true;
			}
		}
		return false;
	}
	
	@DeleteMapping ("demande/reject/{id}")
	private boolean rejectDemande(@PathVariable Long id) {
		Optional<Demande> od = demanderepos.findById(id);
		if (od.isPresent()) {
			demanderepos.deleteById(id);
			return true;
		}
		return false;
	}
	
	@GetMapping ("demande/nonvalide/{u}")
	private Iterable<Demande> getDemandes (@PathVariable User u) {
		return demanderepos.findAllByEnvoyeurAndValide(u, false);
	}
}
