package com.example.milanuncios.util;

import java.util.List;

public class Categoria {
	
	private int id_categoria;

	private String descripcion;

	private List<Anuncio> anuncios;

	public Categoria() {
		super();
	}

	public Categoria(int id_categoria, String descripcion, List<Anuncio> anuncios) {
		super();
		this.id_categoria = id_categoria;
		this.descripcion = descripcion;
		this.anuncios = anuncios;
	}

	public int getId_categoria() {
		return id_categoria;
	}

	public void setId_categoria(int id_categoria) {
		this.id_categoria = id_categoria;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Anuncio> getAnuncios() {
		return anuncios;
	}

	public void setAnuncios(List<Anuncio> anuncios) {
		this.anuncios = anuncios;
	}

	@Override
	public String toString() {
		return "Categoria [id_categoria=" + id_categoria + ", descripcion=" + descripcion + ", anuncios=" + anuncios
				+ "]";
	}

	
}
