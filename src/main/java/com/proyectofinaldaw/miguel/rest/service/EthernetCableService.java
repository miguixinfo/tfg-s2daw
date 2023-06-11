package com.proyectofinaldaw.miguel.rest.service;

import java.util.List;
import java.util.Optional;

import com.proyectofinaldaw.miguel.domain.EthernetCable;

public interface EthernetCableService {

	
	public List<EthernetCable> getEthernetCables();
	
	public EthernetCable save(EthernetCable ethernetCable);
	
	public Optional<EthernetCable> getEthernetCableById(Long id);
	
	public void delete(Long id);
}
