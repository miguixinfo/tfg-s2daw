package com.proyectofinaldaw.miguel.rest.service;

import java.util.List;
import java.util.Optional;

import com.proyectofinaldaw.miguel.domain.DefaultInstallation;

public interface DefaultInstallationService {

	public List<DefaultInstallation> getDefaultInstallations();
	
	public Optional<DefaultInstallation> getDefaultInstallationById(Long id);
	
	public DefaultInstallation save(DefaultInstallation defaultInstallation);
	
	public void delete(Long id);
}
