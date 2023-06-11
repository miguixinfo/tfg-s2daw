package com.proyectofinaldaw.miguel.dto;

import javax.validation.constraints.NotBlank;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

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
public class CableTrayDTO {

	@NotBlank(message = "Name cannot be empty")
	private String name;
	
	@NotBlank(message = "Description cannot be empty")
	private String description;
	
	@NotBlank(message = "Price cannot be empty")
	private String price;
	
	private String url;
	
	public boolean canEqual(Object other) {
		return (other instanceof CableTrayDTO);
	}
	
}
