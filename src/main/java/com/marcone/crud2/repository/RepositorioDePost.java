package com.marcone.crud2.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.marcone.crud2.domain.Post;

@Repository
public interface RepositorioDePost extends MongoRepository<Post, String>{

	List<Post> findByTituloContainingIgnoreCase(String text);
	
	@Query("{ 'titulo': { $regex: ?0, $options: 'i'}}" )
	List<Post> pesquisaTitulo(String text);
	
	@Query("{ $and:[{ date: {$gte: ?1}}, { date: {$lte: ?2}}, { $or:[{ 'titulo': { $regex: ?0, $options: 'i'}},{ 'mensagem': { $regex: ?0, $options: 'i'}},{ 'comentario.texto': { $regex: ?0, $options: 'i'}}]}]}")
	List<Post> pesquisaCompleta(String text, Date minDate, Date maxDate);

}
