package com.proyectofinaldaw.miguel.rest.service;

import java.util.List;
import java.util.Optional;

import com.proyectofinaldaw.miguel.domain.PowerStrip;

public interface PowerStripService {

	public List<PowerStrip> getPowerStrips();
	
	public Optional<PowerStrip> getPowerStripById(Long id);
	
	public PowerStrip save(PowerStrip powerStrip);
	
	public void delete(Long id);
	
}
