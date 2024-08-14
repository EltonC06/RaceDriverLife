package com.racedriverlife.racedriverlife_app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.racedriverlife.racedriverlife_app.entities.Race;
import com.racedriverlife.racedriverlife_app.entities.RaceCentral;
import com.racedriverlife.racedriverlife_app.entities.Task;
import com.racedriverlife.racedriverlife_app.entities.User;
import com.racedriverlife.racedriverlife_app.entities.enums.TaskStatus;
import com.racedriverlife.racedriverlife_app.services.RaceCentralService;
import com.racedriverlife.racedriverlife_app.services.RaceService;
import com.racedriverlife.racedriverlife_app.services.TaskService;
import com.racedriverlife.racedriverlife_app.services.UserService;

@SpringBootApplication
public class Tester implements CommandLineRunner {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private RaceCentralService centralService;
	
	@Autowired
	private RaceService raceService;
	
	public static void main(String[] args) {
		SpringApplication.run(Tester.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		/*
		Race race = new Race();
		
		RaceCentral raceCentral = new RaceCentral(race);
		
		User user = new User("Elton", "12345", raceCentral);
		
		User savedUser = userService.save(user);

		Task savedTask = taskService.save(new Task("Programar", race));
		Task savedTas = taskService.save(new Task("Organizar gaveta", race));
		Task savedTas2 = taskService.save(new Task("Comprar mouse", race));
		// -----------------
		Race race2 = new Race();
		
		RaceCentral raceCentral2 = new RaceCentral(race2);
		
		User user2 = new User("Enael", "1345", raceCentral2);
		
		User savedUser2 = userService.save(user2);

		Task savedTask2 = taskService.save(new Task("Jogar", race2));
		Task savedTask3 = taskService.save(new Task("Fazer compras", race2));
		Task savedTask4 = taskService.save(new Task("Academia", race2));
		
		*/
		/*
		Race race3 = new Race();
		
		RaceCentral raceCentral3 = new RaceCentral(race3);
		
		User user3 = new User("Nothon", "1245", raceCentral3);
		
		Task taskToSave = new Task("Passear", race3);
		Task taskToSave2 = new Task("Fazer compras", race3);
		
		userService.save(user3);
		
		User savedUser = userService.getUserById(1L);
		savedUser.setUserName("alex green");
		
		Task taskToUpdate = taskService.getTaskById(2L);
		taskToUpdate.setTaskStatus("DONE");
		
		taskService.update(2L, taskToUpdate);
		userService.update(1L, savedUser);
		raceService.update(1L, race3);
		/*
		taskService.delete(1L);
		taskService.delete(2L);
		
		raceService.update(1L, race3);
		*/
		
	}

}
