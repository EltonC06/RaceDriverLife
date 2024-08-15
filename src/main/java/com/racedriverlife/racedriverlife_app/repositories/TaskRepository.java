package com.racedriverlife.racedriverlife_app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.racedriverlife.racedriverlife_app.entities.Race;
import com.racedriverlife.racedriverlife_app.entities.Task;


@Repository
public interface TaskRepository extends JpaRepository<Task, Long> { // passa a classe e o tipo do seu id
	
	List<Task> findByRace(Race race); // query automaticamente gerada pelo jpa
}
