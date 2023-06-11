package com.proyectofinaldaw.miguel.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyectofinaldaw.miguel.domain.Switch;

public interface SwitchRepository extends JpaRepository<Switch, Long>{

	Optional<Switch> findById(Long id);
}
