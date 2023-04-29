package com.lucarlosmelo.springmongodb.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucarlosmelo.springmongodb.domain.User;
import com.lucarlosmelo.springmongodb.domain.dto.UserDTO;
import com.lucarlosmelo.springmongodb.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<Page<UserDTO>> findAll(Pageable pageable){
		 Page<User> page = service.findAll(pageable);
		 Page<UserDTO> pageDTO = page.map(x -> new UserDTO(x));
		 return ResponseEntity.ok(pageDTO);
	}
	
}
