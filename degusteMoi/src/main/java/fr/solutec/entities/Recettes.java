package fr.solutec.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class Recettes {
	
	@Id @GeneratedValue
	private Long id;
	private String titre;
	private String sub_title;
	private Long difficulty;
	private String nombre_personne;
	private String source_image;
	private String lien_recette;
	

}
