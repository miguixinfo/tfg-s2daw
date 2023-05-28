package com.proyectofinaldaw.miguel.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyectofinaldaw.miguel.domain.PatchPanel;

public interface PatchPanelReporisoty extends JpaRepository<PatchPanel, Long>{

	Optional<PatchPanel> findById(Long id);
}
