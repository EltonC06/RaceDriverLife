package com.racedriverlife.racedriverlife_app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.racedriverlife.racedriverlife_app.entities.Race;
import com.racedriverlife.racedriverlife_app.entities.RaceCentral;
import com.racedriverlife.racedriverlife_app.entities.Task;
import com.racedriverlife.racedriverlife_app.entities.User;
import com.racedriverlife.racedriverlife_app.services.TaskService;
import com.racedriverlife.racedriverlife_app.services.UserService;

@SpringBootApplication
public class Tester implements CommandLineRunner {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TaskService taskService;
	
	public static void main(String[] args) {
		SpringApplication.run(Tester.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Race race = new Race();
		
		RaceCentral raceCentral = new RaceCentral(race);
		
		User user = new User("Elton", "12345", raceCentral);
		
		User savedUser = userService.saveUser(user);

		Task savedTask = taskService.saveTask(new Task("Programar", race));
		
		
		
	}

}
