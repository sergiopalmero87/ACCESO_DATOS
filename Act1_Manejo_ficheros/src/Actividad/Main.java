package Actividad;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	static List<Articulos> coleccionArticulos = new ArrayList<Articulos>();
	static File file = new File(EscrituraFichero.NOMBRE_FICHERO);
	static LecturaFichero leer = new LecturaFichero();
	static EscrituraFichero escribir = new EscrituraFichero();

	public static void main(String[] args) throws IOException {

		Articulos articulo = new Articulos();
		int opcion = 0;

		// Averiguamos si el fichero articulos.dat existe.
		if (!file.exists()) {
			// Si no exite dejamos el ArrayList vacio
			System.out.println("El fichero no existe.");
			coleccionArticulos = new ArrayList<Articulos>();

		} else {
			System.out.println("Leyendo el fichero " + file.getName());
			System.out.println(leer.leerFichero(file));
			 
		}

	}


	// Menu
	public static void menu(int opcion) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Elige que quieres hacer: \n");
		System.out.println("Opcion 1: Añadir nuevo artículo");
		System.out.println("Opcion 2: Borrar artículo por id");
		System.out.println("Opcion 3: Consulta artículo por id");
		System.out.println("Opcion 4: Consulta artículo por id");
		System.out.println("Opcion 5: Exportar artículos a archivo CSV");
		System.out.println("Opcion 6: Salir del programa");

		opcion = sc.nextInt();

		switch (opcion) {

		case 1: // Añadir nuevo articulo
			Articulos nuevoArticulo = new Articulos();
			// New ID
			System.out.println("ID:");
			int id = sc.nextInt();
			sc.nextLine();
			nuevoArticulo.setId(id);

			// New Name
			System.out.println("NAME:");
			String name = sc.nextLine();
			nuevoArticulo.setName(name);

			// New Description
			System.out.println("DESCRIPTION:");
			String description = sc.nextLine();
			nuevoArticulo.setDescription(description);

			// New Stock
			System.out.println("STOCK:");
			int stock = sc.nextInt();
			sc.nextLine();
			nuevoArticulo.setStock(stock);

			// New price
			System.out.println("PRICE:");
			double price = sc.nextDouble();
			nuevoArticulo.setPrice(price);

			System.out.println("\nEl nuevo articulo creado es: " + nuevoArticulo + "\n");
			// coleccionArticulos = escribir.escribirFichero(nuevoArticulo,
			// coleccionArticulos);

			break;

		case 2: // Borrar articulo por ID
			break;

		case 3: // Consultar articulo por ID
			break;

		case 4: // Listar articulos
			break;

		case 5: // Terminar programa
			break;

		default: // Mostrar error

		}

	}

}
