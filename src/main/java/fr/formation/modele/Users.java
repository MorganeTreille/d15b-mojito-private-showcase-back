package fr.formation.modele;

import javax.persistence.*;

import org.apache.catalina.User;

import java.util.*;


@Entity
public class Users extends Personnes{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_user;

	//**********************************cardinalites****************************//
	@OneToMany
	private Set<Evennements> evennement;
	
	@OneToOne
	private Users user;
	
	//**********************************constructeur***************************//
	public Users(Long id_user) {
		super();
		this.id_user = id_user;
	}
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	//*************************************getters/setters*********************//

	

	public Long getId_user() {
		return id_user;
	}

	public void setId_user(Long id_user) {
		this.id_user = id_user;
	}

}
