package com.racedriverlife.racedriverlife_app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.racedriverlife.racedriverlife_app.entities.User;
import com.racedriverlife.racedriverlife_app.services.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/user/{id}")
	@ResponseBody // the return value should be used directly as the HTTP response.
	public User getUser(@PathVariable(name = "id") Long id) {
		User user = userService.getUserById(id); 
		return user;
		
	}
	
	@PostMapping("/user")
	@ResponseBody
	public User createUser(@RequestBody User user) {
		userService.saveUser(user); // transferindo para outra classe
		return user;
	}
	
	
}
