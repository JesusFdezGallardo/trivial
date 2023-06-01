package com.example.trivial.modelo;


public class Pregunta {
    private String enunciado;
    private boolean respuesta;

    private String opcion1;
    private String opcion2;
    private String opcion3;
    private int respuestaCorrecta;

    private int dificultad;

    public Pregunta(String enunciado, boolean esVerdadera, int dificultad) {
        this.enunciado = enunciado;
        this.respuesta = esVerdadera;
        this.dificultad = dificultad;
    }

    public Pregunta(String enunciado, String opcion1, String opcion2, String opcion3, int respuestaCorrecta, int dificultad) {
        this.enunciado = enunciado;
        this.opcion1 = opcion1;
        this.opcion2 = opcion2;
        this.opcion3 = opcion3;
        this.respuestaCorrecta = respuestaCorrecta;
        this.dificultad = dificultad;
    }

    public String getOpcion1() {
        return opcion1;
    }

    public void setOpcion1(String opcion1) {
        this.opcion1 = opcion1;
    }

    public String getOpcion2() {
        return opcion2;
    }

    public void setOpcion2(String opcion2) {
        this.opcion2 = opcion2;
    }

    public String getOpcion3() {
        return opcion3;
    }

    public void setOpcion3(String opcion3) {
        this.opcion3 = opcion3;
    }

    public int getRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    public void setRespuestaCorrecta(int respuestaCorrecta) {
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public boolean isRespuesta() {
        return respuesta;
    }

    public void setRespuesta(boolean respuesta) {
        this.respuesta = respuesta;
    }

    public int getDificultad() {
        return dificultad;
    }

    public void setDificultad(int dificultad) {
        this.dificultad = dificultad;
    }
}
