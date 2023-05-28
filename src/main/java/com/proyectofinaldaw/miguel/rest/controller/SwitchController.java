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

import com.proyectofinaldaw.miguel.domain.Switch;
import com.proyectofinaldaw.miguel.rest.service.SwitchService;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
@RequestMapping(value = "/api/switchs")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SwitchController {
	
	@Autowired
	private SwitchService service;
	
	@Operation(summary = "Retrieve list of all switchs from database")
	@ApiResponses(value = {
			@ApiResponse(code = 200 , message = "Switchs found."),
			@ApiResponse(code = 404, message = "Switchs not found")
	})
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public List<Switch> getSwitchs() {
		return service.getSwitchs();
	}
	
	@Operation(summary = "Get one Switch by its uuid")
	@ApiResponses(value = {
			@ApiResponse(code = 200 , message = "Switch found."),
			@ApiResponse(code = 404, message = "Switch not found")
	})
	@GetMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Optional<Switch> getSwitchById(
			@Parameter(description = "Id of the Switch to be searched") @PathVariable("id") Long id) {
		return service.getSwitchById(id);
	}
	
	@Operation(summary = "Save one Switch")
	@ApiResponses(value = {
			@ApiResponse(code = 201 , message = "Switch created.")
	})
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Switch saveSwitch(
			@Parameter(description = "Switch to be created") @RequestBody Switch sw) {
		return service.save(sw);
	}
	
	@Operation(summary = "Delete one switch")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Switch deleted"),
			@ApiResponse(code = 404, message = "Switch Not Found")
	})
	@DeleteMapping("/{id}")
	public void deleteSwitch(
			@Parameter(description = "Id of the switch to be deleted") @PathVariable Long id) {
		service.delete(id);
	}

}
