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

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class Demande {
	
	@Id @GeneratedValue
	private Long id;
	@OneToOne @OnDelete(action = OnDeleteAction.CASCADE)
	private User envoyeur;
	@OneToOne @OnDelete(action = OnDeleteAction.CASCADE)
	private User receveur;
	private Boolean valide;
	
	public Demande (User e, User r) {
		this.envoyeur = e;
		this.receveur = r;
		valide = false;
	}
}
