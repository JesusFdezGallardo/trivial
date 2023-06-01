package com.example.trivial.modelo;

public class Jugador {

    private String nombre;

    private int aciertos;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAciertos() {
        return aciertos;
    }

    public void setAciertos(int aciertos) {
        this.aciertos = aciertos;
    }

    public Jugador(String nombre, int aciertos) {
        this.nombre = nombre;
        this.aciertos = aciertos;
    }
}
