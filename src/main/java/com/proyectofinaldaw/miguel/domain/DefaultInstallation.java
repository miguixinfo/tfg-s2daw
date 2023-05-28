package com.proyectofinaldaw.miguel.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "default_installation")
@Data
@NoArgsConstructor
@AllArgsConstructor
@DynamicUpdate
public class DefaultInstallation extends BaseObject implements Serializable{

	private static final long serialVersionUID = 4909003842185876398L;

	@NotBlank(message = "Code cannot be empty")
	@Column(name = "code", nullable = false)
	private String code;
	
	@NotBlank(message = "Description cannot be empty")
	@Column(name = "description", nullable = false)
	private String description;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cable_tray_id")
	private CableTray cableTray;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ethernet_cable_id")
	private EthernetCable ethernetCable;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "keystone_jack_id")
	private KeystoneJack keystoneJack;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "network_card_id")
	private NetworkCard networkCard;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "patch_panel_id")
	private PatchPanel patchPanel;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "power_strip_id")
	private PowerStrip powerStrip;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "switch_id")
	private Switch sw;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		DefaultInstallation other = (DefaultInstallation) obj;
		return Objects.equals(code, other.code) && Objects.equals(description, other.description);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(code, description);
		return result;
	}

	@Override
	public String toString() {
		return "DefaultInstallation [code=" + code + ", description=" + description + "]";
	}
	
	
}

