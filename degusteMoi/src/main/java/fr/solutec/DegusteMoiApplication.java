package fr.solutec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.solutec.entities.User;
import fr.solutec.repository.UserRepository;


@SpringBootApplication
public class DegusteMoiApplication implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepos;

	public static void main(String[] args) {
		SpringApplication.run(DegusteMoiApplication.class, args);

		System.out.println("le projet t'as peur");

		System.out.println("lancement terminé");

	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		/*User u1 = new User(null, "Siwertz", "Marius", "siwertzm", "123");
		User u2 = new User(null, "Bardin", "Marion", "mbardin", "456");
		User u3 = new User(null, "Scoliege", "Paul", "poloscolo", "789");
		userRepos.save(u1);
		userRepos.save(u2);
		userRepos.save(u3);*/
	}

}
