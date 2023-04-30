package com.lucarlosmelo.springmongodb.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lucarlosmelo.springmongodb.domain.Post;
import com.lucarlosmelo.springmongodb.repositories.PostRepository;
import com.lucarlosmelo.springmongodb.services.exceptions.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repository;


	@Transactional(readOnly = true)
	public Post findById(UUID id) {
		Optional<Post> post = repository.findById(id);
		return post.orElseThrow(() -> new ObjectNotFoundException("Id not found"));
	}


}
