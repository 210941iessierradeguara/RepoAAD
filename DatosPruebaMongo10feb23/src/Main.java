import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Main {
	private static MongoClient mongo;
	private static MongoDatabase database;
	private static MongoCollection<Document> collection;

	private static void listarCorredores() {
		System.out.println("------------------------------Ej A--------------------------------");
		FindIterable<Document> lista = collection.find().sort(new Document("nombre", 1));
		for (Document d : lista) {
			System.out.println(d.getString("nombre") + " corrió "
					+ d.getInteger("distKm") + " km. en el mes de "
					+ d.getString("mes") + " en un tiempo de "
					+ d.getInteger("tiempoMin") + " minutos"
					);
		}
	} // de listarCorredores

	private static void listarCorredor(String corredor, String mes) {
		System.out.println("------------------------------Ej B-a------------------------------");
		FindIterable<Document> lista = collection.find(new Document("nombre", corredor).append("mes", mes));
		
		for (Document d : lista) {
			System.out.println(d.getString("nombre") + " corrió "
					+ d.getInteger("distKm") + " km. en el mes de "
					+ d.getString("mes") + " en un tiempo de "
					+ d.getInteger("tiempoMin") + " minutos"
					);
		}
	}// de listarCorredor

	private static void estadisticas(String corredor) {
		System.out.println("------------------------------Ej B-b------------------------------");
		FindIterable<Document> lista = collection.find(new Document("nombre", corredor));
		String nombre = null, id = null;
		int totSes = 0;
		int totKm = 0;
		int disMax = 0;
		int disMin = 0;
		double tempMed = 0;
		for (Document d : lista) {
			nombre = d.getString("nombre");
			totSes++;
			if(totSes == 1) {disMax = d.getInteger("distKm"); disMin = d.getInteger("distKm");}
			totKm = d.getInteger("distKm") + totKm;
			tempMed = d.getInteger("tiempoMin") + tempMed;
			if (d.getInteger("distKm") > disMax) {disMax = d.getInteger("distKm");}
			if (d.getInteger("distKm") < disMin) {disMin = d.getInteger("distKm");}
		}
		
		tempMed = tempMed / totSes;
		
		System.out.println(
				"Estádísticas: \n" 
		+ "Nombre: " + nombre + "\n"
		+ "Número de sesiones: " + totSes + "\n"
		+ "Total Km recorridos: " + totKm + "\n"
		+ "Distancia máxima recorrida: " + disMax + "\n"
		+ "Distancia mínima recorrida: " + disMin + "\n"
		+ "Tiempo medio: " + tempMed + "\n"
				);
		
	}// de estadisticas

	public static void main(String[] args) {

		//
		mongo = new MongoClient("localhost", 27017);
		database = mongo.getDatabase("test");
		//
		collection = database.getCollection("sesiones");
		System.out.println("[------------------------------------------------------------------------------]");
		 listarCorredores();
		 listarCorredor("Belén", "Marzo");
		 estadisticas("Clara");
		 System.out.println("[------------------------------------------------------------------------------]");
		mongo.close();
	}

}
