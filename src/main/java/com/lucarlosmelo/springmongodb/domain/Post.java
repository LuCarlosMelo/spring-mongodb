package com.lucarlosmelo.springmongodb.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.lucarlosmelo.springmongodb.domain.dto.AuthorDTO;
import com.lucarlosmelo.springmongodb.domain.dto.CommentDTO;

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
	private AuthorDTO author;
	
	private List<CommentDTO> comments = new ArrayList<>();
	
	public Post(LocalDateTime date, String title, String body, AuthorDTO author) {
		super();
		this.date = date;
		this.title = title;
		this.body = body;
		this.author = author;
	}
	
}
