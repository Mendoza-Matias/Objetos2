package com.mmendoza;

import java.util.ArrayList;

public abstract class Usuario {
	
	private String nombre;
	
	private String numeroUsuario;
	
	private Biblioteca biblioteca; 
	
	private ArrayList <Libro> librosSolicitados;
	
	protected abstract Integer getLimite();
	
	protected void solicitarLibro(ArrayList<String> titulos){
		
		for(String titulo:titulos) {
			//llama al metodo de la biblioteca y guarda el historial de usuario y el titulo del libro
			biblioteca.registrarHistorial(numeroUsuario,titulo);
		}
		
		biblioteca.librosSolicitados(numeroUsuario);
		
		
	}
	
}
