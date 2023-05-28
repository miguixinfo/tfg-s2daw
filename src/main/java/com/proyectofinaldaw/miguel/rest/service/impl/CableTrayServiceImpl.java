package com.proyectofinaldaw.miguel.rest.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectofinaldaw.miguel.domain.CableTray;
import com.proyectofinaldaw.miguel.error.CableTrayNotFoundException;
import com.proyectofinaldaw.miguel.repository.CableTrayRepository;
import com.proyectofinaldaw.miguel.rest.service.CableTrayService;

@Service
public class CableTrayServiceImpl implements CableTrayService{

	@Autowired
	private CableTrayRepository repository;
	
	@Override
	public List<CableTray> getCableTrays() {
		return repository.findAll();
	}

	@Override
	public Optional<CableTray> getCableTrayById(Long id) {
		return Optional.of(repository.findById(id).orElseThrow(() -> new CableTrayNotFoundException(id)));
	}

	@Override
	public CableTray save(CableTray cableTray) {
		return repository.save(cableTray);
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}

}
