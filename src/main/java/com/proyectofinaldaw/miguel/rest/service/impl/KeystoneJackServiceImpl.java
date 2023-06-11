package com.proyectofinaldaw.miguel.rest.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectofinaldaw.miguel.domain.KeystoneJack;
import com.proyectofinaldaw.miguel.error.KeystoneJackNotFoundException;
import com.proyectofinaldaw.miguel.repository.KeystoneJackRepository;
import com.proyectofinaldaw.miguel.rest.service.KeystoneJackService;

@Service
public class KeystoneJackServiceImpl implements KeystoneJackService{

	@Autowired
	private KeystoneJackRepository repository;
	
	@Override
	public List<KeystoneJack> getKeystoneJacks() {
		return repository.findAll();
	}

	@Override
	public Optional<KeystoneJack> getKestoneJackById(Long id) {
		return Optional.of(repository.findById(id).orElseThrow(() -> new KeystoneJackNotFoundException(id)));
	}

	@Override
	public KeystoneJack save(KeystoneJack keystoneJack) {
		return repository.save(keystoneJack);
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}

}
