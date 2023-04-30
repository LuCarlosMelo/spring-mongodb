package com.lucarlosmelo.springmongodb.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Document
public class Post implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@Setter(AccessLevel.NONE)
	private UUID id = UUID.randomUUID();
	
	private LocalDateTime date;
	private String title;
	private String body;
	
	private User author;
	
	public Post(LocalDateTime date, String title, String body, User author) {
		super();
		this.date = date;
		this.title = title;
		this.body = body;
		this.author = author;
	}
	
}
