package ejer01;

import java.sql.SQLException;

public class Ejer01Main {

	public static void main(String[] args) {
		AccesoBDatos abd = new AccesoBDatos();
		try {
			abd.conectar();
			abd.exportarJson();
			abd.desconectar();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
