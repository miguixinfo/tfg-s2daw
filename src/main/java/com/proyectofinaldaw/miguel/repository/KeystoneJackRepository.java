package com.proyectofinaldaw.miguel.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyectofinaldaw.miguel.domain.KeystoneJack;

public interface KeystoneJackRepository extends JpaRepository<KeystoneJack, Long>{

	Optional<KeystoneJack> findById(Long id);
}
