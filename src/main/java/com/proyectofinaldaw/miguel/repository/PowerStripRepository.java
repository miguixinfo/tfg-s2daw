package com.proyectofinaldaw.miguel.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyectofinaldaw.miguel.domain.PowerStrip;

public interface PowerStripRepository extends JpaRepository<PowerStrip, Long>{

	Optional<PowerStrip> findById(Long id);
}
