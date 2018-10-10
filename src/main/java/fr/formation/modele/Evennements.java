package fr.formation.modele;


import java.time.LocalDate;

import javax.persistence.*;

@Entity
public class Evennements {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_evennement;
	@Column(nullable = false)
	private int nombre_places;
	@Column(nullable = false)
	private LocalDate date_evenemment;


	//*********************************constructeurs********************************//
	public Evennements(Long id_evennement, int nombre_places, LocalDate date_evenemment) {
		super();
		this.id_evennement = id_evennement;
		this.nombre_places = nombre_places;
		this.date_evenemment = date_evenemment;
	}


	public Evennements() {
		super();
		// TODO Auto-generated constructor stub
	}


	//************************************getters/setters***************************//


	public Long getId_evennement() {
		return id_evennement;
	}


	public void setId_evennement(Long id_evennement) {
		this.id_evennement = id_evennement;
	}


	public int getNombre_places() {
		return nombre_places;
	}


	public void setNombre_places(int nombre_places) {
		this.nombre_places = nombre_places;
	}


	public LocalDate getDate_evenemment() {
		return date_evenemment;
	}


	public void setDate_evenemment(LocalDate date_evenemment) {
		this.date_evenemment = date_evenemment;
	}

	//**************************************cardinalites****************************//
	/*
	@OneToOne
	private Users user;
	@OneToOne
	private Artistes artiste;
	*/
}
