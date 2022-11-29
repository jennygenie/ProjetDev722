package fr.solutec.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class VinDetaillees {
	@Id @GeneratedValue
	private Long id_vin;
	private String titre;
	private String region;
	private String description;
	private String note;
	private String nb_bouteilles;
	private String elevage;
	private String garde;
	private String temp_degust;

}
