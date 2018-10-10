package fr.formation.modele;

import java.util.Set;

import javax.persistence.*;

@Entity
public class Artistes extends Personnes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_artiste;
	
	
	@Column(nullable = false, length=55)
	private String artiste_name;
	@Column(nullable = false, length=200)
	private String descriptionCourte_artiste;
	@Column(nullable = false) 
	private String descriptionLongue_artiste;
	@Column(nullable = false)
	private String siteWeb_artiste;
	@Column (nullable = false,length =5)
	private int notes_artiste;
	
	//*********************************constructeurs********************************//
	
	public Artistes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Artistes(Long id_artiste, String artiste_name, String descriptionCourte_artiste,
			String descriptionLongue_artiste, String siteWeb_artiste, int notes_artiste) {
		super();
		this.id_artiste = id_artiste;
		this.artiste_name = artiste_name;
		this.descriptionCourte_artiste = descriptionCourte_artiste;
		this.descriptionLongue_artiste = descriptionLongue_artiste;
		this.siteWeb_artiste = siteWeb_artiste;
		this.notes_artiste = notes_artiste;
	}
	//***************************************cardinalités********************//
	@OneToMany
	private Set<Evennements> evennement;
	//************************************getters/setters***************************//

	public Long getId_artiste() {
		return id_artiste;
	}

	public void setId_artiste(Long id_artiste) {
		this.id_artiste = id_artiste;
	}

	public String getArtiste_name() {
		return artiste_name;
	}

	public void setArtiste_name(String artiste_name) {
		this.artiste_name = artiste_name;
	}

	public String getDescriptionCourte_artiste() {
		return descriptionCourte_artiste;
	}

	public void setDescriptionCourte_artiste(String descriptionCourte_artiste) {
		this.descriptionCourte_artiste = descriptionCourte_artiste;
	}

	public String getDescriptionLongue_artiste() {
		return descriptionLongue_artiste;
	}

	public void setDescriptionLongue_artiste(String descriptionLongue_artiste) {
		this.descriptionLongue_artiste = descriptionLongue_artiste;
	}

	public String getSiteWeb_artiste() {
		return siteWeb_artiste;
	}

	public void setSiteWeb_artiste(String siteWeb_artiste) {
		this.siteWeb_artiste = siteWeb_artiste;
	}

	public int getNotes_artiste() {
		return notes_artiste;
	}

	public void setNotes_artiste(int notes_artiste) {
		this.notes_artiste = notes_artiste;
	}
	
	
}
