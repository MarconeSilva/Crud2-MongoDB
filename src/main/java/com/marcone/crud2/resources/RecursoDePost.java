package com.marcone.crud2.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marcone.crud2.domain.Post;
import com.marcone.crud2.services.ServicoDePost;

@RestController
@RequestMapping(value = "/posts")
public class RecursoDePost {
	
	@Autowired
	private ServicoDePost servico;
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id){
		Post obj = servico.findById(id);
		return ResponseEntity.ok().body(obj);
	
	}
}
