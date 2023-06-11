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

import com.proyectofinaldaw.miguel.domain.EthernetCable;
import com.proyectofinaldaw.miguel.rest.service.EthernetCableService;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
@RequestMapping(value = "/api/ethernetCables")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EthernetCableController {

	@Autowired
	private EthernetCableService service;
	
	@Operation(summary = "Retrieve list of ethernet cables from database")
	@ApiResponses(value = {
			@ApiResponse(code = 200 , message = "Ethernet Cables found."),
			@ApiResponse(code = 404, message = "Ethernet Cables not found")
	})
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public List<EthernetCable> getEthernetCables() {
		return service.getEthernetCables();
	}
	
	@Operation(summary = "Get ethernet cables by its id")
	@ApiResponses(value = {
			@ApiResponse(code = 200 , message = "Ethernet Cables found."),
			@ApiResponse(code = 404, message = "Ethernet Cables not found")
	})
	@GetMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Optional<EthernetCable> getEthernetCableById(
			@Parameter(description = "Id of the ethernet cable to be searched") @PathVariable Long id) {
		return service.getEthernetCableById(id);
	}
	
	@Operation(summary = "Saves one Ethernet Cable")
	@ApiResponses(value = {
			@ApiResponse(code = 201 , message = "Switch created.")
	})
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public EthernetCable saveEthernetCable(
			@Parameter(description = "Ethernet Cable to be stored") @RequestBody EthernetCable ethernetCable) {
		return service.save(ethernetCable);
	}
	
	@Operation(summary = "Delete one Ethernet Cable")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Ethernet Cable deleted")
	})
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public void deleteEthernetCable(
			@Parameter(description = "Id of the Ethernet Cable to be deleted") @PathVariable Long id) {
		service.delete(id);
	}
}
