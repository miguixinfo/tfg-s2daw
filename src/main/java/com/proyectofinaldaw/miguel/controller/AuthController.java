package com.proyectofinaldaw.miguel.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyectofinaldaw.miguel.domain.User;
import com.proyectofinaldaw.miguel.service.UserService;
import com.proyectofinaldaw.miguel.utils.JWTUtil;

@RestController
@RequestMapping(value = "api/login")
public class AuthController {

	
	@Autowired
	private UserService service;
	
	@Autowired
	private JWTUtil jwtUtil;
	
	@PostMapping
    public Map loginSocio(@RequestBody User user) {
        Map respuesta = new HashMap();
        User userlogged = service.getUserByCredentials(user);
        System.out.println(userlogged);
        if (userlogged!=null) {
            String token = jwtUtil.create(String.valueOf(userlogged.getId()),userlogged.getEmail());
            respuesta.put("token", token);
            respuesta.put("success", "OK");
        } else respuesta.put("success","FAIL");
          return respuesta;
    }
}
