package com.racedriverlife.racedriverlife_app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.racedriverlife.racedriverlife_app.entities.Race;

@Repository
public interface RaceRepository extends JpaRepository<Race, Long> { // passa classe e o tipo do seu id

}
