package fr.formation.departement;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Departement {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name ="departement_id")
private long id;

@Column(name ="departement_nom")
private String name;


}
