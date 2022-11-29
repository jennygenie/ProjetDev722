package fr.solutec.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @AllArgsConstructor @NoArgsConstructor @Data
public class Repas {

	@Id @GeneratedValue
	private Long id;
	@ManyToOne @OnDelete(action = OnDeleteAction.CASCADE)
	private User hote;
	private Date date;
	private String adresse;
	private String theme;
}
