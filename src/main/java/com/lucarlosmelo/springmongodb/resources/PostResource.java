package com.lucarlosmelo.springmongodb.resources;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucarlosmelo.springmongodb.domain.Post;
import com.lucarlosmelo.springmongodb.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

	@Autowired
	private PostService service;


	@GetMapping(value = "/{id}")
	public ResponseEntity<Post> findById(@PathVariable UUID id) {
		Post post = service.findById(id);
		return ResponseEntity.ok(post);
	}
	
}
