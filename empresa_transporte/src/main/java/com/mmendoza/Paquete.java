package com.mmendoza;

public class Paquete {

    private Integer peso;

    private Double alto;

    private Double ancho;

    private Double profundidad;

    public Paquete(Integer peso, Double profundidad, Double alto, Double ancho) {
        this.peso = peso;
        this.profundidad = profundidad;
        this.alto = alto;
        this.ancho = ancho;
    }

    public Integer peso() {
        return peso;
    }

    public Double volumen() {
        return alto * ancho * profundidad;
    }
}
