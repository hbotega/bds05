package com.devsuperior.movieflix.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_genre")
public class Genre implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	@OneToMany(fetch = FetchType.EAGER)//para que ao ser chamado o usuário do banco os perfis (roles) venham junto
	@JoinColumn(name = "genre_id")
	//@OneToMany(mappedBy = "tb_genre")
	private Set<Movie> movies = new HashSet<>();
	
	
	public Genre() {
		
	}


	public Genre(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Genre(Genre entity) {
		id = entity.getId();
		name = entity.getName();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Set<Movie> getMovies() {
		return movies;
	}
	
	

}
