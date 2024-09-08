package com.mmendoza;

public class SalaDeCine {

    private Integer numeroDeFilas;
    private Integer numeroDeColumnas;
    private Integer[][] sala;

    public SalaDeCine(Integer numeroDeFilas, Integer numeroDeColumnas) {
        this.numeroDeFilas = numeroDeFilas;
        this.numeroDeColumnas = numeroDeColumnas;
        sala = new Integer[numeroDeFilas][numeroDeColumnas];
        this.cargarSala();
    }

    private void cargarSala() {
        for (int fila = 0; fila < this.numeroDeFilas; fila++) {
            for (int columna = 0; columna < this.numeroDeColumnas; columna++) {
                this.sala[fila][columna] = 0;
            }
        }
    }

    public Boolean estaVacia() {
        Boolean vacia = true;
        for (int fila = 0; fila < this.numeroDeFilas; fila++) {
            for (int columna = 0; columna < this.numeroDeColumnas; columna++) {
                if (this.sala[fila][columna] != 0) {
                    vacia = false;
                }
            }
        }
        return vacia;
    }

    public Boolean estaOcupado(Integer fila, Integer columna) {
        return this.sala[fila][columna] == 1;
    }

    public void tomarAsiento(Integer fila, Integer columna) {
        if (this.sala[fila][columna] != 1) {
            this.sala[fila][columna] = 1;
        }
    }

    public Integer contarAsientosOcupados() {
        Integer cuenta = 0;
        for (int fila = 0; fila < this.numeroDeFilas; fila++) {
            for (int columna = 0; columna < this.numeroDeColumnas; columna++) {
                if (this.sala[fila][columna] != 0) {
                    cuenta++;
                }
            }
        }
        return cuenta;
    }

    public Boolean acomodarAdyacentes(Integer espectadores) {
        Boolean posible = false;
        Integer cuenta = 0;
        for (int fila = 0; fila < this.numeroDeFilas; fila++) {
            for (int columna = 0; columna < this.numeroDeColumnas; columna++) {
                if (!this.estaOcupado(fila, columna))
                    cuenta++;
            }
            if (cuenta >= espectadores) {
                posible = true;
            }
            cuenta = 0;
        }
        return posible;
    }
}
