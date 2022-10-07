package ejer10;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;

public class Ejer10ClaseLec {

	public static void main(String[] args) {
		List<Pelicula> peliculas = new ArrayList<Pelicula>();
		XStream xstream = new XStream(); 
		xstream.alias("Peliculas", peliculas.getClass());
		xstream.alias("Pelicula", Pelicula.class);
		
		
		try {
			List<Pelicula> todos;
			todos = (List<Pelicula>) xstream.fromXML(new FileInputStream("Ficheros\\Peliculas.xml"));
			
			System.out.println("Cantidad de películas: " + todos.size());
			
			for (Pelicula p: todos) {
				System.out.println(p);
			}
			System.out.println("Fin del listado");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
