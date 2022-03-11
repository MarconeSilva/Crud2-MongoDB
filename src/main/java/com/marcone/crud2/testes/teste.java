package com.marcone.crud2.testes;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.marcone.crud2.domain.Post;
import com.marcone.crud2.domain.Usuario;
import com.marcone.crud2.dto.AutorDTO;
import com.marcone.crud2.repository.RepositorioDePost;
import com.marcone.crud2.repository.RepositorioDeUsuario;

@Configuration
public class teste implements CommandLineRunner{
	
	@Autowired
	private RepositorioDeUsuario repositorioDeUsuario;

	@Autowired
	private RepositorioDePost repositorioDePost;
	
	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
		dataFormatada.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		repositorioDeUsuario.deleteAll();	
		repositorioDePost.deleteAll();
		
		Usuario nayma = new Usuario(null, "nayma", "nayma@gmail.com");
		Usuario kaua = new Usuario(null, "kaua", "kaua@gmail.com");
		Usuario luan = new Usuario(null, "luan", "luan@gmail.com");
		
		repositorioDeUsuario.saveAll(Arrays.asList(nayma, kaua, luan));
		
		
		Post post1 = new Post(null, new AutorDTO(nayma), dataFormatada.parse("10/02/2022"), "testando 1" , "Estou aprendendo");
		Post post2 = new Post(null, new AutorDTO(nayma), dataFormatada.parse("10/02/2022"), "testando 2" , "Mais um Post");
		
		repositorioDePost.saveAll(Arrays.asList(post1, post2));
		
		nayma.getPosts().addAll(Arrays.asList(post1, post2));
		
		repositorioDeUsuario.save(nayma);
		
	}

}
