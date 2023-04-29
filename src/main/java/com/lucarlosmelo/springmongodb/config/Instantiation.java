package com.lucarlosmelo.springmongodb.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.lucarlosmelo.springmongodb.domain.User;
import com.lucarlosmelo.springmongodb.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		var maria = new User("Maria Brown", "maria@email.com");
		var alex = new User("Alex Green", "alex@email.com");
		var bob = new User("Bob Grey", "@email.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));

	}

}
