package com.proyectofinaldaw.miguel.rest.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectofinaldaw.miguel.domain.EthernetCable;
import com.proyectofinaldaw.miguel.error.EthernetCableNotFoundException;
import com.proyectofinaldaw.miguel.repository.EthernetCableRepository;
import com.proyectofinaldaw.miguel.rest.service.EthernetCableService;

@Service
public class EthernetCableServiceImpl implements EthernetCableService {

	@Autowired
	private EthernetCableRepository repository;

	@Override
	public List<EthernetCable> getEthernetCables() {
		return repository.findAll();
	}

	@Override
	public EthernetCable save(EthernetCable ethernetCable) {
		return repository.save(ethernetCable);
	}

	@Override
	public Optional<EthernetCable> getEthernetCableById(Long id) {
		return Optional.of(repository.findById(id).orElseThrow(() -> new EthernetCableNotFoundException(id)));
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
