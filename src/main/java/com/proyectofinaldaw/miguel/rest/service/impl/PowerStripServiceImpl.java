package com.proyectofinaldaw.miguel.rest.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectofinaldaw.miguel.domain.PowerStrip;
import com.proyectofinaldaw.miguel.error.PowerStripNotFoundException;
import com.proyectofinaldaw.miguel.repository.PowerStripRepository;
import com.proyectofinaldaw.miguel.rest.service.PowerStripService;

@Service
public class PowerStripServiceImpl implements PowerStripService{

	@Autowired
	private PowerStripRepository repository;
	
	@Override
	public List<PowerStrip> getPowerStrips() {
		return repository.findAll();
	}

	@Override
	public Optional<PowerStrip> getPowerStripById(Long id) {
		return Optional.of(repository.findById(id).orElseThrow(() -> new PowerStripNotFoundException(id)));
	}

	@Override
	public PowerStrip save(PowerStrip powerStrip) {
		return repository.save(powerStrip);
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}

}
