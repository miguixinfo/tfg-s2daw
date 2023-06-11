package com.proyectofinaldaw.miguel.rest.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectofinaldaw.miguel.domain.PatchPanel;
import com.proyectofinaldaw.miguel.error.PatchPanelNotFoundException;
import com.proyectofinaldaw.miguel.repository.PatchPanelReporisoty;
import com.proyectofinaldaw.miguel.rest.service.PatchPanelService;

@Service
public class PatchPanelServiceImpl implements PatchPanelService {

	@Autowired
	private PatchPanelReporisoty repository;
	
	@Override
	public List<PatchPanel> getPatchPanels() {
		return repository.findAll();
	}

	@Override
	public Optional<PatchPanel> getPatchPanelByUuid(Long id) {
		return Optional.of(repository.findById(id).orElseThrow(() -> new PatchPanelNotFoundException(id)));
	}

	@Override
	public PatchPanel save(PatchPanel patchPanel) {
		return repository.save(patchPanel);
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}

	
	
}
