package fr.formation.artist;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "artist")
public class Artist {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="name", nullable = false, unique=true)
	private String name;
	
	@Column(name="descriptionCourt", length = 200, nullable = false )
	private String descriptionCourt;
	
	@Column(name="descriptionLong", nullable = true)
	private String descriptionLong;

	@Column(name="phoneNumber")
	private Long phoneNumber;

	@Column(name="address")
	private String address;

	@Column(name="email")
	private String email;



	public Artist() {}
	
	public Artist(
			Long id,
			String name,
			String descriptionCourt,
			String descriptionLong,
			Long phoneNumber,
			String address,
			String email) {
		super();
		this.id = id;
		this.name = name;
		this.descriptionCourt = descriptionCourt;
		this.descriptionLong = descriptionLong;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescriptionCourt() {
		return descriptionCourt;
	}

	public void setDescriptionCourt(String descriptionCourt) {
		this.descriptionCourt = descriptionCourt;
	}

	public String getDescriptionLong() {
		return descriptionLong;
	}

	public void setDescriptionLong(String descriptionLong) {
		this.descriptionLong = descriptionLong;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
