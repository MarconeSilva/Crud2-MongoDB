package com.marcone.crud2.testes;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.marcone.crud2.domain.Usuario;
import com.marcone.crud2.repository.RepositorioDeUsuario;

@Configuration
public class teste implements CommandLineRunner{
	
	@Autowired
	private RepositorioDeUsuario repositorioDeUsuario;

	@Override
	public void run(String... args) throws Exception {
		
		repositorioDeUsuario.deleteAll();
		
		Usuario marcone = new Usuario(null, "marcone", "marcone@gmail.com");
		Usuario nayma = new Usuario(null, "nayma", "nayma@gmail.com");
		Usuario kaua = new Usuario(null, "kaua", "kaua@gmail.com");
		Usuario luan = new Usuario(null, "luan", "luan@gmail.com");
		
		repositorioDeUsuario.saveAll(Arrays.asList(marcone, nayma, kaua, luan));
		
		
		
	}

}
