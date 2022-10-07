package pregunta3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;

public class Pregunta3 {

	public static void main(String[] args) {
		Gson gson = new Gson();
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		int numEmpl = 0;
		float salTotal = 0;
		try {
			String fichero = new String(Files.readAllBytes(Paths.get("Ficheros//empleados.json")));
			List<Empleado> empleados = Arrays.asList(gson.fromJson(fichero, Empleado[].class));
			
			System.out.println("Introduzca el nombre de un oficcio:");
			String oficio = s.next();
			
			for (Empleado empleado : empleados) {
				if (empleado.getOficio().equalsIgnoreCase(oficio)) {
					numEmpl++;
					salTotal = empleado.getSalario() + salTotal;
				}
			}
			
			if (numEmpl == 0) {
				System.out.println("No existen empleados de oficio " + oficio.toUpperCase());
				System.exit(0);
			}
			
			System.out.println(numEmpl + " empleados con el oficio: " + oficio.toUpperCase());
			System.out.println("El saladio minimo de " + oficio.toUpperCase() + " es " + (salTotal/numEmpl));
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
