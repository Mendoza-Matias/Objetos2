package com.mmendoza.entity;

import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.Assert.*;


public class BibliotecaTest {

    @Test
    public void agreagarLibroALaBiblioteca() {

        ArrayList<Libro> libros = new ArrayList<>();

        libros.add(new Libro("Peter pan", "Jose"));
        libros.add(new Libro("Hasta el ultimo hombre", "Luis"));

        Integer esperado = 2;

        Biblioteca biblioteca = new Biblioteca();

        biblioteca.agregarLibros(libros);

        assertEquals(esperado, biblioteca.cantidadDeLibros());
    }

    @Test
    public void probarSiSePuedenAgregarDuplicados() {

        ArrayList<Libro> libros = new ArrayList<>();

        libros.add(new Libro("Peter pan", "Jose"));
        libros.add(new Libro("Peter pan", "Jose"));
        libros.add(new Libro("Hasta el ultimo hombre", "Luis"));

        Integer esperado = 2;

        Biblioteca biblioteca = new Biblioteca();

        biblioteca.agregarLibros(libros);

        assertEquals(esperado, biblioteca.cantidadDeLibros());
    }

    @Test
    public void prestarLibroAUnEstudiante() {

        ArrayList<Libro> libros = new ArrayList<>();

        libros.add(new Libro("Peter pan", "Jose"));
        libros.add(new Libro("Hasta el ultimo hombre", "Luis"));

        Biblioteca biblioteca = new Biblioteca();

        Estudiante estudiante = new Estudiante("Juan", biblioteca);

        biblioteca.agregarLibros(libros);

        ArrayList<String> nombresDeLibros = new ArrayList<>();
        nombresDeLibros.add("Peter pan");

        estudiante.solicitarLibro(nombresDeLibros);


        assertFalse(biblioteca.estaDisponibleElLibro("Peter pan"));
    }

    @Test
    public void devolverLibro() {

        ArrayList<Libro> libros = new ArrayList<>();

        libros.add(new Libro("Peter pan", "Jose"));
        libros.add(new Libro("Hasta el ultimo hombre", "Luis"));

        Biblioteca biblioteca = new Biblioteca();

        Estudiante estudiante = new Estudiante("Juan", biblioteca);

        biblioteca.agregarLibros(libros);

        ArrayList<String> nombresDeLibros = new ArrayList<>();
        nombresDeLibros.add("Peter pan");

        estudiante.solicitarLibro(nombresDeLibros);

        estudiante.devolverLibro("Peter pan");

        assertTrue(biblioteca.estaDisponibleElLibro("Peter pan"));
    }

    @Test
    public void historialDeLibrosPrestados() {

        ArrayList<Libro> libros = new ArrayList<>();

        libros.add(new Libro("Peter pan", "Jose"));

        Biblioteca biblioteca = new Biblioteca();

        Estudiante estudiante = new Estudiante("Juan", biblioteca);

        biblioteca.agregarLibros(libros);

        ArrayList<String> nombresDeLibros = new ArrayList<>();
        nombresDeLibros.add("Peter pan");

        estudiante.solicitarLibro(nombresDeLibros);

        ArrayList<Prestamos> prestamos = biblioteca.getHistorialDePrestamos();

        String nombreEstudiante = estudiante.getNombre();
        String tituloLibro = libros.get(0).getTitulo();
        String autor = libros.get(0).getAutor();

        assertEquals(nombreEstudiante, prestamos.get(0).getUsuario().getNombre());
        assertEquals(tituloLibro, prestamos.get(0).getLibrosSolicitados().get(0).getTitulo());
        assertEquals(autor, prestamos.get(0).getLibrosSolicitados().get(0).getAutor());
        assertEquals(LocalDate.now(), prestamos.get(0).getFechaPrestamo());
        assertNull(prestamos.get(0).getFechaDevolucion());
    }
}