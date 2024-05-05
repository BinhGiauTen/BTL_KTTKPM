package com.example.UserService.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.UserService.models.Usser;

public interface UserRepository extends JpaRepository<Usser, Long>{
	Optional<Usser> findByUserName (String userName);
}
