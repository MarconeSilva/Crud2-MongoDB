package com.marcone.crud2.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.marcone.crud2.domain.Usuario;
import com.marcone.crud2.dto.UsuarioDTO;
import com.marcone.crud2.services.ServicoDeUsuario;

@RestController
@RequestMapping(value = "usuarios")
public class RecursoDeUsuarios {
	
	@Autowired
	private ServicoDeUsuario servico;
	
	
	@GetMapping
	public ResponseEntity<List<UsuarioDTO>> findAll(){
		List<Usuario> list = servico.findAll();
		List<UsuarioDTO> listDto = list.stream().map(x -> new UsuarioDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<UsuarioDTO> findById(@PathVariable String id){
		Usuario obj = servico.findById(id);
		return ResponseEntity.ok().body(new UsuarioDTO(obj));
		
	}
	
	@PostMapping
	public ResponseEntity<Void> Insere(@RequestBody UsuarioDTO objDto){
		Usuario obj = servico.fromDTO(objDto);
		obj = servico.insere(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping (value = "/{id}")
	public ResponseEntity<Void> atualizar(@RequestBody UsuarioDTO objDto, @PathVariable String id){
		Usuario obj = servico.fromDTO(objDto);
		obj.setId(id);
		obj = servico.atualizar(obj);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deletar(@PathVariable String id){
		servico.deletar(id);
		return ResponseEntity.noContent().build();
	}
}
