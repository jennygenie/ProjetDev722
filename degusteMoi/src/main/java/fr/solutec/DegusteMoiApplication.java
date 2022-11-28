package fr.solutec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.solutec.entities.Produit;
import fr.solutec.entities.User;
import fr.solutec.repository.ProduitRepository;
import fr.solutec.repository.UserRepository;



@SpringBootApplication
public class DegusteMoiApplication implements CommandLineRunner {
	
	@Autowired
	private ProduitRepository pRepos;
	@Autowired
	private UserRepository uRepos;
	
	public static void main(String[] args) {
		SpringApplication.run(DegusteMoiApplication.class, args);

		System.out.println("le projet t'as peur");

		System.out.println("lancement terminé");
		
		
	}

	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User();
		User u2 = new User();
		User u3 = new User();
		Produit p1 = new Produit(null, "Tomate");
		Produit p2 = new Produit(null, "Steak");
		
		pRepos.save(p1);
		pRepos.save(p2);
		uRepos.save(u1);
		uRepos.save(u2);
		uRepos.save(u3);
		
	}

	
	
}
