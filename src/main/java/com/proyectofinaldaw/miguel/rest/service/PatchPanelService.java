package com.proyectofinaldaw.miguel.rest.service;

import java.util.List;
import java.util.Optional;

import com.proyectofinaldaw.miguel.domain.PatchPanel;

public interface PatchPanelService {

	public List<PatchPanel> getPatchPanels();
	
	public Optional<PatchPanel> getPatchPanelByUuid(Long id);
	
	public PatchPanel save(PatchPanel patchPanel);
	
	public void delete(Long id);
	
}
