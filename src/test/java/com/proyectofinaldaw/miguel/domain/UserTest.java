package com.proyectofinaldaw.miguel.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class UserTest {

	public User setUp() {
		return new User();
	}
	
	
	
	@Test
	void check_user_setter() {
		User user = new User();
		user.setName("Miguel");
		user.setEmail("gmigui77@gmail.com");
		user.setPassword("1234");
		
		assertThat(user.getName()).isEqualTo("Miguel");
		assertThat(user.getEmail()).isEqualTo("gmigui77@gmail.com");
		assertThat(user.getPassword()).isEqualTo("1234");
	}
	
}
