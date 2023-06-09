package com.lucarlosmelo.springmongodb.repositories;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.lucarlosmelo.springmongodb.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, UUID> {
}
