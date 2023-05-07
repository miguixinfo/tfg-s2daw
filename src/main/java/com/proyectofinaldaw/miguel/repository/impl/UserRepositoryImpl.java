package com.proyectofinaldaw.miguel.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

import com.proyectofinaldaw.miguel.domain.User;
import com.proyectofinaldaw.miguel.repository.adv.UserRepositoryAdvanced;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

public class UserRepositoryImpl implements UserRepositoryAdvanced{

	@Autowired
	EntityManager em;
	
	@Override
	public User getUserByCredentials(User user) {
		String query = "FROM User where TRIM(email)=TRIM(:email)";
        List<User> lista = em.createQuery(query, User.class)
                                         .setParameter("email",user.getEmail())
                                         .getResultList();
        System.out.println(lista.get(0));
        if(lista.isEmpty()) return null;
        String passwordHashed = lista.get(0).getPassword();
        System.out.println(passwordHashed);
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        if(argon2.verify(passwordHashed,user.getPassword().getBytes())) {
            return lista.get(0);
        } else return null;
	}

	
}
