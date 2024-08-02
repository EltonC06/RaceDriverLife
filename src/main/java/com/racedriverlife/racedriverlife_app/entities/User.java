package com.racedriverlife.racedriverlife_app.entities;


public class User {

	private Long userId;
	private String userName;
	private String password;
	
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
