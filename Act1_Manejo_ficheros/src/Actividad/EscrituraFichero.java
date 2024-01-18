package Actividad;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class EscrituraFichero {

	public static final String NOMBRE_FICHERO = "articulos.dat";
	static List<Articulos> coleccionArticulos = new ArrayList<>();

	public static void main(String[] args) {
		System.out.println("Creacion de fichero " + NOMBRE_FICHERO + ":\n");
		Articulos articulo = new Articulos(0, "sopa", "sopa", 12, 1);

		// Autoclose
		// Si ponemos (nombreFichero,true) add en vez de borrar
		// se escribe en el fichero pero no se borra su contenido
		// para escribir objetos a fichero debemos de usar estas clases
		try (FileOutputStream file = new FileOutputStream(NOMBRE_FICHERO, true);
				ObjectOutputStream escritor = new ObjectOutputStream(file);) {
			escritor.writeObject(articulo);
			coleccionArticulos.add(articulo);

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("No se ha podido abrir el fichero");
			System.out.println(e.getMessage());
			return;
		}

		System.out.println("Fichero creado y rellenado:");

		for (Articulos a : coleccionArticulos) {

			System.out.println(a);
		}

	}

	public static String escribirFichero(Articulos articulo, String file) {

		file = NOMBRE_FICHERO;

		System.out.println("Creacion de fichero " + NOMBRE_FICHERO + ":\n");

		// Autoclose
		// Si ponemos (nombreFichero,true) add en vez de borrar
		// se escribe en el fichero pero no se borra su contenido
		// para escribir objetos a fichero debemos de usar estas clases
		try (FileOutputStream fichero = new FileOutputStream(file, true);
				ObjectOutputStream escritor = new ObjectOutputStream(fichero);) {
			escritor.writeObject(articulo);
			coleccionArticulos.add(articulo);
			System.out.println(coleccionArticulos);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("No se ha podido abrir el fichero");
			System.out.println(e.getMessage());

		}

		return "El articulo " + articulo + " se ha añadido al fichero " + NOMBRE_FICHERO;

	}

}
