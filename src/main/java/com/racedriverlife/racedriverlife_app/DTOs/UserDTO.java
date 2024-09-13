package com.racedriverlife.racedriverlife_app.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UserDTO {

	@NotBlank(message = "Username can't be empty.")
	@Size(min = 3, max = 18, message = "Username need to have more than 2 and less than 18 characters")
	@Pattern(regexp = "^([a-zA-Z])[a-zA-Z_-]*[\\w_-]*[\\S]$|^([a-zA-Z])[0-9_-]*[\\S]$|^[a-zA-Z]*[\\S]$")
	private String userName;

	@Pattern(regexp = "^(?=.*\\d).{4,8}$", message = "Password must be between 4 and 8 digits long and include at least one numeric digit.")
	private String password;

	public UserDTO() {

	}

	public UserDTO(String userName, String password) {
		super();
		this.userName = userName.toLowerCase();
		this.password = password;
	}

	public String getUserName() {
		return userName.toLowerCase();
	}

	public void setUserName(String userName) {
		this.userName = userName.toLowerCase();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
