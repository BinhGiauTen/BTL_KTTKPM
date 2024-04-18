package com.example.UserService.database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.UserService.models.Usser;
import com.example.UserService.repositories.UserRepository;



@Configuration
public class Database {
//	logger
	private static final Logger logger = LoggerFactory.getLogger(Database.class);
	@Bean
	CommandLineRunner initDatabase(UserRepository userRepository) {
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				Usser user1 = new Usser("Tran", "Long", "long", "123");
				Usser user2 = new Usser("Nguyen", "An", "an", "546");
				logger.info("insert data:" +userRepository.save(user1));
				logger.info("insert data:" +userRepository.save(user2));
			}
		};
	}

}


