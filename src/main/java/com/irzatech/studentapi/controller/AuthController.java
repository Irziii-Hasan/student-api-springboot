package com.irzatech.studentapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.irzatech.studentapi.model.AppUser;
import com.irzatech.studentapi.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping ("api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final PasswordEncoder passwordEncoder;
    
	private final UserRepository repository;

    
	
	@PostMapping ("/register")
	public ResponseEntity<String> registerUser(@RequestBody AppUser user){
		if(repository.findByUsername(user.getUsername()).isPresent()) {
			return ResponseEntity.badRequest().body("Username already taken.");
		}
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRole("user_role");
		repository.save(user);
		return ResponseEntity.ok("User registered successfully");
	}
}
