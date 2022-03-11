package com.marcone.crud2.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.marcone.crud2.dto.AutorDTO;
import com.marcone.crud2.dto.ComentarioDTO;

@Document
public class Post implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private AutorDTO autor;
	private Date data;
	private String titulo;
	private String mensagem;
	
	private List<ComentarioDTO> comentario = new ArrayList<>();
	
	public Post() {
		
	}

	public Post(String id, AutorDTO autor, Date data, String titulo, String mensagem) {
		super();
		this.id = id;
		this.autor= autor;
		this.data = data;
		this.titulo = titulo;
		this.mensagem = mensagem;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public AutorDTO getAutor() {
		return autor;
	}
	
	public void setAutor(AutorDTO autor) {
		this.autor = autor;
	}
	
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}	

	public List<ComentarioDTO> getComentario() {
		return comentario;
	}

	public void setComentario(List<ComentarioDTO> comentario) {
		this.comentario = comentario;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		return Objects.equals(id, other.id);
	}


	
	

}
