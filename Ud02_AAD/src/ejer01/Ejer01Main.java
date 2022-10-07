package ejer01;

import java.io.File;

public class Ejer01Main {
	/*UD2.1 Realiza una clase UD2_1 que muestre nombre, longitud, si se puede leer, si se puede
	escribir de todos los archivos ocultos de la carpeta Windows de tu disco; sólo de los que se
	encuentran en la carpeta principal de Windows, no en sus subcarpetas.*/
	public static void main(String[] args) {
		File file = new File ("c:\\windows");
		System.out.println("Ruta :" + file.getPath());
		File[] archivos = file.listFiles();
		for (File archivo : archivos) {
			if(archivo.isHidden()) {
				System.out.println("Nombre: " + archivo.getName());
				System.out.println("Longitud: " + archivo.length());
				System.out.println("Leíble: " + archivo.canRead());
				System.out.println("Escribible: " + archivo.canWrite());
				System.out.println();
			}
		}
	}

}
