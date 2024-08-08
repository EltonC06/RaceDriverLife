package com.racedriverlife.racedriverlife_app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.racedriverlife.racedriverlife_app.DTOs.UserDTO;
import com.racedriverlife.racedriverlife_app.entities.Race;
import com.racedriverlife.racedriverlife_app.entities.RaceCentral;
import com.racedriverlife.racedriverlife_app.entities.User;
import com.racedriverlife.racedriverlife_app.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository; // para poder se comunicar com BD
	
	public List<UserDTO> getAllUsers() {
		List<UserDTO> userDTO = new ArrayList<UserDTO>();
		List<User> user = this.repository.findAll();
		
		for (User x : user) {
			userDTO.add(convertToDTO(x));
		}
		return userDTO;
		
	}

	public User getUserById(Long id) {
		return this.repository.findById(id).get();
	}
	
	public User save(UserDTO userDTO) {
		
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
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public User update(Long id, UserDTO userDTO) {
		User entity = repository.getReferenceById(id); // pega todos os atributos do user especifico
		
		updateData(entity, userDTO);
		
		return repository.save(entity);	
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
