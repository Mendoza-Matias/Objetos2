package com.mmendoza;

import java.time.LocalDate;

public class Historial {
	
	private String idUsuario;
	private String tituloDelLibro;
	private LocalDate fechaPrestamo;
	private LocalDate fechaDevolucion; 
	
	
	public Historial(String numeroUsuario, String titulo, LocalDate fecha) {
		this.idUsuario = numeroUsuario;
		this.tituloDelLibro = titulo;
		this.fechaPrestamo = fecha;
	}

	protected void insertarFechaDeDevolucion() {
		fechaDevolucion = LocalDate.now(); 
	}
	
	/*imprimir datos del historial*/
	
	@Override
	public String toString() {
		return "Historial "
				+ "[idUsuario=" + idUsuario + 
				", tituloDelLibro=" + tituloDelLibro + 
				", fechaPrestamo="+ fechaPrestamo + 
				", fechaDevolucion=" + fechaDevolucion + "]";
	}
	
}
