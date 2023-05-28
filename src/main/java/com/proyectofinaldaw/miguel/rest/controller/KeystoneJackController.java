package com.proyectofinaldaw.miguel.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.proyectofinaldaw.miguel.domain.KeystoneJack;
import com.proyectofinaldaw.miguel.rest.service.KeystoneJackService;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
@RequestMapping(value = "/api/keystoneJacks")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class KeystoneJackController {

	@Autowired
	private KeystoneJackService service;
	
	@Operation(summary = "Retrieves a lsit with Keystone Jacks")
	@ApiResponses(value = {
			@ApiResponse(code = 200 , message = "Keystone Jacks found."),
			@ApiResponse(code = 404, message = "Keystone Jacks not found")
	})
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public List<KeystoneJack> getKeystoneJacks() {
		return service.getKeystoneJacks();
	}
	
	@Operation(summary = "Get a Keystone Jack by its id")
	@ApiResponses(value = {
			@ApiResponse(code = 200 , message = "Keystone Jack found."),
			@ApiResponse(code = 404, message = "Keystone Jack not found")
	})
	@GetMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Optional<KeystoneJack> getKeystoneJackById(
			@Parameter(description = "Id of the Keystone Jack to be searched") @PathVariable Long id) {
		return service.getKestoneJackById(id);
	}
	
	@Operation(summary = "Save a Kesytone Jack")
	@ApiResponses(value = {
			@ApiResponse(code = 201 , message = "Keystone Jack created.")
	})
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public KeystoneJack saveKesytoneJack(
			@Parameter(description = "Keystone Jack to be stored") @RequestBody KeystoneJack keystoneJack) {
		return service.save(keystoneJack);
	}
	
	@Operation(summary = "Delete one Keystone Jack")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Keystone Jack deleted"),
			@ApiResponse(code = 404, message = "Keystone Jack Not Found")
	})
	@DeleteMapping("/{id}")
	public void deleteKeystoneJack(
			@Parameter(description = "Id of the Keystone Jack to be deleted") @PathVariable Long id) {
		service.delete(id);
	}
	
}
