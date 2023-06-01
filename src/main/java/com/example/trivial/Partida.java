package com.example.trivial;

import com.example.trivial.modelo.Jugador;
import com.example.trivial.modelo.Pregunta;
import com.example.trivial.utils.Utils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class Partida {

    List<Pregunta> listaPreguntas;
    List<Jugador> listaJugadores;
    Jugador jugadorActual;
    Pregunta preguntaActual;
    int jugadorActualPosicion;

    public Partida(List<Pregunta> listaPreguntas, List<Jugador> listaJugadores) {
        this.listaPreguntas = listaPreguntas;
        this.listaJugadores = listaJugadores;
        if (!listaJugadores.isEmpty()) {
            this.jugadorActual = listaJugadores.get(0);
        }
        if (!listaPreguntas.isEmpty()) {
            this.preguntaActual = listaPreguntas.get(0);
        }
        this.jugadorActualPosicion = 0;
    }

    public static void main(String[] args) {
        SpringApplication.run(Partida.class, args);
        List<Pregunta> listaPreguntas = Utils.insertarPreguntas();
        List<Jugador> listaJugadors = Utils.listaUsuarios();

        Partida partida = new Partida(listaPreguntas, listaJugadors);
        partida.juego();
    }

    public void juego() {
        int totalPreguntas = listaPreguntas.size();
        Scanner sc = new Scanner(System.in);

        System.out.println("Bienvenido al Trivial. Es el turno del jugador  --> " +  jugadorActual.getNombre());
        Collections.shuffle(listaPreguntas);

        for (Pregunta pregunta : listaPreguntas) {
            if (pregunta.getDificultad() == 1) {
                imprimirPreguntaTrueFalse(pregunta);
                String respuesta = sc.next();
                boolean esRespuesta = comprobacionRespuesta(respuesta, pregunta);
                if (esRespuesta) {
                    sumarAciertos(pregunta.getDificultad());
                } else {
                    nextPlayer();
                }
            } else if (pregunta.getDificultad() == 2) {
                boolean salida = false;
                while (!salida) {
                    try {
                        imprimirPreguntaOpciones(pregunta);
                        int respuesta = sc.nextInt();
                        boolean esRespuesta = comprobacionRespuestaConOpciones(respuesta, pregunta.getRespuestaCorrecta());
                        if (esRespuesta) {
                            sumarAciertos(pregunta.getDificultad());
                        } else {
                            nextPlayer();
                        }
                        salida = true;
                    } catch (Exception exception) {
                        System.out.println("Introduce un valor entre 1 y 4");
                        sc.nextLine();
                    }
                }
            }
        }
        calcularAciertos(totalPreguntas, listaJugadores);
    }

    private static void calcularAciertos(int totalPreguntas, List<Jugador> listaJugadores) {
        System.out.println("El Total de puntos de los diferentes jugadores han sido --> ");
        listaJugadores.stream().forEach(jugador ->{
            System.out.println(jugador.getNombre());
            float porcentaje = (float) ((jugador.getAciertos()*100)/totalPreguntas);
            System.out.println("El nº total de puntos de " + jugador.getNombre() + " han sido ---> " + jugador.getAciertos());
            System.out.println("El total de preguntas ha sido --->" + totalPreguntas);
            System.out.println("El porcentaje de acierto ha sido de -->" + porcentaje + "%");
        });

    }
    private void sumarAciertos(int aciertos){
        int totalAciertos = aciertos+ listaJugadores.get(jugadorActualPosicion).getAciertos();
        this.jugadorActual.setAciertos(totalAciertos);
    }

    private static boolean comprobacionRespuestaConOpciones(int respuesta, int posicionRespuestaCorrecta) {
        boolean salida = false;
        if (respuesta == posicionRespuestaCorrecta) {
            salida = true;
            System.out.println("Respuesta Correcta");
        } else {
            System.out.println("Respuesta Incorrecta");
        }
        return salida;
    }

    private static boolean comprobacionRespuesta(String respuesta,
                                                 Pregunta pregunta) {
        boolean respuestaBoolean;
        boolean salida = false;
        try {
            if (respuesta.contains("T") || respuesta.contains("t")) {
                respuestaBoolean = true;
                salida = respuestaCoincide(respuestaBoolean, pregunta.isRespuesta());
            } else if (respuesta.contains("F") || respuesta.contains("f")) {
                respuestaBoolean = false;
                salida = respuestaCoincide(respuestaBoolean, pregunta.isRespuesta());
            } else {
                System.out.println("Respuesta Incorrecta al no introducir una respuesta alfabética entre T o F");
            }
        } catch (Exception ex) {
            throw new RuntimeException("Debe introducir una respuesta alfabética entre T o F");
        }
        return salida;
    }

    private static boolean respuestaCoincide(boolean respuestaUsuario, boolean preguntaBooleano) {
        boolean salidaRespuesta;
        if (respuestaUsuario == preguntaBooleano) {
            System.out.println("Respuesta Correcta");
            salidaRespuesta = true;
        } else {
            System.out.println("Respuesta Incorrecta");
            salidaRespuesta = false;
        }
        return salidaRespuesta;
    }

    private static void imprimirPreguntaOpciones(Pregunta pregunta){
        System.out.println("Elija la opción correcta escribiendo 1-2-3 o 4 en función de su respuesta");
        System.out.println(pregunta.getEnunciado());

        System.out.println(pregunta.getOpcion1());
        System.out.println(pregunta.getOpcion2());
        System.out.println(pregunta.getOpcion3());
    }

    private static void imprimirPreguntaTrueFalse(Pregunta pregunta){
        System.out.println(pregunta.getEnunciado());
        System.out.println("Pregunta del tipo Verdadero o Falso");
        System.out.println("Inserte T si es verdadero F si es false");
    }

    private void nextPlayer(){
        if (jugadorActualPosicion == listaJugadores.size()-1){
            jugadorActualPosicion = 0;
        } else{
            jugadorActualPosicion++;

        }
        jugadorActual = listaJugadores.get(jugadorActualPosicion);
        System.out.println("HAS FALLADO. Es el turno de " + jugadorActual.getNombre());
    }

}
