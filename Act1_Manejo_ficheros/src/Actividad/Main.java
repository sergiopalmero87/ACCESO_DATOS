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
	static ExportarCSV exportar;

	public static void main(String[] args) throws FileNotFoundException, IOException {

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
			coleccionArticulos = cargarColeccionDesdeFichero(file);
			menu();
		}

	}

	private static List<Articulos> cargarColeccionDesdeFichero(File file) {

		// Creamos una lista aux en la que cargamos los datos del fichero
		List<Articulos> coleccionArticulos = new ArrayList<>();

		// Abrimos fichero para lectura
		// fis crea un canal de comunicación con el file, 
		// ois es lo que lee de fis y luego lo guardamos en coleccionArticulos 
		try (FileInputStream fis = new FileInputStream(file); 
				ObjectInputStream ois = new ObjectInputStream(fis)) {

			try {
				// en la coleccion escribimos los datos del fichero
				// hay que castearlo
				coleccionArticulos = (List<Articulos>) ois.readObject();
				
				if(coleccionArticulos.isEmpty()) {
					System.out.println("El fichero existe pero está vacio.");
				}

				// foreach de articulos en la coleccion y los imprimimos
				for (Articulos a : coleccionArticulos) {
					System.out.println(a);
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			System.out.println("No se ha podido abrir el fichero");
			System.out.println(e.getMessage());
		}
		return coleccionArticulos;

	}

	private static void guardarColeccionEnFichero() {
		//Escribimos en fichero. 
		//Con el objeto oos escribimos en el fichero lo que contengan los parentesis.
		//en este caso escribimos en el fichero la coleccion de articulos.
		try (FileOutputStream fos = new FileOutputStream(file); 
				ObjectOutputStream oos = new ObjectOutputStream(fos);) {
			oos.writeObject(coleccionArticulos);
			System.out.println("Fichero creado y guardado correctamente.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void menu() {
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
				agregarArticulo(file, coleccionArticulos);
				break;
			case 2:
				borrarArticuloPorId();
				break;
			case 3:
				consultarArticuloPorId();
				break;
			case 4:
				listarArticulos();
				break;
			case 5:
				exportar.exportarACSV(coleccionArticulos);
				break;
			case 6:
				guardarColeccionEnFichero();
				System.out.println("Fin del programa.");
				return;
			default:
				System.out.println("Opción no válida. Inténtelo de nuevo.");
			}

		} while (opcion != 6);
	}

	private static void agregarArticulo(File file, List<Articulos> coleccionArticulos) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Ingrese los datos del nuevo artículo:");
		int id;
		do {
			System.out.print("ID: ");
			id = sc.nextInt();
			sc.nextLine();
			//Llamamos a la funcion para comprobar id. 
			//Si ya existe se repite el bucle y avisamos al usuario. 
			//Una vez que el id sea distinto entramos.
			if (existeArticuloConId(id)) {
				System.out.println("Ya existe un artículo con ese ID. Inténtelo de nuevo.");
			}
		} while (existeArticuloConId(id));

		System.out.println("NAME:");
		String name = sc.nextLine();

		System.out.println("DESCRIPTION:");
		String description = sc.nextLine();

		System.out.println("PRICE:");
		double price = sc.nextDouble();

		System.out.println("STOCK:");
		int stock = sc.nextInt();
		sc.nextLine();

		Articulos nuevoArticulo = new Articulos(id, name, description, price, stock);
		coleccionArticulos.add(nuevoArticulo);
		System.out.println("Objeto guardado");

	}

	private static void borrarArticuloPorId() {
		Scanner scanner = new Scanner(System.in);
		
		if(coleccionArticulos.isEmpty()) {
			System.out.println("Todavia no hay ningun articulo guardado");
			return;
		}

		System.out.print("Ingrese el ID del artículo a borrar: ");
		int idBorrar = scanner.nextInt();
		scanner.nextLine();

		for (Articulos a : coleccionArticulos) {

			if (a.getId() == idBorrar) {
				System.out.println("Articulo borrado: " + a);
				coleccionArticulos.remove(a);
				return;
			}

		}

	}

	private static void consultarArticuloPorId() {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Ingrese el ID del artículo a consultar: ");
		int idConsultar = scanner.nextInt();
		scanner.nextLine();

		for (Articulos articulo : coleccionArticulos) {
			if (articulo.getId() == idConsultar) {
				System.out.println(articulo);
				return;
			}
		}

		System.out.println("No se encontró ningún artículo con ese ID.");
	}

	private static void listarArticulos() {
		System.out.println("Listado de todos los artículos:");
		if (!coleccionArticulos.isEmpty()) {
			for (Articulos articulo : coleccionArticulos) {
				System.out.println(articulo);
			}
		} else {
			System.out.println("La colección está vacia " + coleccionArticulos);
		}

	}

	// Comprobamos que los id no sean iguales
	//Comprobamos mediante un boolean si el id existe.
	private static boolean existeArticuloConId(int id) {
		for (Articulos articulo : coleccionArticulos) {
			if (articulo.getId() == id) {
				return true;
			}
		}
		return false;
	}
}
