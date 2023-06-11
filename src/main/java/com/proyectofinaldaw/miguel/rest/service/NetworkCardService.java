package com.proyectofinaldaw.miguel.rest.service;

import java.util.List;
import java.util.Optional;

import com.proyectofinaldaw.miguel.domain.NetworkCard;

public interface NetworkCardService {

	public List<NetworkCard> getNetworkCards();
	
	public Optional<NetworkCard> getNetworkCardById(Long id);
	
	public NetworkCard save(NetworkCard networkCard);
	
	public void delete(Long id);
	
}
