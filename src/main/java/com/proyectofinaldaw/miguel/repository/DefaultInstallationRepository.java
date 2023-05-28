package com.proyectofinaldaw.miguel.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyectofinaldaw.miguel.domain.DefaultInstallation;

public interface DefaultInstallationRepository extends JpaRepository<DefaultInstallation, Long>{
	
	Optional<DefaultInstallation> findById(Long id);

}
