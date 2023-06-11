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
@Table(name = "ethernet_cable")
@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
public class EthernetCable extends BaseObject implements Serializable{

	private static final long serialVersionUID = 5789460780776536595L;

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
	
	@OneToMany(mappedBy = "ethernetCable", cascade = CascadeType.REFRESH, orphanRemoval = true)
	private List<DefaultInstallation> installations;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		EthernetCable other = (EthernetCable) obj;
		return Objects.equals(description, other.description) && Objects.equals(name, other.name)
				&& Objects.equals(price, other.price);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(description, name, price);
		return result;
	}

	@Override
	public String toString() {
		return "EthernetCable [name=" + name + ", description=" + description + ", price=" + price + "]";
	}
	
	
}
