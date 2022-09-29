package ejer11;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import ejer10.Pelicula;

public class Ejer11ClaseEscr {

	public static void main(String[] args) {
		List<Pelicula> peliculas = new ArrayList<Pelicula>();
		peliculas.add(new Pelicula(1, "El señor de los anillos: La comunidad del anillo.", 2001, "Ambientada en la Tierra Media, cuenta la historia del Señor Oscuro Sauron, que está buscando el Anillo Único, el cual ha acabado en poder del hobbit Frodo Bolsón (Elijah Wood). El destino de la Tierra Media está en juego mientras Frodo y ocho compañeros que forman la Compañía del Anillo comienzan un largo y peligroso viaje hacia el Monte del Destino en la tierra de Mordor, que es el único lugar en el que el anillo puede ser destruido."));
		peliculas.add(new Pelicula(2, "El señor de los anillos: Las dos torres.", 2002, "La trama de la película comienza tras la disolución de la Compañía del Anillo. Boromir ha muerto a manos del jefe de los uruk-hai, Lurtz, en un intento de salvar a los hobbits Meriadoc Brandigamo y Peregrin Tuk, que acaban siendo capturados. Frodo Bolsón y Sam Gamyi parten solos hacia Mordor para destruir el Anillo Único en el Monte del Destino, mientras que Aragorn, Gimli y Legolas persiguen a los uruks con el fin de liberar a sus amigos capturados."));
		peliculas.add(new Pelicula(3, "El señor de los anillos: El retorno del rey.", 2003, "Trata sobre la última parte del viaje que emprendieron los nueve compañeros (de los cuales quedan solamente ocho) para salvar a la Tierra Media de la oscuridad impuesta por Sauron. En esta parte se decide el destino de todos los habitantes de estas tierras."));
		
		try {
			FileWriter fw = new FileWriter("Ficheros\\Peliculas.json");
			new Gson().toJson(peliculas, fw);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
