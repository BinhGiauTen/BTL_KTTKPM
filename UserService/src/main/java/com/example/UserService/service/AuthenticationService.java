package com.example.UserService.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.UserService.models.AuthenticationResponse;
import com.example.UserService.models.Usser;
import com.example.UserService.repositories.UserRepository;


@Service
public class AuthenticationService {
	
	private final UserRepository repository;
	private final PasswordEncoder passwordEncoder;
	private final JwtService jwtService;
	private final AuthenticationManager authenticationManager;
	
	public AuthenticationService(UserRepository repository, PasswordEncoder passwordEncoder, JwtService jwtService,AuthenticationManager authenticationManager) {
		super();
		this.repository = repository;
		this.passwordEncoder = passwordEncoder;
		this.jwtService = jwtService;
		this.authenticationManager = authenticationManager;
	}
	
	public AuthenticationResponse register(Usser request) {
		Usser user = new Usser();
		user.setFirstName(request.getFirstName());
		user.setLastName(request.getLastName());
		user.setUserName(request.getUserName());
		user.setPassWord(passwordEncoder.encode(request.getPassWord()));
		user = repository.save(user);
		String token = jwtService.generateToken(user);
		return new AuthenticationResponse(token);
	}
	
	public AuthenticationResponse authenticate(Usser request) {
	    if (request.getUserName() == null || request.getPassWord() == null || request.getPassWord().isEmpty()) {
	        throw new IllegalArgumentException("Username and password must not be empty");
	    }
	    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUserName(), request.getPassWord()));
	    Usser user = repository.findByUserName(request.getUserName()).orElseThrow(() -> new UsernameNotFoundException("User not found"));
	    String token = jwtService.generateToken(user);
	    return new AuthenticationResponse(token);
	}
	

}
