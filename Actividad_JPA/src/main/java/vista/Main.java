package vista;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.sql.Date;

import entidad.Autor;
import entidad.Editorial;
import entidad.Libro;
import gestor.GestorAutor;
import gestor.GestorEditorial;

public class Main {

	private static GestorAutor ga = new GestorAutor();
	private static GestorEditorial ge = new GestorEditorial();
	private static List<Libro> coleccionLibros = new ArrayList<Libro>();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Bienvenidos a nuestro programa");
		
		addAutor();
		
		System.out.println(ga.autoresLibros());  
		
		
		//Editoriales
		Editorial e = new Editorial();
		
		System.out.println("Agregue nombre");
		System.out.println("Introduzca el nombre:");
		String nombreEditorial = sc.nextLine();

		System.out.println("Introduzca direccion:");
		String direccion = sc.nextLine();
		
		e.setName(nombreEditorial);
		e.setDireccion(direccion);
		
		boolean agregarEditorial = ge.agregar(e);
		if(agregarEditorial) {
			System.out.println("La editorial se ha agregado correctamente");
		} else {
			System.out.println("La editorial no se ha agregado");
		}

	}
	
	private static boolean addAutor() {
		
		int contador = 3;
		
		do {
			Autor a = new Autor();
			Scanner sc = new Scanner(System.in);

			System.out.println("Agregue autor");
			System.out.println("Introduzca el nombre:");
			String nombre = sc.nextLine();

			System.out.println("Introduzca el apellido:");
			String apellido = sc.nextLine();

			System.out.println("Introduzca la fecha de nacimiento (formato: yyyy-mm-dd):");
			String fechaNacimientoStr = sc.nextLine();

			// Convertir la fecha de nacimiento a un objeto Date
			Date fechaNacimiento = Date.valueOf(fechaNacimientoStr);

			a.setName(nombre);
			a.setApellidos(apellido);
			a.setBorn(fechaNacimiento);
			a.setColeccionLibros(coleccionLibros);
			
			boolean agregarAutor = ga.agregar(a);
			if (agregarAutor) {
				System.out.println("El usuario se ha agregado correctamente");
			} else {
				System.out.println("El usuario no se ha agregado");
			}
			contador --;
			
		}while (contador > 0);
		
		
		return true;
	}

}
