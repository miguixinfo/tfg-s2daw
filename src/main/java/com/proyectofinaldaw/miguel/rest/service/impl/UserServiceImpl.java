package com.proyectofinaldaw.miguel.rest.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectofinaldaw.miguel.domain.User;
import com.proyectofinaldaw.miguel.error.UserNotFoundException;
import com.proyectofinaldaw.miguel.repository.UserRepository;
import com.proyectofinaldaw.miguel.rest.service.UserService;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

@Service
public class UserServiceImpl implements UserService{

	
	@Autowired
	private UserRepository repository;
	
	@PersistenceContext
	EntityManager entityManager;
	
	
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
		String query = "FROM User WHERE email = :email";
        List<User> lista = entityManager.createQuery(query, User.class)
                .setParameter("email", user.getEmail())
                .getResultList();

        if(lista.isEmpty()) {
            return null;
        }

        String passwordHashed = lista.get(0).getPassword();

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        System.out.println(passwordHashed);
        System.out.println(user.getPassword());
        if(argon2.verify(passwordHashed, user.getPassword().getBytes())) {
            return lista.get(0);
        }
        return null;
	}



}
