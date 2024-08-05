package com.racedriverlife.racedriverlife_app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.racedriverlife.racedriverlife_app.entities.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> { // passa a classe e o tipo do seu id

}
