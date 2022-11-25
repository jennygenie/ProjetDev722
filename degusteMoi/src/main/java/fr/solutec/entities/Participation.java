package fr.solutec.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @NoArgsConstructor @AllArgsConstructor  @Data
public class Participation {
	
	@Id @GeneratedValue
	private Long id;
	@OneToOne @OnDelete(action = OnDeleteAction.CASCADE)
	private User user;
	@OneToOne @OnDelete(action = OnDeleteAction.CASCADE)
	private Repas repas;
	private boolean accept;
}
