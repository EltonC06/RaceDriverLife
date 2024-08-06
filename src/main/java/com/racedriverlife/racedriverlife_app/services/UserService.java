package com.racedriverlife.racedriverlife_app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.racedriverlife.racedriverlife_app.entities.User;
import com.racedriverlife.racedriverlife_app.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository; // para poder se comunicar com BD
	
	// 3 metodos essenciais
	public List<User> getAllUsers() {
		return this.userRepository.findAll();
	}
	
	public User getUserById(Long id) {
		return this.userRepository.findById(id).get();
	}
	
	public User saveUser(User user) {
		return this.userRepository.save(user);
	}
	
	
}
