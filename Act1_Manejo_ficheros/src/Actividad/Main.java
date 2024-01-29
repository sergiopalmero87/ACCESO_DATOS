package Actividad;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {

	private static Scanner sc = new Scanner(System.in);
	public static String NOMBRE_FICHERO = "articulos.dat";
	private static File file = new File(NOMBRE_FICHERO);
	private static List<Articulos> coleccionArticulos = new ArrayList<>();
	static ExportarCSV exportar = new ExportarCSV();
	static GestorArticulos gestor = new GestorArticulos();

	
	public static void main(String[] args){
		
		

		if (!file.exists()) {
			coleccionArticulos = new ArrayList<Articulos>();

			System.out.print("El fichero no existe. ¿Quieres crear uno?: Si / No --> ");
			String respuesta = sc.nextLine();

			if (respuesta.equalsIgnoreCase("si")) {
				menu();

			} else {
				System.out.println("Cerrando el programa. Adiós.");
				return;
			}

		} else {
			System.out.println("El fichero " + NOMBRE_FICHERO + " existe, vamos a leerlo:");
			coleccionArticulos = gestor.cargarColeccionDesdeFichero();
			menu();
		}

	}

	
	/**
	 * Muestra un menú de opciones y realiza acciones según la selección del usuario.
	 */
	public static void menu() {
		Scanner scanner = new Scanner(System.in);
		int opcion;

		do {
			System.out.println("\n*** Menú ***");
			System.out.println("1. Añadir nuevo artículo");
			System.out.println("2. Borrar artículo por id");
			System.out.println("3. Consultar artículo por id");
			System.out.println("4. Listado de todos los artículos");
			System.out.println("5. Exportar artículos a archivo CSV");
			System.out.println("6. Terminar el programa y crear el fichero");
			System.out.print("Seleccione una opción: ");

			opcion = scanner.nextInt();
			scanner.nextLine();

			switch (opcion) {
			case 1:
				gestor.agregarArticulo(file);
				break;
			case 2:
				gestor.borrarArticuloPorId();
				break;
			case 3:
				gestor.consultarArticuloPorId();
				break;
			case 4:
				gestor.listarArticulos();
				break;
			case 5:
				exportar.exportarACSV(coleccionArticulos);
				break;
			case 6:
				gestor.guardarColeccionEnFichero();
				System.out.println("Fin del programa.");
				return;
			default:
				System.out.println("Opción no válida. Inténtelo de nuevo.");
			}

		} while (opcion != 6);
		scanner.close();
	}
	
	
}
