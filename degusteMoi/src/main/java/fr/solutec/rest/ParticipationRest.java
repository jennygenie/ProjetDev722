package fr.solutec.rest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.entities.Demande;
import fr.solutec.entities.Participation;
import fr.solutec.entities.Repas;
import fr.solutec.entities.User;
import fr.solutec.repository.ParticipationRepository;
import fr.solutec.repository.RepasRepository;
import fr.solutec.repository.UserRepository;

@RestController @CrossOrigin("*")
public class ParticipationRest {
	
	@Autowired
	private ParticipationRepository prepos;
	@Autowired
	private RepasRepository repasRepos;
	@Autowired
	private UserRepository urepos;

	@GetMapping("participation")
	public Iterable<Participation> getAllParticipation () {
		return prepos.findAll();
	}
	
	@GetMapping("participation/{id}")
	public Optional<Participation> getById (@PathVariable Long id) {
		return prepos.findById(id);
	}
	
	@GetMapping("participation/user/{user}")
	public Iterable<Participation> getByUser (@PathVariable User user) {
		return prepos.findByUser(user);
	}
	
	@GetMapping("participation/accepted/{user}")
	public Iterable<Participation> getAccepted (@PathVariable User user) {
		return prepos.findByUserAndAccept(user, true);
	}
	
	@PatchMapping("participation/accept/{id}")
	public boolean acceptParticipation (@PathVariable Long id) {
		Optional<Participation> part = prepos.findById(id);
		if (! part.get().isAccept() || part.isPresent()) {
			Participation p = part.get();
			p.setAccept(true);
			prepos.save(p);
			return true;
		}
		return false;
	}
	
	@PostMapping("participation")
	public Participation createParticipation (@RequestBody Participation p) {
		return prepos.save(p);
	}
	
	@DeleteMapping("participation/reject/{id}")
	public boolean deleteParticipation (@PathVariable Long id) {
		Optional<Participation> part = prepos.findById(id);
		if (! part.get().isAccept() || part.isPresent()) {
			prepos.deleteById(id);
			return true;
		}
		return false;
	}
	
	@GetMapping("participation/future/{id}")
	public List<Participation> getUpcomingRepas (@PathVariable Long id) {
		LocalDate date = LocalDate.now();
		List<Repas> repasList = repasRepos.getUpcomingRepas(date);
		List<Participation> result = new ArrayList<>();
		
		for (Repas repas : repasList) {
			List<Participation> addition = prepos.findByRepasAndUserAndAccept(repas, urepos.findById(id).get(), true);
			for (Participation participation : addition) {
				result.add(participation);
			}
		}
		
		return result;
	}
}
