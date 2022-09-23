package ejer06;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Ejer06Main {
	
//	Realiza una clase UD2_6 que indique cuántas veces aparece una palabra dentro de un
//	fichero de texto (puedes crearlo con el bloc de notas). Tanto el nombre del fichero como la
//	palabra se deben pasar como argumentos. No distinguir mayúsculas/minúsculas. Incluye
//	también tratamiento de excepciones.
//	Pistas:
//	- Métodos para cadenas substring e indexOf.
	
//	public static void main(String[] args) {
//		
//		try {
//			BufferedReader br = new BufferedReader(new FileReader("Ficheros\\" + args[0]));
//			ArrayList<String>palabras = new ArrayList<String>();
//			int palNum = 0;
//			String linea;
//			
//			while((linea = br.readLine())!=null) {
//				palabras.add(linea);
//			}
//			
//			br.close();
//			
//			for(String palabra : palabras) {
//				if (palabra.equalsIgnoreCase(args[1])) {
//					palNum++;
//				}
//			}
//			
//			System.out.println("El número de veces que la palabra " + args[1] + " está en este fichero es de: " + palNum);
//			
//		} catch (FileNotFoundException e) {
//			System.err.println("No se ha encontrado el fichero " + args[1]);
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//	}
	
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		
		try {
			System.out.print("Pon una palabra a buscar en el texto: ");
			String palabra_a_buscar = s.next();
			BufferedReader br = new BufferedReader(new FileReader("Ficheros\\lorem01"));
			String linea;
			String texto = "";
			int contador = 0;
			while ((linea = br.readLine()) != null) {
				texto += linea + " ";
			}
			StringTokenizer st = new StringTokenizer(texto, " ");
			while (st.hasMoreTokens()) {
				if (st.nextToken().equalsIgnoreCase(palabra_a_buscar)) {
					contador++;
				}
			}
			if (contador == 0) {
				System.out.println("No se ha encontrado '" + palabra_a_buscar + "' en el texto.");
			} else if (contador == 1) {
				System.out.println("La palabra '" + palabra_a_buscar + "' se ha encontrado " + contador + " vez.");
			} else {
				System.out.println("La palabra '" + palabra_a_buscar + "' se ha encontrado " + contador + " veces.");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


}
