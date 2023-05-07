package com.proyectofinaldaw.miguel.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectofinaldaw.miguel.domain.User;
import com.proyectofinaldaw.miguel.error.UserNotFoundException;
import com.proyectofinaldaw.miguel.repository.UserRepository;
import com.proyectofinaldaw.miguel.repository.adv.UserRepositoryAdvanced;
import com.proyectofinaldaw.miguel.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository repository;
	
	@Autowired
	private UserRepositoryAdvanced repositoryAdv;
	
	@Override
	@Transactional
	public List<User> getUsers() {
		return (List<User>) repository.findAll();
	}

	@Override
	@Transactional
	public User getUserById(Long id) {
		return repository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
	}

	@Override
	@Transactional
	public User save(User user) {
		return repository.save(user);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		repository.deleteById(id);
	}

	@Override
	public User getUserByCredentials(User user) {
		return repositoryAdv.getUserByCredentials(user);
	}


}
