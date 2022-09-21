package ejer04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ejer04Main {
//	Realiza una clase UD2_4 que guarde en un fichero con nombre pares.txt los números
//	pares que hay entre 0 y 500, un número en cada línea del fichero. Seguidamente lee el fichero y
//	muéstralo por la consola. Incluye también tratamiento de excepciones.

	public static void main(String[] args) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("Ficheros\\pares.txt"));
			BufferedReader br = new BufferedReader(new FileReader("Ficheros\\pares.txt"));
			String iNum;
			for(int i = 0; i <= 500; i++) {
				if (i % 2 == 0) {
					iNum = Integer.toString(i);
					bw.write(iNum);
					bw.newLine();
				}
			}
			bw.close();
			String linea;
			while((linea = br.readLine()) != null) {
				System.out.println(linea);
			}
			br.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
