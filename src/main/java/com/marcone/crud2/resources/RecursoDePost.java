package com.marcone.crud2.resources;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.marcone.crud2.domain.Post;
import com.marcone.crud2.resources.util.URL;
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
	
	@GetMapping(value = "/pesquisatitulo")
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue="") String text){
		text = URL.decodeParam(text);
		List<Post> lista = servico.findByTitle(text);
		return ResponseEntity.ok().body(lista);
	
	}
	
	@GetMapping(value = "/pesquisacompleta")
	public ResponseEntity<List<Post>> pesquisaCompleta(
			@RequestParam(value = "text", defaultValue="") String text,
			@RequestParam(value = "minDate", defaultValue="") String minDate,
			@RequestParam(value = "maxDate", defaultValue="") String maxDate){
		text = URL.decodeParam(text);
		Date min = URL.convertDate(minDate, new Date(0L));
		Date max = URL.convertDate(maxDate, new Date());		
		List<Post> lista = servico.pesquisaCompleta(text, min, max);
		return ResponseEntity.ok().body(lista);
	
	}
}
