package fr.solutec;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.solutec.entities.Demande;
import fr.solutec.entities.User;
import fr.solutec.repository.DemandeRepository;
import fr.solutec.repository.UserRepository;


@SpringBootApplication
public class DegusteMoiApplication implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepos;
	@Autowired private DemandeRepository demandeRepos;

	public static void main(String[] args) {
		SpringApplication.run(DegusteMoiApplication.class, args);

		System.out.println("le projet t'as peur");

		System.out.println("lancement terminé");
		
		
	}

	@Override
	public void run(String... args) throws Exception {

		/*User u1 = new User(null, "Siwertz", "Marius", "siwertzm", "123");
		User u2 = new User(null, "Bardin", "Marion", "mbardin", "456");
		User u3 = new User(null, "Scoliege", "Paul", "poloscolo", "789");
		User u4 = new User(null, "aa", "aa", "aa", "aa");
		userRepos.save(u1);
		userRepos.save(u2);
		userRepos.save(u3);
		userRepos.save(u4);
		
		

		Demande d1 = new Demande(null, u1, u2, false);
		demandeRepos.save(d1);

		Demande d1 = new Demande(null, u1, u2, true);
		Demande d2 = new Demande(null, u2, u3, true);
		Demande d3 = new Demande(null, u2, u4, true);
		demandeRepos.save(d1);
		demandeRepos.save(d2);
		demandeRepos.save(d3);*/
		
	}

	
	
}
