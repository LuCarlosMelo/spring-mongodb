package com.lucarlosmelo.springmongodb.domain.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String text;
	private LocalDateTime date;
	private AuthorDTO author;
	
}
