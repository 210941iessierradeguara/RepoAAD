package ejer01;

import java.io.File;

public class Ejer01Main {

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
