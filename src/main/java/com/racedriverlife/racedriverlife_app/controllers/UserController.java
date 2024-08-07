package com.racedriverlife.racedriverlife_app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.racedriverlife.racedriverlife_app.entities.User;
import com.racedriverlife.racedriverlife_app.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	@Autowired
	UserService service;
	
	@GetMapping
	public List<User> findAll() {
		List<User> result = service.getAllUsers();
		return result;
	}
	
	@GetMapping("/{id}")
	public User findById(@PathVariable(name = "id") Long id) {
		User user = service.getUserById(id); 
		return user;
	}
	
	@PostMapping
	public User insert(@RequestBody User user) {
		service.save(user); // transferindo para outra classe
		return user;
	}
	
	@PutMapping("/{id}")
	public User update(@PathVariable(name = "id") Long id, @RequestBody User user) {
		return service.update(id, user);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable(name = "id") Long id) {
		service.delete(id);
	}
	
}
