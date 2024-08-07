package com.racedriverlife.racedriverlife_app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.racedriverlife.racedriverlife_app.entities.User;
import com.racedriverlife.racedriverlife_app.repositories.UserRepository;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class UserService {
	
	@Autowired
	private UserRepository repository; // para poder se comunicar com BD
	
	public List<User> getAllUsers() {
		return this.repository.findAll();
	}
	@Transactional
	public User getUserById(Long id) {
		return this.repository.findById(id).get();
	}
	
	public User save(User user) {
		return this.repository.save(user);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public User update(Long id, User user) {
		User entity = repository.getReferenceById(id);
		entity = updateData(entity, user);
		return repository.save(entity);	
	}
	
	private User updateData(User entity, User user) {
		entity.setUserName(user.getUserName());
		entity.setPassword(user.getPassword());
		entity.setRaceCentral(user.getRaceCentral());
		
		return entity;
		
	}
	
	
}
