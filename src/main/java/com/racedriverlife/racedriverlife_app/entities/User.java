package com.racedriverlife.racedriverlife_app.entities;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_user")
public class User {

	@Id // definindo chave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	@Column(nullable = false)
	private String userName;
	private String password;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL) // a classe raceCentral não pode existir sem antes existir essa
	@JoinColumn(name = "race_central_id", nullable = false)
	private RaceCentral raceCentral;
	
	
	public User() {
		
	}

	public User(String userName, String password, RaceCentral raceCentral) {
		super();
		this.userName = userName;
		this.password = password;
		this.raceCentral = raceCentral;
	}

	public Long getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public RaceCentral getRaceCentral() {
		return raceCentral;
	}

	public void setRaceCentral(RaceCentral raceCentral) {
		this.raceCentral = raceCentral;
	}

	public void resetStorage() {
		raceCentral.setRacesDisputed(0);
		raceCentral.setRacesWon(0);
		raceCentral.endRace();
	}

	@Override
	public int hashCode() {
		return Objects.hash(userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(userId, other.userId);
	}
	
}
