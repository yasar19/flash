package com.example.demo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.models.Profile;


public interface IProfileRepository extends MongoRepository<Profile,String>{

}
