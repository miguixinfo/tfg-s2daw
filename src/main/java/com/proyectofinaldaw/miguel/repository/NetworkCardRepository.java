package com.proyectofinaldaw.miguel.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyectofinaldaw.miguel.domain.NetworkCard;

public interface NetworkCardRepository extends JpaRepository<NetworkCard, Long>{

	Optional<NetworkCard> findById(Long id);
}
