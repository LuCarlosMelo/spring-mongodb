package com.lucarlosmelo.springmongodb.config;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.lucarlosmelo.springmongodb.domain.Post;
import com.lucarlosmelo.springmongodb.domain.User;
import com.lucarlosmelo.springmongodb.domain.dto.AuthorDTO;
import com.lucarlosmelo.springmongodb.domain.dto.CommentDTO;
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

		userRepository.saveAll(Arrays.asList(maria, alex, bob));

		var post1 = new Post(date("21/03/2018 00:00"), "Partiu Viagem", "Vou viajar para SP. Abraços!",
				new AuthorDTO(maria));
		var post2 = new Post(date("23/03/2018 00:00"), "Bom dia", "Acordei feliz hoje", new AuthorDTO(maria));

		var comment1 = new CommentDTO("Boa viagem!", date("21/04/2018 00:00"), new AuthorDTO(alex));
		var comment2 = new CommentDTO("Aproveite", date("22/04/2018 00:00"), new AuthorDTO(bob));
		var comment3 = new CommentDTO("Tenha um ótimo dia!", date("23/04/2018 00:00"), new AuthorDTO(alex));

		post1.getComments().addAll(Arrays.asList(comment1, comment2));
		post2.getComments().addAll(Arrays.asList(comment3));

		postRepository.saveAll(Arrays.asList(post1, post2));

		maria.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(maria);

	}

	public LocalDateTime date(String date) {
		var utc = ZoneId.of("GMT");
		var dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").withZone(utc);

		return ZonedDateTime.parse(date, dateFormat).toLocalDateTime();

	}

}
