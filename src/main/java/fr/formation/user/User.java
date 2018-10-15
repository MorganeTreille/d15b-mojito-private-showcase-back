package fr.formation.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import fr.formation.artist.Artist;

/**
 * Entity to manage a user in database
 *
 */
@Entity
@Table(name="user")
public class User {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="username")
    private String username;
    
    @Column(name="password")
    private String password;

    @Column(name = "email")
    private String email;
    
    @OneToOne
    private Artist artist;
    
    
    public User(){}
    
	public User(Long id, String username, String password, String email, Artist artist) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.artist = artist;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
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


	public Artist getArtist() {
		return artist;
	}


	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	
}
