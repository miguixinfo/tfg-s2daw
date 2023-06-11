package com.proyectofinaldaw.miguel.rest.service;

import java.util.List;


import com.proyectofinaldaw.miguel.domain.User;

public interface UserService {

	public List<User> getUsers();
	
	public User getUserById(Long id);
	
	public User save(User user);
	
	public void delete(Long id);
	
	public User getUserByCredentials(User user);
		
}
