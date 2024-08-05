package com.racedriverlife.racedriverlife_app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.racedriverlife.racedriverlife_app.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> { // passa a classe e o tipo da chave primaira

}
