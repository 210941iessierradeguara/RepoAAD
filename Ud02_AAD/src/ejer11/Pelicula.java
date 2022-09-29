package ejer11;

public class Pelicula {
	int id;
	String titulo;
	int anyo;
	String decripcion;
	
	public Pelicula() {
		super();
	}

	public Pelicula(int id, String titulo, int anyo, String decripcion) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.anyo = anyo;
		this.decripcion = decripcion;
	}

	public int getAnyo() {
		return anyo;
	}


	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDecripcion() {
		return decripcion;
	}

	public void setDecripcion(String decripcion) {
		this.decripcion = decripcion;
	}

	@Override
	public String toString() {
		return "Pelicula [id=" + id + ", titulo=" + titulo + ", anyo=" + anyo + ", decripcion=" + decripcion + "]";
	}
}
