package fr.formation.ville;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="villes_france_free")
public class Ville {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
	@Column(name="ville_id")
	private Integer id;

	@Column(name = "ville_nom")
	private String nom;

}
