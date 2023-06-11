package com.proyectofinaldaw.miguel.rest.service;

import java.util.List;
import java.util.Optional;

import com.proyectofinaldaw.miguel.domain.Switch;

public interface SwitchService {

	public List<Switch> getSwitchs();
	
	public Optional<Switch> getSwitchById(Long id);
	
	public Switch save(Switch sw);
	
	public void delete(Long id);
	
}
