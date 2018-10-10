package fr.formation.modele;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class villes_france_free {
	@Id
	@GeneratedValue
	private long ville_id;

	
	@Column
	private String ville_departement;
	@Column
	private String ville_slug;
	@Column
	private String ville_nom;
	@Column
	private String ville_nom_simple;
	@Column
	private String ville_nom_reel;
	@Column
	private String ville_nom_soundex;
	@Column
	private String ville_nom_metaphone;
	@Column
	private String ville_code_postal;
	@Column
	private String ville_commune;
	@Column
	private String ville_code_commune;
	@Column
	private long ville_arrondissement;
	@Column
	private String ville_canton;
	@Column
	private long ville_amdi;
	@Column
	private int ville_population_2010;
	@Column
	private int ville_population_1999;
	@Column
	private int ville_population_2012;
	@Column
	private int ville_densite_2010;
	@Column
	private float ville_surface;
	@Column
	private float ville_longitude_deg;
	@Column
	private float ville_latitude_deg;
	@Column
	private String ville_longitude_grd;
	@Column
	private String ville_latitude_grd;
	@Column
	private String ville_longitude_dms;
	@Column
	private String ville_latitude_dms;
	@Column
	private int ville_zmin;
	@Column
	private int ville_zmax;
	
	
	
	
}
