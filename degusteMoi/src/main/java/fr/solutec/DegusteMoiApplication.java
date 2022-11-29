package fr.solutec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.solutec.entities.Demande;
import fr.solutec.entities.Participation;
import fr.solutec.entities.Produit;
import fr.solutec.entities.Repas;
import fr.solutec.entities.User;
import fr.solutec.repository.DemandeRepository;
import fr.solutec.repository.ParticipationRepository;
import fr.solutec.repository.ProduitRepository;
import fr.solutec.repository.RepasRepository;
import fr.solutec.repository.UserRepository;



@SpringBootApplication
public class DegusteMoiApplication implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepos;
	@Autowired
	private ProduitRepository pRepos;
	@Autowired
	private UserRepository uRepos;
	@Autowired
	private DemandeRepository dRepos;
	@Autowired
	private RepasRepository rRepos;
	@Autowired
	private ParticipationRepository partRepos;
	
	public static void main(String[] args) {
		SpringApplication.run(DegusteMoiApplication.class, args);

		System.out.println("le projet t'as peur");

		System.out.println("lancement terminé");
		
		
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		User u1 = new User(null, "FARI", "Giraf", "FG", "girafarig", null, null, null, null);
		User u2 = new User(null, "LESBONZAFER", "Fredo", "FrLBZ", "Cat", null, null, null, null);
		User u3 = new User(null, "SKYWALKER", "Anakin", "JediMaster2156", "master", null, null, null, null);
		Produit p1 = new Produit(null, "Tomate");
		Produit p2 = new Produit(null, "Steak");
		Demande d1 = new Demande(null, u1, u2, true);
		Demande d2 = new Demande(null, u1, u3, true);
		Repas r1 = new Repas(null, u1, null, null, "repas");
		Participation pp1 = new Participation(null, u2, r1, false);
		
		
		pRepos.save(p1);
		pRepos.save(p2);
		uRepos.save(u1);
		uRepos.save(u2);
		uRepos.save(u3);
		dRepos.save(d1);
		dRepos.save(d2);
		rRepos.save(r1);
		partRepos.save(pp1);
		
	}

	
	
}
