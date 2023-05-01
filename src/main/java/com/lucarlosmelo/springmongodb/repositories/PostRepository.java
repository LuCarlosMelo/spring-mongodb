package com.lucarlosmelo.springmongodb.repositories;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.lucarlosmelo.springmongodb.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, UUID> {

	@Query("{ 'title': { $regex: ?0, $options: 'i' } }")
	List<Post> searchTitle(String text);
	
	List<Post> findByTitleContaining(String text);
	
	@Query("{ $and: { { }, { }, { } } }")
	List<Post> fullsearch(String text, LocalDateTime minDate, LocalDateTime maxDate);
}
