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

import com.proyectofinaldaw.miguel.domain.CableTray;
import com.proyectofinaldaw.miguel.rest.service.CableTrayService;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;


@RestController
@RequestMapping(value = "/api/cableTrays")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CableTrayController {

	@Autowired
	private CableTrayService service;
	
	@Operation(summary = "Retrieve list of all switchs from database")
	@ApiResponses(value = {
			@ApiResponse(code = 200 , message = "Cable Trays found."),
			@ApiResponse(code = 404, message = "Cable Trays found")
	})
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public List<CableTray> getCableTrays() {
		return service.getCableTrays();
	}
	
	@Operation(summary = "Get one CableTray by its id")
	@ApiResponses(value = {
			@ApiResponse(code = 200 , message = "Cable Tray found."),
			@ApiResponse(code = 404, message = "Cable Tray found")
	})
	@GetMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Optional<CableTray> getCableTrayById(
			@Parameter(description = "Id of the Cable Tray to be searched") @PathVariable Long id) {
		return service.getCableTrayById(id);
	}
	
	@Operation(summary = "Save one Cable Tray")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Cable Tray created successfully")
	})
	@PostMapping
	@ResponseStatus(code = HttpStatus.OK)
	public CableTray saveCableTray(
			@Parameter(description = "Cable Tray to be stored") @RequestBody CableTray cableTray) {
		return service.save(cableTray);
	}
	
	@Operation(summary = "Delete one Cable Tray")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Cable Tray Deleted"),
			@ApiResponse(code = 404, message = "Cable Tray Not Found")
	})
	@DeleteMapping("{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public void deleteCableTray(
			@Parameter(description = "Id of the Cable Tray to be deleted") @PathVariable Long id) {
		service.delete(id);
	}
}
