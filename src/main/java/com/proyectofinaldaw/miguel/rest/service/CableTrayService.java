package com.proyectofinaldaw.miguel.rest.service;

import java.util.List;
import java.util.Optional;

import com.proyectofinaldaw.miguel.domain.CableTray;

public interface CableTrayService {

	public List<CableTray> getCableTrays();
	
	public Optional<CableTray> getCableTrayById(Long id);
	
	public CableTray save(CableTray cableTray);
	
	public void delete(Long id);
}
