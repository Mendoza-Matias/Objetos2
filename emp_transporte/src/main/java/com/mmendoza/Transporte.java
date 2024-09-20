package com.mmendoza;

import java.util.LinkedList;

// Clase abstracta que representa un transporte
public abstract class Transporte {

    // Peso máximo que puede transportar
    private Integer peso;

    // Volumen máximo que puede transportar
    private Double volumen;

    // Lista de paquetes que el transporte puede llevar
    protected LinkedList<Paquete> paquetes = new LinkedList<Paquete>();

    // Constructor que inicializa peso y volumen
    public Transporte(Integer peso, Double volumen) {
        this.peso = peso;
        this.volumen = volumen;
    }

    // Método abstracto para agregar un paquete, que debe ser implementado en las subclases
    public abstract boolean agregarPaquete(Paquete paquete, String destino);

    // Metodo que devuelve la cantidad de paquetes en la lista
    public Integer cantidadDePaquetes() {
        return paquetes.size();
    }

    // Metodo que verifica si un paquete cumple con las condiciones de peso y volumen
    protected Boolean condicionDePaquete(Paquete paquete) {
        return paquete.getPeso() < this.peso && paquete.getVolumen() <= this.volumen;
    }
}
