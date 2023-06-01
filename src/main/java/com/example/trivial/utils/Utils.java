package com.example.trivial.utils;

import com.example.trivial.modelo.Jugador;
import com.example.trivial.modelo.Pregunta;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static List<Pregunta> insertarPreguntas() {
        List<Pregunta> salida = new ArrayList<>();

        Pregunta pregunta = new Pregunta("Francia es un país de la UE", true, 1);
        salida.add(pregunta);

        Pregunta pregunta2 = new Pregunta("La caja negra de un avión es negra", false, 1);
        salida.add(pregunta2);

        Pregunta pregunta3 = new Pregunta("Marrakech es la capital de Marruecos", false, 1);
        salida.add(pregunta3);

        Pregunta pregunta4 = new Pregunta("Mónaco es el país más pequeño del mundo", false, 1);
        salida.add(pregunta4);

        Pregunta pregunta5 = new Pregunta("El rugido de un león puede oírse hasta a ocho kilómetros de distancia", true, 1);
        salida.add(pregunta5);
//
//        Pregunta pregunta6 = new Pregunta("La Gran Muralla China es más larga que la distancia entre Londres y Pekín", true, 1);
//        salida.add(pregunta6);
//
//        Pregunta pregunta7 = new Pregunta("El unicornio es el animal nacional de Escocia", true, 1);
//        salida.add(pregunta7);
//
//        Pregunta pregunta8 = new Pregunta("El signo zodiacal Acuario está representado por un tigre", false, 1);
//        salida.add(pregunta8);
//
//        Pregunta pregunta9 = new Pregunta("La acrofobia es el miedo al ajo", true, 1);
//        salida.add(pregunta9);
//
//        Pregunta pregunta10 = new Pregunta("El número atómico del litio es 17", false, 1);
//        salida.add(pregunta10);

        Pregunta pregunta11 = new Pregunta("¿De qué país es originario el queso brie?", "Francia", "Alemania", "España", 1, 2);
        salida.add(pregunta11);

        Pregunta pregunta12 = new Pregunta("¿¿Cuál es la moneda de México?", "Peso Mexicano", "Dolar", "Euro", 1, 2);
        salida.add(pregunta12);

        Pregunta pregunta13 = new Pregunta("¿De qué colores es la bandera de Japón?", "Negro y Amarillo", "Azul y Rojo", "Blanco y Rojo", 3, 2);
        salida.add(pregunta13);

        Pregunta pregunta14 = new Pregunta("¿Cómo se llaman las crías de los conejos?", "Conejo pequeño", "Gazapos", "Teletubbie", 2, 2);
        salida.add(pregunta14);

        return salida;

    }

    public static List<Jugador> listaUsuarios(){
        List<Jugador> salida = new ArrayList<>();
        salida.add(new Jugador("Jesus", 0));
        salida.add(new Jugador("David", 0));
        return salida;
    }
}
