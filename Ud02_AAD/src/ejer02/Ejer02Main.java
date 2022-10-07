package ejer02;

import java.io.File;
import java.util.Scanner;

public class Ejer02Main {
	/*Realiza una clase UD2_2 cuyo método principal reciba como argumento una cadena con
	la trayectoria de un directorio o fichero e indique si existe realmente o no dicho directorio o
	fichero. Si el método principal no recibe ningún argumento se indicará por pantalla y finalizará
	su ejecución.*/
	
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
		if (args.length!=0) {
			String ruta = args[0];
			System.out.print("Existe: ");
			System.out.println(existe(ruta));
		} else {
			System.out.println("No ha introducido argumentos");
			System.exit(-1);
		}
		
		
	}

}
