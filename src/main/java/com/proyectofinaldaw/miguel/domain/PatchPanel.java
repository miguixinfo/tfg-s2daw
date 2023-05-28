package com.proyectofinaldaw.miguel.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "patch_panel")
@AllArgsConstructor
@NoArgsConstructor
@Data
@DynamicUpdate
public class PatchPanel extends BaseObject implements Serializable{

	private static final long serialVersionUID = 997306489242007274L;

	@NotBlank(message = "Name cannot be empty")
	@Column(name = "name")
	private String name;
	
	@NotBlank(message = "Description cannot be empty")
	@Column(name = "description", length = 500)
	private String description;
	
	@NotBlank(message = "Price cannot be empty")
	@Column(name = "price")
	private String price;
	
	@Column(name = "url")
	private String url;
	
	@OneToMany(mappedBy = "patchPanel", cascade = CascadeType.REFRESH, orphanRemoval = true)
	private List<DefaultInstallation> installations;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(description, name, price, url);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PatchPanel other = (PatchPanel) obj;
		return Objects.equals(description, other.description) && Objects.equals(name, other.name)
				&& Objects.equals(price, other.price) && Objects.equals(url, other.url);
	}

	@Override
	public String toString() {
		return "PatchPanel [name=" + name + ", description=" + description + ", price=" + price + ", url=" + url + "]";
	}
	
	
}
