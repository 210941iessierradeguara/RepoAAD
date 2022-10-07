package ejer03;

import java.io.File;
import java.io.IOException;

public class Ejer03Main {
/*	Realiza una clase UD2_3 que complete la clase EjemploClaseFile02 de los materiales
	borrando el directorio y el fichero creados en ella (primero borra el fichero y después el
	directorio pues no se permite borrar directorios no vacíos).
*/
	
	
	public static void main(String[] args) {
		boolean resultado;
		File fichero = new File("C:\\DAM2\\Alberto.txt");
		resultado = fichero.delete();
		
		if(resultado) {
			System.out.println("Archivo borrado");
		} else {
			System.out.println("No se pudo borrar el archivo");
			System.exit(-1);
		}
		
		File directorio = new File ("C:\\DAM2");
		resultado = directorio.delete();
		if (resultado) {
			System.out.println("Directorio borrado");
		} else {
			System.out.println("No se pudo borrar el directorio");
		}
	}

}
