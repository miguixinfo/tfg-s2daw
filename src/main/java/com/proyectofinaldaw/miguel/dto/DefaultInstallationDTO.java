package com.proyectofinaldaw.miguel.dto;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.proyectofinaldaw.miguel.domain.CableTray;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(Include.NON_NULL)
public class DefaultInstallationDTO {

	@NotBlank(message = "Code cannot be empty")
	private String code;
	
	@NotBlank(message = "Description cannot be empty")
	private String description;
	
	private CableTray cableTray;
	
	public boolean canEqual(Object other) {
		return (other instanceof DefaultInstallationDTO);
	}
}
