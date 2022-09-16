package ejer03;

import java.io.File;
import java.io.IOException;

public class EjemploClaseFile02 {
	
	public static void main(String[] args) {
		boolean resultado;
		File directorio = new File("C:\\DAM2");
		resultado = directorio.mkdir();
		
		if(resultado) {
			System.out.println("Directorio creado");
		} else {
			System.out.println("No se pudo crear el directorio");
			System.exit(-1);
		}
		
		try{
			File fichero = new File ("C:\\DAM2\\Alberto.txt");
			resultado = fichero.createNewFile();
			if (resultado) {
				System.out.println("Archivo creado");
			} else {
				System.out.println("No se pudo crear el archivo");
			}
		} catch (IOException e) {
			System.out.println("Se produjo el error: " + e.getMessage());
		}

	}

}
