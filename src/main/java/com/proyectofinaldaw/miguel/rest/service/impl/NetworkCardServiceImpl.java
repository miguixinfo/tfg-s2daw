package com.proyectofinaldaw.miguel.rest.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectofinaldaw.miguel.domain.NetworkCard;
import com.proyectofinaldaw.miguel.error.NetworkCardNotFoundException;
import com.proyectofinaldaw.miguel.repository.NetworkCardRepository;
import com.proyectofinaldaw.miguel.rest.service.NetworkCardService;

@Service
public class NetworkCardServiceImpl implements NetworkCardService{

	@Autowired
	private NetworkCardRepository repository;
	
	@Override
	public List<NetworkCard> getNetworkCards() {
		return repository.findAll();
	}

	@Override
	public Optional<NetworkCard> getNetworkCardById(Long id) {
		return Optional.of(repository.findById(id).orElseThrow(() -> new NetworkCardNotFoundException(id)));
	}

	@Override
	public NetworkCard save(NetworkCard networkCard) {
		return repository.save(networkCard);
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}

	
	
}
