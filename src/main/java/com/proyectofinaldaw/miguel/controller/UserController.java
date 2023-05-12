package com.proyectofinaldaw.miguel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.proyectofinaldaw.miguel.domain.User;
import com.proyectofinaldaw.miguel.error.UserNotFoundException;
import com.proyectofinaldaw.miguel.service.UserService;
import com.proyectofinaldaw.miguel.utils.JWTUtil;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
@RequestMapping(value = "api/users")
@CrossOrigin(origins = "http://127.0.0.1:5173", allowedHeaders = "Access-Control-Allow-Origin")

public class UserController {
	
	@Autowired
	private UserService service;
	
	@Autowired
	private JWTUtil jwtUtil;


	@GetMapping
	@ApiResponses(value = {
			@ApiResponse(code = 200 , message = "Users found."),
			@ApiResponse(code = 404, message = "Users not found")
	})
	@ResponseStatus(code = HttpStatus.OK)
	public List<User> getUsers() {
		return service.getUsers();
	}
	
	@GetMapping("/{id}")
	@ApiResponses(value = {
			@ApiResponse(code = 200 , message = "User found."),
			@ApiResponse(code = 404, message = "User not found")
	})
	@ResponseStatus(code = HttpStatus.OK)
	public User getUserById(
			@Parameter(description = "id of the user to find") @PathVariable(value = "id") Long id) {
		User user = null;
		
		user = service.getUserById(id);
		if (user == null) throw new UserNotFoundException(id);
		return user;
	}
	
	@PostMapping
	@ApiResponses(value = {
			@ApiResponse(code = 200 , message = "User created"),
			@ApiResponse(code = 404, message = "User not found")
	})
	@ResponseStatus(code = HttpStatus.CREATED)
	public User saveUser(
			@Parameter(description = "User to be created") @RequestBody User user) {
		Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
		String hash = argon2.hash(1, 1024, 1, user.getPassword());
		user.setPassword(hash);
		service.save(user);
		return user;
	}
    
}
