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

import com.proyectofinaldaw.miguel.domain.DefaultInstallation;
import com.proyectofinaldaw.miguel.rest.service.DefaultInstallationService;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
@RequestMapping(value = "/api/defaultInstallations")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DefaultInstallationController {

	@Autowired
	private DefaultInstallationService service;
	
	@Operation(summary = "Retrieves a list with default installations")
	@ApiResponses(value = {
			@ApiResponse(code = 200 , message = "Default Installations found."),
			@ApiResponse(code = 404, message = "Default Installations not found")
	})
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public List<DefaultInstallation> getDefaultInstallations() {
		return service.getDefaultInstallations();
	}
	
	@Operation(summary = "Get one default installation by its id")
	@ApiResponses(value = {
			@ApiResponse(code = 200 , message = "Default Installation found."),
			@ApiResponse(code = 404, message = "Default Installation not found")
	})
	@GetMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Optional<DefaultInstallation> getDefaultInstallationById(
			@Parameter(description = "Id of the default installation to be searched") @PathVariable("id") Long id) {
		return service.getDefaultInstallationById(id);
	}
	
	@Operation(summary = "Save one default installation")
	@ApiResponses(value = {
			@ApiResponse(code = 201 , message = "Switch created.")
	})
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public DefaultInstallation saveDefaultInstallation(
			@Parameter(description = "Default installation to be stored") @RequestBody DefaultInstallation defaultInstallation) {
		return service.save(defaultInstallation);
	}
	
	@Operation(summary = "Delete one default installation")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Cable Tray Deleted"),
			@ApiResponse(code = 404, message = "Cable Tray Not Found")
	})
	@DeleteMapping("/{id}")
	public void deleteDefaultInstallation(
			@Parameter(description = "Id of the default installation to be deleted") @PathVariable("id") Long id) {
		service.delete(id);
	}
}
