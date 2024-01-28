package Actividad;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestorArticulos {
	
	
	private static Scanner sc = new Scanner(System.in);
	public static String NOMBRE_FICHERO = "articulos.dat";
	private static File file = new File(NOMBRE_FICHERO);
	private static List<Articulos> coleccionArticulos = new ArrayList<>();
	static ExportarCSV exportar = new ExportarCSV();
	
	/**
	 * Carga una colección de artículos desde un archivo.
	 *
	 * @param file El archivo desde el cual cargar la colección.
	 * @return Una lista de artículos cargada desde el archivo.
	 */
	public List<Articulos> cargarColeccionDesdeFichero(File file) {

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

	
	
	/**
	 * Guarda la colección de artículos en un archivo.
	 */
	public void guardarColeccionEnFichero() {
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

	

	/**
	 * Agrega un nuevo artículo a la colección.
	 *
	 * @param file El archivo en el cual se guarda la colección.
	 * @param coleccionArticulos La colección de artículos a la que se agregará el nuevo artículo.
	 */
	public void agregarArticulo(File file, List<Articulos> coleccionArticulos) {
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

	
	
	
	
	/**
	 * Borra un artículo de la colección por su ID.
	 */
	public void borrarArticuloPorId() {
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


	
	/**
	 * Consulta un artículo por su ID en la colección y lo muestra.
	 */
	public void consultarArticuloPorId() {
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

	
	
	/**
	 * Muestra todos los artículos en la colección.
	 */
	public void listarArticulos() {
		System.out.println("Listado de todos los artículos:");
		if (!coleccionArticulos.isEmpty()) {
			for (Articulos articulo : coleccionArticulos) {
				System.out.println(articulo);
			}
		} else {
			System.out.println("La colección está vacia " + coleccionArticulos);
		}

	}

	
	
	/**
	 * Verifica si existe un artículo con el ID proporcionado en la colección.
	 *
	 * @param id El ID del artículo a verificar.
	 * @return true si existe un artículo con el ID dado, false en caso contrario.
	 */
	public boolean existeArticuloConId(int id) {
		for (Articulos articulo : coleccionArticulos) {
			if (articulo.getId() == id) {
				return true;
			}
		}
		return false;
	}

}
