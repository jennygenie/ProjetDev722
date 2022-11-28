package fr.solutec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.solutec.entities.User;
import fr.solutec.repository.ProduitRepository;
import fr.solutec.repository.UserRepository;



@SpringBootApplication
public class DegusteMoiApplication implements CommandLineRunner {
	
	@Autowired
	private ProduitRepository produitRepos;
	
	@Autowired
	private UserRepository userRepos;
	
	public static void main(String[] args) {
		SpringApplication.run(DegusteMoiApplication.class, args);

		System.out.println("le projet t'as peur");

		System.out.println("lancement terminé");
		
		
	}

	@Override
	public void run(String... args) throws Exception {
		
		/*User u1 = new User(null, "Siwertz", "Marius", "siwertzm", "123", "siwertzm@gmail.com", "0677079342", null, null);
		userRepos.save(u1);*/

		
		
	}

	
	
}
