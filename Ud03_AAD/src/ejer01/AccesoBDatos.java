package ejer01;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class AccesoBDatos {
	private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String database = "baloncesto";
    private static String hostname = "localhost";
    private static String port = "3306";
	private static String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database +
									"?serverTimezone=Europe/Madrid";
    private static String username = "root";
    private static String password = "root";
    private Connection conecta;
	
	public void conectar() throws SQLException, ClassNotFoundException {
		Class.forName(driver);
		conecta = DriverManager.getConnection(url, username, password);
	}
	
	public void desconectar() throws SQLException, ClassNotFoundException {
		conecta = null; // = conecta.close();
	}
	
	public boolean exportarJson() {
		List<Socio> socios = new ArrayList<Socio>();
		try {
			String sql = "SELECT * FROM socio";
			PreparedStatement ps = conecta.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				socios.add(new Socio(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5)));
			}
			FileWriter fw;
			fw = new FileWriter(new File("Ficheros\\Socios.json"));
			new Gson().toJson(socios, fw);
			fw.close();
		} catch (SQLException | IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
