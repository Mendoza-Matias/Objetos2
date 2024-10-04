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
    public void estaDisponiblePeterPan() {

        ArrayList<Libro> libros = new ArrayList<>();

        libros.add(new Libro("Peter pan", "Jose"));
        libros.add(new Libro("Peter pan", "Jose"));
        libros.add(new Libro("Hasta el ultimo hombre", "Luis"));

        Biblioteca biblioteca = new Biblioteca();

        biblioteca.agregarLibros(libros);

        assertTrue(biblioteca.estaDisponible("Peter pan"));
    }

    @Test
    public void estaDisponibleLaSirenita() {

        ArrayList<Libro> libros = new ArrayList<>();

        libros.add(new Libro("Peter pan", "Jose"));
        libros.add(new Libro("Peter pan", "Jose"));
        libros.add(new Libro("Hasta el ultimo hombre", "Luis"));

        Biblioteca biblioteca = new Biblioteca();

        biblioteca.agregarLibros(libros);

        assertFalse(biblioteca.estaDisponible("La sirenita"));
    }

    @Test
    public void prestarLibroAUnEstudiante() {

        ArrayList<Libro> libros = new ArrayList<>();

        libros.add(new Libro("Peter pan", "Jose"));
        libros.add(new Libro("Peter pan", "Jose"));
        libros.add(new Libro("Hasta el ultimo hombre", "Luis"));

        Biblioteca biblioteca = new Biblioteca();

        Estudiante estudiante = new Estudiante("Juan", biblioteca);

        biblioteca.agregarLibros(libros);

        ArrayList<String> nombresDeLibros = new ArrayList<>();
        nombresDeLibros.add("Peter pan");

        estudiante.solicitarLibro(nombresDeLibros);


        assertFalse(biblioteca.estaDisponible("Peter pan"));
    }

    @Test
    public void devolverLibro() {

        ArrayList<Libro> libros = new ArrayList<>();

        libros.add(new Libro("Peter pan", "Jose"));
        libros.add(new Libro("Peter pan", "Jose"));
        libros.add(new Libro("Hasta el ultimo hombre", "Luis"));

        Biblioteca biblioteca = new Biblioteca();

        Estudiante estudiante = new Estudiante("Juan", biblioteca);

        biblioteca.agregarLibros(libros);

        ArrayList<String> nombresDeLibros = new ArrayList<>();
        nombresDeLibros.add("Peter pan");

        estudiante.solicitarLibro(nombresDeLibros);

        estudiante.devolverLibros();

        assertTrue(biblioteca.estaDisponible("Peter pan"));
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

        ArrayList<Historial> historial = biblioteca.historial();

        String nombreEstudiante = estudiante.getNombre();
        String tituloLibro = libros.get(0).getTitulo();
        String autor = libros.get(0).getAutor();

        assertEquals(nombreEstudiante, historial.get(0).getUsuario().getNombre());
        assertEquals(tituloLibro, historial.get(0).getLibros().get(0).getTitulo());
        assertEquals(autor, historial.get(0).getLibros().get(0).getAutor());
        assertEquals(LocalDate.now(), historial.get(0).getFechaPrestamo());
        assertNull(historial.get(0).getFechaDevolucion());
    }
}