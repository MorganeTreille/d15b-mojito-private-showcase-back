package fr.formation.modele;



import java.util.Set;

import javax.persistence.*;

@Entity
public class Departements {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long departement_id;
	
	@Column
	private String departement_code;
	@Column
	private String departement_nom;
	@Column
	private String departement_nom_uppercase;
	@Column
	private String departement_slug;
	@Column
	private String departement_nom_soundex;
	
	
	//********************************constructeur******************************//
	public Departements(Long departement_id, String departement_code, String departement_nom,
			String departement_nom_uppercase, String departement_slug, String departement_nom_soundex) {
		super();
		this.departement_id = departement_id;
		this.departement_code = departement_code;
		this.departement_nom = departement_nom;
		this.departement_nom_uppercase = departement_nom_uppercase;
		this.departement_slug = departement_slug;
		this.departement_nom_soundex = departement_nom_soundex;
	}//**************************cardialités***************************//
	
	@OneToMany
	private Set<Users> users;
	
	//**************************************accesseurs**************************//


	public Long getDepartement_id() {
		return departement_id;
	}


	public void setDepartement_id(Long departement_id) {
		this.departement_id = departement_id;
	}


	public String getDepartement_code() {
		return departement_code;
	}


	public void setDepartement_code(String departement_code) {
		this.departement_code = departement_code;
	}


	public String getDepartement_nom() {
		return departement_nom;
	}


	public void setDepartement_nom(String departement_nom) {
		this.departement_nom = departement_nom;
	}


	public String getDepartement_nom_uppercase() {
		return departement_nom_uppercase;
	}


	public void setDepartement_nom_uppercase(String departement_nom_uppercase) {
		this.departement_nom_uppercase = departement_nom_uppercase;
	}


	public String getDepartement_slug() {
		return departement_slug;
	}


	public void setDepartement_slug(String departement_slug) {
		this.departement_slug = departement_slug;
	}


	public String getDepartement_nom_soundex() {
		return departement_nom_soundex;
	}


	public void setDepartement_nom_soundex(String departement_nom_soundex) {
		this.departement_nom_soundex = departement_nom_soundex;
	}
	
	
	
	
}
