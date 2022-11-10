

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class AccesoBdatos {
	private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String database = "pedidos4nov22";
    private static String hostname = "localhost";
    private static String port = "3306";
	private static String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database +
									"?serverTimezone=Europe/Madrid";
    private static String username = "root";
    private static String password = "root";
   private static Connection conecta;
	
	public void conectar() throws SQLException, ClassNotFoundException {
		Class.forName(driver);
		conecta = DriverManager.getConnection(url, username, password);
	}
	
	public void desconectar() throws SQLException, ClassNotFoundException {
		
		conecta = null; // = conecta.close();
	}
	
	public ArrayList<Producto> productosCategoria(int categoria){
		try {
			ArrayList<Producto>lista=new ArrayList<>();
			String sentenciaSQL="SELECT * from productos where idCategoria=?";
			PreparedStatement ps=conecta.prepareStatement(sentenciaSQL);
			ps.setInt(1, categoria);
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				lista.add(new Producto(rs.getLong(1), rs.getString(2), rs.getLong(3), rs.getLong(4), rs.getString(5), rs.getDouble(6), rs.getInt(7)));
			}
			return lista;
		} catch (SQLException e) {
			//e.printStackTrace();
			return null;
		}
		
	}
	
	public int incrementarPrecioProducto (long idProducto, double porcentaje) {
		int resultado = 0;
		try {
			String sentenciaSQL="SELECT PrecioUnidad from productos where IdProducto=?";
			PreparedStatement ps=conecta.prepareStatement(sentenciaSQL);
			ps.setLong(1, idProducto);
			ResultSet rs= ps.executeQuery();
			Double percent = 0.0;
			while(rs.next()) {
				percent = rs.getDouble(1) + ((rs.getDouble(1)*porcentaje)/100);
				//percent = rs.getDouble(1)*porcentaje;
			}
			
			
			String sentenciaSQLupdate="UPDATE productos SET PrecioUnidad = ? where idProducto=?";
			PreparedStatement psUpdate=conecta.prepareStatement(sentenciaSQLupdate);
			psUpdate.setDouble(1, percent);
			psUpdate.setLong(2, idProducto);
			resultado = psUpdate.executeUpdate();
			//ResultSet rsUpdate = psUpdate.executeQuery();
			return resultado;
		} catch (SQLException e) {
			 //e.printStackTrace(); 
			return resultado;
		}
	}

public static Connection getConecta() {
		return conecta;
	}
	
	// COMPLETAR
}