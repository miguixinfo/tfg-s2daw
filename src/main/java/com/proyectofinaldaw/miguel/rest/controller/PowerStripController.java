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

import com.proyectofinaldaw.miguel.domain.PowerStrip;
import com.proyectofinaldaw.miguel.rest.service.PowerStripService;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
@RequestMapping(value = "/api/powerStrips")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PowerStripController {

	@Autowired
	private PowerStripService service;
	
	@Operation(summary = "Retrieves a list with power Strips")
	@ApiResponses(value = {
			@ApiResponse(code = 200 , message = "Power Strips found."),
			@ApiResponse(code = 404, message = "Power Strips not found")
	})
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public List<PowerStrip> getPowerStrips() {
		return service.getPowerStrips();
	}
	
	@Operation(summary = "Get a Power Strip by Id")
	@ApiResponses(value = {
			@ApiResponse(code = 200 , message = "Power Strip found."),
			@ApiResponse(code = 404, message = "Power Strip not found")
	})
	@GetMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Optional<PowerStrip> getPowerStripById(
			@Parameter(description = "Id of the Power Strip to be searched") @PathVariable(value = "id") Long id) {
		return service.getPowerStripById(id);
	}
	
	@Operation(summary = "Save one Power Strip")
	@ApiResponses(value = {
			@ApiResponse(code = 201 , message = "Power Strip created.")
	})
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public PowerStrip savePowerStrip(
			@Parameter(description = "Power Strip to be stored") @RequestBody PowerStrip powerStrip) {
		return service.save(powerStrip);
	}
	
	@Operation(summary = "Delete one Power Strip")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Power Strip deleted"),
			@ApiResponse(code = 404, message = "Power Strip Not Found")
	})
	@DeleteMapping("/{id}")
	public void deletePowerStrip(
			@Parameter(description = "Id of the Power Strip to be deleted") @PathVariable Long id) {
		service.delete(id);
	}
}
