package com.racedriverlife.racedriverlife_app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.racedriverlife.racedriverlife_app.DTOs.UserDTO;
import com.racedriverlife.racedriverlife_app.entities.Race;
import com.racedriverlife.racedriverlife_app.entities.RaceCentral;
import com.racedriverlife.racedriverlife_app.entities.User;
import com.racedriverlife.racedriverlife_app.repositories.UserRepository;
import com.racedriverlife.racedriverlife_app.services.exceptions.DatabaseException;
import com.racedriverlife.racedriverlife_app.services.exceptions.ResourceNotFoundException;
import com.racedriverlife.racedriverlife_app.services.exceptions.UserAlreadyExistsException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository; // para poder se comunicar com BD
	
	public List<User> getAllUsers() {
		return this.repository.findAll();		
	}

	public User getUserById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow( () -> new ResourceNotFoundException(id) );
	}
	
	public User save(UserDTO userDTO) {
		List<User> allUsers = this.getAllUsers();
		
		for (User user : allUsers) {
			if (user.getUserName().equals(userDTO.getUserName())) {
				throw new UserAlreadyExistsException();
			}
		}
		
		User user = new User();
		user.setUserName(userDTO.getUserName());
		user.setPassword(userDTO.getPassword());
		
		
		
		RaceCentral raceCentral = new RaceCentral();
		raceCentral.setRacesDisputed(0);
		raceCentral.setRacesWon(0);
		
		Race race = new Race();
		race.setDoneTasks(0);
		race.setIsActive(false);
		race.setTaskQuantity(0);
		
		
		raceCentral.setRace(race);
		user.setRaceCentral(raceCentral);
		
		return this.repository.save(user);
	}
	

	
	public User update(Long id, UserDTO userDTO) {

		
		try {
			User entity = repository.getReferenceById(id); // pega todos os atributos do user especifico
			
			if (!userDTO.getUserName().equals(entity.getUserName())) {
				List<User> allUsers = this.getAllUsers();
				
				for (User user : allUsers) {
					if (user.getUserName().equals(userDTO.getUserName())) { // verificando para não ter nome duplicata
						throw new UserAlreadyExistsException();
					}
				}
			}
			
			updateData(entity, userDTO);
			return repository.save(entity);	
		}
		catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	public void delete(Long id) {
		
		if (repository.existsById(id)) {
			repository.deleteById(id);
		}
		else {
			throw new DatabaseException("Resource not found. Id " + id);
		}
	}
	
	private void updateData(User entity, UserDTO userDTO) { // atualizando só o atualizável
		entity.setUserName(userDTO.getUserName());
		entity.setPassword(userDTO.getPassword());	
	}
	
	private UserDTO convertToDTO(User user) {
		UserDTO convertedUser = new UserDTO();
		convertedUser.setUserName(user.getUserName());
		convertedUser.setPassword(user.getPassword());
		
		return convertedUser;
	}
	

	
}
