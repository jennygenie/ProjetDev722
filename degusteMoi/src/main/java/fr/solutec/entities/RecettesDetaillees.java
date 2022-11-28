package fr.solutec.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class RecettesDetaillees {
	
	@Id @GeneratedValue
	private Long id_recette;
	private String titre;
	private String temps_preparation;
	private String temps_cuisson;
	private String liste_ingredients;
	private String liste_preparation;
	private String appellations_recommandees;
	

}
