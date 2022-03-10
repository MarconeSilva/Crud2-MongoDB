package com.marcone.crud2.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.marcone.crud2.domain.Usuario;

@Repository
public interface RepositorioDeUsuario extends MongoRepository<Usuario, String>{

	

}
