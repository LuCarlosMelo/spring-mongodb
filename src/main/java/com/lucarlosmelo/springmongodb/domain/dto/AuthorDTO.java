package com.lucarlosmelo.springmongodb.domain.dto;

import java.io.Serializable;
import java.util.UUID;

import com.lucarlosmelo.springmongodb.domain.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
public class AuthorDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private UUID id;
	
	@Setter
	private String name;
	
	public AuthorDTO(User user) {
		this.id = user.getId();
		this.name = user.getName();
	}
	
}
