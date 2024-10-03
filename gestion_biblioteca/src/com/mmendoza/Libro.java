package com.mmendoza;

public class Libro {
	
	private String titulo;
	private String autor;
	private String isbn;
	private Boolean disponible;
	
	
	protected String getTitulo() {
		return titulo;
	}
	
	protected void modificarDisponibilidad() {
		disponible = false; 
	}
	
	protected Boolean getDisponible() {
		return disponible;
	}
	
	
	
}
