package com.proyectofinaldaw.miguel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyectofinaldaw.miguel.domain.User;

public interface UserRepository extends JpaRepository<User, Long>{

	
}
