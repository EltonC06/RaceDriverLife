package com.racedriverlife.racedriverlife_app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.racedriverlife.racedriverlife_app.entities.RaceCentral;

@Repository
public interface RaceCentralRepository extends JpaRepository<RaceCentral, Long> { // passa a classe e o tipo da seu id

}
