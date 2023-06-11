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

import com.proyectofinaldaw.miguel.domain.PatchPanel;
import com.proyectofinaldaw.miguel.rest.service.PatchPanelService;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
@RequestMapping(value = "/api/patchPanels")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PatchPanelController {

	@Autowired
	private PatchPanelService service;
	
	@Operation(summary = "Retrieves list with Patch Panels")
	@ApiResponses(value = {
			@ApiResponse(code = 200 , message = "Patch Panels found."),
			@ApiResponse(code = 404, message = "Patch Panels not found")
	})
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public List<PatchPanel> getPatchPanels() {
		return service.getPatchPanels();
	}
	
	@Operation(summary = "Get a Patch Panel by its uuid")
	@ApiResponses(value = {
			@ApiResponse(code = 200 , message = "Patch Panel found."),
			@ApiResponse(code = 404, message = "Patch Panel not found")
	})
	@GetMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Optional<PatchPanel> getPatchPanelByUuid(
			@Parameter(description = "Id of the Patch Panel to be searched") @PathVariable Long id) {
		return service.getPatchPanelByUuid(id);
	}
	
	
	@Operation(summary = "Save one Patch Panel")
	@ApiResponses(value = {
			@ApiResponse(code = 201 , message = "Switch created.")
	})
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public PatchPanel savePatchPanel(
			@Parameter(description = "Patch Panel to be stored") @RequestBody PatchPanel patchPanel) {
		return service.save(patchPanel);
	}
	
	@Operation(summary = "Delete one Patch Panel")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Patch Panel deleted"),
			@ApiResponse(code = 404, message = "Patch Panel Not Found")
	})
	@DeleteMapping("/{id}")
	public void deletePatchPanel(
			@Parameter(description = "id of the Patch Panel to be deleted") @PathVariable Long id) {
		service.delete(id);
	}
}
