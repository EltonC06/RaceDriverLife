package com.racedriverlife.racedriverlife_app.entities;

import java.util.Objects;

public class User {
	
	private Long userId;
	private String name;
	private String email;
	private String password;
	
	private RaceCentral raceCentral;
	
	
	public User() {
		
	}


	public User(Long userId, String name, String email, String password, RaceCentral raceCentral) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.raceCentral = raceCentral;
	}


	public Long getUserId() {
		return userId;
	}


	public void setUserId(Long userId) {
		this.userId = userId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
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
