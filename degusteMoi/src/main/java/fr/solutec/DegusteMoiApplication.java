package fr.solutec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.solutec.entities.Produit;
import fr.solutec.repository.ProduitRepository;



@SpringBootApplication
public class DegusteMoiApplication implements CommandLineRunner {
	
	@Autowired
	private ProduitRepository pRepos;
	
	public static void main(String[] args) {
		SpringApplication.run(DegusteMoiApplication.class, args);

		System.out.println("le projet t'as peur");

		System.out.println("lancement terminé");
		
		
	}

	@Override
	public void run(String... args) throws Exception {

		Produit p1 = new Produit(null, "Tomate");
		pRepos.save(p1);
		
	}

	
	
}
