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

import com.proyectofinaldaw.miguel.domain.NetworkCard;
import com.proyectofinaldaw.miguel.rest.service.NetworkCardService;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
@RequestMapping(value = "/api/networkCards")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class NetworkCardController {

	@Autowired
	private NetworkCardService service;
	
	@Operation(summary = "Retrieves a list with Network Cards")
	@ApiResponses(value = {
			@ApiResponse(code = 200 , message = "Network Cards found."),
			@ApiResponse(code = 404, message = "Network Cards not found")
	})
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public List<NetworkCard> getNetworkCards() {
		return service.getNetworkCards();
	}
	
	@Operation(summary = "Get one Network Card by its id")
	@ApiResponses(value = {
			@ApiResponse(code = 200 , message = "Network Card found."),
			@ApiResponse(code = 404, message = "Network Card not found")
	})
	@GetMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Optional<NetworkCard> getNetworkCardById(
			@Parameter(description = "Id of the Network Card to be searched") @PathVariable(value = "id") Long id) {
		return service.getNetworkCardById(id);
	}
	
	@Operation(summary = "Save one Network Card")
	@ApiResponses(value = {
			@ApiResponse(code = 201 , message = "Switch created.")
	})
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public NetworkCard saveNetworkCard(
			@Parameter(description = "Network Card to be stored") @RequestBody NetworkCard networkCard) {
		return service.save(networkCard);
	}
	
	@Operation(summary = "Delete one Network Card")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Network Card deleted"),
			@ApiResponse(code = 404, message = "Network Card Not Found")
	})
	@DeleteMapping("/{id}")
	public void deleteNetworkCard(
			@Parameter(description = "Id of the network card to be deleted") @PathVariable(value = "id") Long id) {
		service.delete(id);
	}
}
