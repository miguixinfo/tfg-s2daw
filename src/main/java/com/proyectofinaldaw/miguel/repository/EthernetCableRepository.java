package com.proyectofinaldaw.miguel.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyectofinaldaw.miguel.domain.EthernetCable;

public interface EthernetCableRepository extends JpaRepository<EthernetCable, Long>{

	
	Optional<EthernetCable> findById(Long id);
}
