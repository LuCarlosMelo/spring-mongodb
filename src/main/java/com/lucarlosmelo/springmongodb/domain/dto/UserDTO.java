package com.lucarlosmelo.springmongodb.domain.dto;

import java.io.Serializable;
import java.util.UUID;

import com.lucarlosmelo.springmongodb.domain.User;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Setter(AccessLevel.NONE)
	private UUID id;
	private String name;
	private String email;
	
	public UserDTO(User entity) {
		id = entity.getID();
		name = entity.getName();
		email = entity.getEmail();
	}
	
	
	
}
