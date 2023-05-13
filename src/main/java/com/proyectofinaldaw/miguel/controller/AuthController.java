package com.proyectofinaldaw.miguel.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyectofinaldaw.miguel.domain.User;
import com.proyectofinaldaw.miguel.service.UserService;
import com.proyectofinaldaw.miguel.utils.JWTUtil;

@RestController
@RequestMapping(value = "api/login")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AuthController {
	
	@Autowired
	private UserService service;
	
	@Autowired
	private JWTUtil jwtUtil;
	
	@PostMapping
	public Map login(@RequestBody User user) {
		Map response = new HashMap();
		User loggedUser = service.getUserByCredentials(user);
		if(loggedUser != null) {
			String tokenJWT = jwtUtil.create(String.valueOf(loggedUser.getId()), loggedUser.getEmail());

			response.put("token", tokenJWT);
            response.put("success", "OK");
		} else response.put("success", "FAIL");
		return response;
	}

}
