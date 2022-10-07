import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class Pregunta1 {

	@SuppressWarnings({ "unused", "resource" })
	public static void main(String[] args) {
		List<Libro> libros = new ArrayList<Libro>();
		File fichero = new File("Ficheros\\libros.dat");
		try {
			RandomAccessFile file = new RandomAccessFile(fichero, "rw");
			DataInputStream dis = new DataInputStream(new FileInputStream("Ficheros\\libros.dat"));
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero));
			
			 while (true) {
				libros.add((Libro) ois.readObject());
			}
			 
		} catch (EOFException | ClassNotFoundException e1 ) {
			//e1.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			XStream xstream = new XStream(new DomDriver("UTF-8"));
			xstream.alias("ListaLibros", List.class);
			xstream.alias("Libro", Libro.class);
			xstream.toXML(libros, new FileOutputStream("Ficheros\\Libros.xml"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
