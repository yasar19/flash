package com.example.demo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.models.User;

public interface ICreateUserRepo extends MongoRepository<User,String>{
	public User findByEmail(String email);
}
