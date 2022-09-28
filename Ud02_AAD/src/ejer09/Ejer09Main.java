package ejer09;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

class Ejer09Main {
	
//	Adaptación de los ejemplos vistos en los materiales con la clase RandomAccessFile.
//	Realiza una clase UD2_9 que pida al usuario el identificador del profesor y lo borre del fichero
//	ProfesFPSierraGuara.dat. Borrar un dato simplemente consiste en poner su campo id dentro del
//	fichero a 0 para indicar que ese registro no existe y su posición está libre. Se deberá controlar
//	que:
//	- El identificador del profesor esté dentro de los límites del fichero.
//	- El identificador del profesor debe existir. Si ha sido borrado previamente se advertirá de
//	la situación.
//	- Antes de finalizar el código visualizar de manera secuencial todos los registros del
//	fichero para comprobar la operación.
	
	public static void main(String[] args) {
		File fichero = new File("Ficheros\\ProfesFPSierraGuara");
		Scanner s = new Scanner(System.in);
		try {
			RandomAccessFile file = new RandomAccessFile(fichero, "rw");
			
			System.out.println("Introduzca el Id del profesor a eliminar.");
			int id = s.nextInt();
			int posicion = (id-1)*56;
			file.seek(posicion);
			file.writeInt(0);
			
			if (posicion > file.length() - 56) {
				System.err.println("No existe profesor con tal identificación");
				System.exit(-1);
			}
			
			if(file.readInt()==0) {
				System.err.println("El profesor al que le pertenecía tal id ha sido borrado");
				System.exit(-1);
			}
			
			int departamento;
			Double antiguedad;
			char profesores[] = new char[20];
			System.out.println("Id    Nombre                 Departamento    Antigüedad");
			System.out.println("-------------------------------------------------------");
			
			file.seek(file.getFilePointer()-56);
			
			id = file.readInt();
			for (int i = 0; i < profesores.length; i++) {
				profesores[i] = file.readChar();
			}
			String profesor = new String(profesores);
			departamento = file.readInt();
			antiguedad = file.readDouble();
			System.out.println(id + " " + profesor + departamento + "                " + antiguedad);
			
			file.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
