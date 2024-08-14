package com.racedriverlife.racedriverlife_app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.racedriverlife.racedriverlife_app.DTOs.UserDTO;
import com.racedriverlife.racedriverlife_app.entities.User;
import com.racedriverlife.racedriverlife_app.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private UserService service;

	@GetMapping
	public List<User> findAll() {
		List<User> result = service.getAllUsers();
		return result;
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> findById(@PathVariable(name = "id") Long id) {
		User user = service.getUserById(id);
		return ResponseEntity.ok().body(user);
	}

	@PostMapping
	public User insert(@Valid @RequestBody UserDTO userDTO) {
		User savedUser = service.save(userDTO); // transferindo para outra classe
		return savedUser;
	}

	@PutMapping("/{id}")
	public User update(@Valid @PathVariable(name = "id") Long id, @Valid @RequestBody UserDTO userDTO) {
		return service.update(id, userDTO);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable(name = "id") Long id) {
		service.delete(id);
	}
}
