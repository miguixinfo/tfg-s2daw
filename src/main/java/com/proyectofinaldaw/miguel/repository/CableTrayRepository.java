package com.proyectofinaldaw.miguel.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyectofinaldaw.miguel.domain.CableTray;

public interface CableTrayRepository extends JpaRepository<CableTray, Long>{

	Optional<CableTray> findById(Long id);
	
}
