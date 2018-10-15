package fr.formation.user;

import java.io.Serializable;

public class SignInDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4488786770927374429L;
	private String username;
	private String password;
	private String email;
	private String description;
	private String artistName;
	
	public SignInDto(){}
	
	public SignInDto(String username, String password, String email, String description, String artisteName) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.description = description;
		this.artistName = artistName;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getArtistName() {
		return artistName;
	}
	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	
}
