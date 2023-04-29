package com.lucarlosmelo.springmongodb.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lucarlosmelo.springmongodb.domain.User;
import com.lucarlosmelo.springmongodb.repositories.UserRepository;
import com.lucarlosmelo.springmongodb.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	@Transactional(readOnly = true)
	public Page<User> findAll(Pageable pageable){
		Page<User> page = repository.findAll(pageable);
		return page;
	}
	
	@Transactional(readOnly = true)
	public User findById(UUID id){
		Optional<User> user = repository.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Id not found"));
	}
	
	
}
