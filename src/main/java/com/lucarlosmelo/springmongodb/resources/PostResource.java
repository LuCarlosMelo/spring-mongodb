package com.lucarlosmelo.springmongodb.resources;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lucarlosmelo.springmongodb.domain.Post;
import static com.lucarlosmelo.springmongodb.resources.util.URL.decodeParam;
import static com.lucarlosmelo.springmongodb.resources.util.URL.date;
import static com.lucarlosmelo.springmongodb.resources.util.URL.convertDate;
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
	
	@GetMapping(value="/titlesearch")
 	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value="text", defaultValue="") String text) {
		text = decodeParam(text);
		List<Post> list = service.findByTitle(text);
		return ResponseEntity.ok().body(list);
	}
	
	
	@GetMapping(value="/fullsearch")
 	public ResponseEntity<List<Post>> fullSearch(
 			@RequestParam(value="text", defaultValue="") String text,
 			@RequestParam(value="minDate", defaultValue="") String minDate,
 			@RequestParam(value="maxDate", defaultValue="") String maxDate) {
		text = decodeParam(text);
		var min = convertDate(minDate, date("21/02/2018"));
		var max = convertDate(maxDate, LocalDateTime.now());
		List<Post> list = service.fullSearch(text, min, max);
		return ResponseEntity.ok().body(list);
	}
}
