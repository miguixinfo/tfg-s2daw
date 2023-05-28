package com.proyectofinaldaw.miguel.rest.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectofinaldaw.miguel.domain.Switch;
import com.proyectofinaldaw.miguel.error.SwitchNotFoundException;
import com.proyectofinaldaw.miguel.repository.SwitchRepository;
import com.proyectofinaldaw.miguel.rest.service.SwitchService;

@Service
public class SwitchServiceImpl implements SwitchService {

	@Autowired
	private SwitchRepository repository;

	@Override
	public List<Switch> getSwitchs() {
		return repository.findAll();
	}

	@Override
	public Optional<Switch> getSwitchById(Long id) {
		return  Optional.of(repository.findById(id).orElseThrow(() -> new SwitchNotFoundException(id)));
	}

	@Override
	public Switch save(Switch sw) {
		return repository.save(sw);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	

}
