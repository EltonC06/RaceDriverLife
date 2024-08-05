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
		
		Race race = new Race(10, 10);

		RaceCentral raceCentral = new RaceCentral(0, 0, race);
		

		
		
		User user = new User("Elton", "12345", raceCentral);
		
		User savedUser = userService.saveUser(user);
		
		Task task = new Task("teste", TaskStatus.PENDING, race);
		Task task2 = new Task("teste2", TaskStatus.PENDING, race);
		Task task3 = new Task("teste3", TaskStatus.PENDING, race);
		Task task4 = new Task("teste4", TaskStatus.PENDING, race);
		
		Task savedTask = taskService.saveTask(task);
		Task savedTask2 = taskService.saveTask(task2);
		Task savedTask3 = taskService.saveTask(task3);
		Task savedTask4 = taskService.saveTask(task4);
		
		System.out.println(savedUser.getUserName() + "\n" + savedUser.getPassword() + "\n" + savedUser.getRaceCentral().getRacesDisputed());
		
		// testando pra ver se a relação funcionou
		User userReceived = userService.getUserById(savedUser.getUserId());
		
		System.out.println(String.format("Search: \n2: %s \n1: %s \n3: %s", userReceived.getUserName(), userReceived.getPassword(), savedUser.getRaceCentral().getRacesDisputed()));
		
		
	}
	
	
	
	
}
