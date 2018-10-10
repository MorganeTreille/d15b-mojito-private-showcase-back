package fr.formation.modele;

import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Inheritance (strategy = InheritanceType.TABLE_PER_CLASS)

public class Personnes {

	String login ; 
	String password;
	String email;
	//***************************constructeur************************************//
	
	
	public Personnes() {
		
	}


	//***********************************accesseurs***********************************//
	public String getLogin() {
		return login;
	}



	public void setLogin(String login) {
		this.login = login;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}
	
}
