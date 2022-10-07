package pregunta1;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;

public class ListaLibros {
	
	private List<Libro> lista = new ArrayList<Libro>();
	public ListaLibros(){ }
	public void add(Libro libro){
		lista.add(libro);
	}
	public List<Libro> getListaLibros() {
		return lista;
	}

}
