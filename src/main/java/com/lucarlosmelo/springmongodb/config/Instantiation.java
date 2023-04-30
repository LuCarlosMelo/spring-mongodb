package com.lucarlosmelo.springmongodb.config;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.aggregation.DateOperators.DateFromParts;

import com.lucarlosmelo.springmongodb.domain.Post;
import com.lucarlosmelo.springmongodb.domain.User;
import com.lucarlosmelo.springmongodb.repositories.PostRepository;
import com.lucarlosmelo.springmongodb.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PostRepository postRepository;

	
	@Override
	public void run(String... args) throws Exception {


		userRepository.deleteAll();
		postRepository.deleteAll();
		
		var maria = new User("Maria Brown", "maria@email.com");
		var alex = new User("Alex Green", "alex@email.com");
		var bob = new User("Bob Grey", "@email.com");

		var post1 = new Post(LocalDateTime.now(ZoneId.of("GMT")), "Partiu Viagem",
				"Vou viajar para SP. Abraços!", maria);
		var post2 = new Post(LocalDateTime.now(ZoneId.of("GMT")), "Bom dia", "Acordei feliz hoje", maria);

		userRepository.saveAll(Arrays.asList(maria, alex, bob));

		postRepository.saveAll(Arrays.asList(post1, post2));

	}
	
}
