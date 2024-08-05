package com.racedriverlife.racedriverlife_app.entities;

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
	private String userName;
	private String password;
	
	@OneToOne
	@JoinColumn(name = "race_central_id", nullable = false)
	private RaceCentral raceCentral;
	
	
	public User() {
		
	}


	public User(Long userId, String userName, String password) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
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
	
	
	public void resetStorage() {
		raceCentral.setRacesDisputed(0);
		raceCentral.setRacesWon(0);
		raceCentral.endRace();
	}

}
