package com.marcone.crud2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcone.crud2.domain.Usuario;
import com.marcone.crud2.dto.UsuarioDTO;
import com.marcone.crud2.repository.RepositorioDeUsuario;
import com.marcone.crud2.services.exception.ObjectNotFoundException;


@Service
public class ServicoDeUsuario {
	
	@Autowired
	private RepositorioDeUsuario repositorio;
	
	public List<Usuario> findAll(){
		return repositorio.findAll();
	}
	
	public Usuario findById(String id) {
		Optional<Usuario> obj = repositorio.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public Usuario insere(Usuario obj) {
		return repositorio.insert(obj);
	}
	
	public Usuario atualizar(Usuario usuario) {
		Usuario nusuario = findById(usuario.getId());
		atualizar(nusuario, usuario);
		return repositorio.save(nusuario);
	}	

	private void atualizar(Usuario nusuario, Usuario usuario) {
		nusuario.setNome(usuario.getNome());
		nusuario.setEmail(usuario.getEmail());
		
	}

	public void deletar(String id) {
		findById(id);
		repositorio.deleteById(id);
		
	}
	
	public Usuario fromDTO(UsuarioDTO objDto) {
		return new Usuario(objDto.getId(), objDto.getNome(), objDto.getEmail());
	}

}
