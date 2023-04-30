package com.lucarlosmelo.springmongodb.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lucarlosmelo.springmongodb.domain.User;
import com.lucarlosmelo.springmongodb.domain.dto.UserDTO;
import com.lucarlosmelo.springmongodb.repositories.UserRepository;
import com.lucarlosmelo.springmongodb.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	@Transactional(readOnly = true)
	public Page<User> findAll(Pageable pageable) {
		Page<User> page = repository.findAll(pageable);
		return page;
	}

	@Transactional(readOnly = true)
	public User findById(UUID id) {
		Optional<User> user = repository.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Id not found"));
	}

	@Transactional
	public User insert(UserDTO userDTO) {
		User user = new User();
		BeanUtils.copyProperties(userDTO, user);
		return repository.save(user);
	}

	@Transactional
	public UserDTO update(UUID id, UserDTO userDTO) {
		Optional<User> userOptional = repository.findById(id);
		var user = dtoToModel(userDTO, userOptional.get());
		user =  repository.save(user);
		return new UserDTO(user);
	}

	public void delete(UUID id) {
		try {
			repository.deleteById(id);
		} catch (ObjectNotFoundException e) {
			throw new ObjectNotFoundException("id not found" + id);
		}
	}

	public User dtoToModel(UserDTO userDTO, User user) {
		user.setName(userDTO.getName());
		user.setEmail(userDTO.getEmail());
		return user;
	}

}
