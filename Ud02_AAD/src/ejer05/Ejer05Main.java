package ejer05;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Ejer05Main {
	
//	Realiza una clase UD2_5 que sea capaz de ordenar alfabéticamente las líneas contenidas
//	en un fichero de texto (puedes crearlo con el bloc de notas). El nombre del fichero que contiene
//	las líneas se debe pasar como argumento. El nombre del fichero resultado ya ordenado debe ser
//	el mismo que el original añadiéndole la coletilla _sort al nombre. Incluye también tratamiento
//	de excepciones.
	
//	Pistas:
//		- Utiliza una colección (p.ej. ArrayList) donde guardar las líneas leídas del fichero y el
//		método estático Collections.sort para ordenar dicha colección.
//		- Para formar el nuevo nombre de fichero puedes usar el método para cadenas substring.
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		ArrayList<String>palabras = new ArrayList<String>();
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("Ficheros\\" + args[0] + "_sort.txt"));
			BufferedReader br = new BufferedReader(new FileReader("Ficheros\\" + args[0]));
			String linea;
			while((linea = br.readLine())!=null) {
				palabras.add(linea);
			}
			Collections.sort(palabras); //https://stackoverflow.com/questions/5815423/sorting-arraylist-in-alphabetical-order-case-insensitive
			br.close();
			
			for(String palabra : palabras) {
				bw.write(palabra);
				bw.newLine();
			}
			bw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
