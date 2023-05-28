package com.proyectofinaldaw.miguel.rest.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectofinaldaw.miguel.domain.CableTray;
import com.proyectofinaldaw.miguel.domain.DefaultInstallation;
import com.proyectofinaldaw.miguel.domain.PowerStrip;
import com.proyectofinaldaw.miguel.error.CableTrayNotFoundException;
import com.proyectofinaldaw.miguel.error.DefaultInstallationNotFoundException;
import com.proyectofinaldaw.miguel.error.PowerStripNotFoundException;
import com.proyectofinaldaw.miguel.repository.CableTrayRepository;
import com.proyectofinaldaw.miguel.repository.DefaultInstallationRepository;
import com.proyectofinaldaw.miguel.repository.PowerStripRepository;
import com.proyectofinaldaw.miguel.rest.service.DefaultInstallationService;

@Service
public class DefaultInstallationServiceImpl implements DefaultInstallationService {

	@Autowired
	private DefaultInstallationRepository repository;
	
	@Autowired
	private PowerStripRepository powerStripRepository;
	
	@Override
	public List<DefaultInstallation> getDefaultInstallations() {
		return repository.findAll();
	}

	@Override
	public Optional<DefaultInstallation> getDefaultInstallationById(Long id) {
		return Optional.of(repository.findById(id).orElseThrow(() -> new DefaultInstallationNotFoundException(id)));
	}

	@Override
	public DefaultInstallation save(DefaultInstallation defaultInstallation) {
		if(defaultInstallation.getPowerStrip() != null && defaultInstallation.getPowerStrip().getId() != null) {
			Optional<PowerStrip> powerStrip = powerStripRepository.findById(defaultInstallation.getPowerStrip().getId());
			if(powerStrip.isPresent())
				defaultInstallation.setPowerStrip(powerStrip.get());
			else
				throw new PowerStripNotFoundException(defaultInstallation.getPowerStrip().getId());
		} else {
			throw new IllegalArgumentException("You have to choose one Power Strip");
		}
		
		return repository.save(defaultInstallation);
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}

	
}
