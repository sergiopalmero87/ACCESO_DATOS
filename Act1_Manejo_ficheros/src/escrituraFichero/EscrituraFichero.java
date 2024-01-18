package escrituraFichero;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import articulos.Articulos;

public class EscrituraFichero {

	public static final String NOMBRE_FICHERO = "articulos.dat";
	static List<Articulos> coleccionArticulos = new ArrayList<>();

	public static void main(String[] args) {
		System.out.println("Escritura de fichero " + NOMBRE_FICHERO + ":\n");

		// Creamos objeto Articulos
		Articulos articulo = new Articulos(0, "sopa", "sopa", 12, 1);
		Articulos articulo1 = new Articulos(1, "sopa1", "sopa1", 12, 1);

		// Autoclose
		// Si ponemos (nombreFichero,true) add en vez de borrar
		// Abrir fichero para escritura
		// para escribir objetos a fichero debemos de usar estas clases
		try (FileOutputStream file = new FileOutputStream(NOMBRE_FICHERO, true);
				ObjectOutputStream escritor = new ObjectOutputStream(file);) {
			escritor.writeObject(articulo);
			escritor.writeObject(articulo1);
			
			coleccionArticulos.add(articulo);
			coleccionArticulos.add(articulo1);
			
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("No se ha podido abrir el fichero");
			System.out.println(e.getMessage());
			return;
		}

		System.out.println("Fichero creado y rellenado:");
		for(Articulos a : coleccionArticulos) {
			System.out.println(a);
		}
		
	}

}
