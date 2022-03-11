package com.marcone.crud2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcone.crud2.domain.Post;
import com.marcone.crud2.repository.RepositorioDePost;
import com.marcone.crud2.services.exception.ObjectNotFoundException;


@Service
public class ServicoDePost {
	
	@Autowired
	private RepositorioDePost repositorio;
	
		
	public Post findById(String id) {
		Optional<Post> obj = repositorio.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	
	}
	
	public List<Post> findByTitle(String text){
		return repositorio.findByTituloContainingIgnoreCase(text);
	}
}
