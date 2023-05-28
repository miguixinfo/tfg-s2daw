package com.proyectofinaldaw.miguel.rest.service;

import java.util.List;
import java.util.Optional;

import com.proyectofinaldaw.miguel.domain.KeystoneJack;

public interface KeystoneJackService {

	
	public List<KeystoneJack> getKeystoneJacks();
	
	public Optional<KeystoneJack> getKestoneJackById(Long id);
	
	public KeystoneJack save(KeystoneJack keystoneJack);
	
	public void delete(Long id);
}
