package com.mmendoza;

public class Paquete {

    private Integer peso;
    private Double alto;
    private Double ancho;
    private Double profundidad;
    private String destino;

    public Paquete(Integer peso, Double alto, Double ancho, Double profundidad, String destino) {
        this.peso = peso;
        this.alto = alto;
        this.ancho = ancho;
        this.profundidad = profundidad;
        this.destino = destino;
    }

    public String destino() {
        return destino;
    }

    public Integer peso() {
        return peso;
    }

    public Double volumen() {
        return this.profundidad * this.alto * this.ancho;
    }
}
