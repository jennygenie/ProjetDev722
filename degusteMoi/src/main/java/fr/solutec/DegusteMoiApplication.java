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

		
		
	}

	
	
}
