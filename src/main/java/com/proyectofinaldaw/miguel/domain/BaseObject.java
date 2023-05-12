package com.proyectofinaldaw.miguel.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;




@MappedSuperclass
public abstract class BaseObject implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2062862435525718896L;
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "creation_date")
	private Date creationDate;

	@Override
	public int hashCode() {
		return Objects.hash(creationDate, id);
	}

	
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Date getCreationDate() {
		return creationDate;
	}



	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BaseObject other = (BaseObject) obj;
		return Objects.equals(creationDate, other.creationDate) && Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "BaseObject [id=" + id + ", creationDate=" + creationDate + "]";
	}
	
	
}
