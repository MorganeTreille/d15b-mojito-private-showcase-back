package fr.formation.service;

import javax.persistence.EntityManager;

public class DAOService {

	private EntityManager entityM;
	public DAOService(EntityManager entityM){
		this.entityM = entityM;
		
	}
	
	
}
