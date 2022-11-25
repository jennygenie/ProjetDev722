package fr.solutec.rest;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.entities.Participation;
import fr.solutec.entities.User;
import fr.solutec.repository.ParticipationRepository;

@RestController
public class ParticipationRest {
	
	private ParticipationRepository prepos;

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
}
