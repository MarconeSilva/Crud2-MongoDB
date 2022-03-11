package com.marcone.crud2.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.marcone.crud2.domain.Post;

@Repository
public interface RepositorioDePost extends MongoRepository<Post, String>{

	

}