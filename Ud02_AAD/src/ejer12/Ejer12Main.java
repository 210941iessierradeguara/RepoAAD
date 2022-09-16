package ejer12;

import java.io.File;
import java.util.Scanner;

public class Ejer12Main {

	/*Realiza una clase UD2_12 con un método principal que reciba dos argumentos, un
	directorio y una extensión de fichero, e indique los datos (nombre, tamaño y fecha de creación)
	de los ficheros del directorio que tienen esa extensión. Pista: Interfaz FilenameFilter. Deberá
	comprobarse al principio del código que el directorio enviado como primer argumento existe,
	en caso contrario se indicará y finalizará su ejecución.*/
	
	public static boolean existe(String ruta) {
		Boolean existe = false;
		File f = new File(ruta);
		
		if (f.exists()) {
			existe = true;
		}
		
		return existe;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		if (args.length > 1) {
			String ruta = args[0];
			System.out.print("Existe: ");
			System.out.println(existe(ruta));
			File fRuta = new File(ruta);
			
			File[] archivos = fRuta.listFiles();
				for(File archivo : archivos) {
					
				}
			
			
		} else {
			System.out.println("No ha introducido argumentos suficientes");
			System.exit(-1);
		}

	}

}
