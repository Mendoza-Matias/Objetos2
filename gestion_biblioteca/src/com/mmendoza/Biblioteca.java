package com.mmendoza;

import java.time.LocalDate;
import java.util.ArrayList;

public class Biblioteca {
	
	private ArrayList <Libro> libros;
	
	private ArrayList <Historial> historial;
	
	/* agrega 1 o mas libros */
	public Boolean agregarLibros(ArrayList <Libro> libros) {
		
		for(Libro libro:libros) {
			if(!estaEnLaBiblioteca(libro)) {
				libros.add(libro);
				return true; 		//TODO
			}
		}
		
		return false;
	}
	
	private Boolean estaEnLaBiblioteca(Libro libro) {
		return libros.contains(libro);
	}
	
	public Boolean estaDisponible(String titulo) {
		
		Boolean disponible = false;
		
		for(Libro libro : libros) {
			if(libro.getTitulo().equals(titulo))
				disponible = true;
		}
		
		return disponible;
		
	}
	
	public ArrayList <Historial> historial() {
		return historial;
	}

	
	
	protected void registrarHistorial(String numeroUsuario, String titulo) {
		
		/*se carga el historial*/
		historial.add(new Historial(numeroUsuario,titulo,LocalDate.now()));
		
		modificarEstadoDelLibro(titulo);
		
	}
	
	/*busca al libro con el titulo pasado y le modifica la disponibilidad*/
	private void modificarEstadoDelLibro(String titulo) {
		for(Libro libro:libros) {
			if(libro.getTitulo().equals(titulo))
				libro.modificarDisponibilidad(); /*cambia la disponibilidad de true a false*/
		}
	}

	public void librosSolicitados(String numeroUsuario) {
		// TODO Auto-generated method stub
		
	}
}
