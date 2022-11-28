package fr.solutec.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @AllArgsConstructor @NoArgsConstructor @Data
public class Vin {
	
	@Id @GeneratedValue
	private Long id;
	private String titre;
	private String sous_titre;
	private String description;
	private String type;
	private String region;
	private String lien_image;
	private String lien_description;
	
	

}
