package com.example.UserService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.UserService.models.Usser;
import com.google.common.base.Optional;

public interface UserRepository extends JpaRepository<Usser, Long>{
	Optional<Usser> findByUserName (String userName);
}
