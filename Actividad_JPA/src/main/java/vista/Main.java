package vista;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.sql.Date;

import entidad.Autor;
import entidad.Editorial;
import entidad.Libreria;
import entidad.Libro;
import gestor.GestorAutor;
import gestor.GestorEditorial;
import gestor.GestorLibreria;
import gestor.GestorLibro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {

	private static GestorAutor ga = new GestorAutor();
	private static GestorEditorial ge = new GestorEditorial();
	private static GestorLibro gl = new GestorLibro();
	private static GestorLibreria glibreria = new GestorLibreria();
	private static List<Libro> libros = new ArrayList<Libro>();
	private static Scanner sc = new Scanner(System.in);
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ActividadJPA");;
	private static EntityManager em = emf.createEntityManager();

	public static void main(String[] args) {

		System.out.println("Bienvenidos a nuestro programa");
		System.out.println("Vamos a agregar 3 autores");
		addAutor();
		System.out.println("==================================");
		System.out.println("Ahora vamos a agregar 2 editoriales");
		addEditorial();

		System.out.println("==================================");
		System.out.println("Ahora vamos a agregar 8 libros");
		addLibro();

		System.out.println("==================================");
		System.out.println("Ahora vamos a agregar 2 librerias");
		addLibreria();
	}

	private static boolean addAutor() {

		int contador = 3;

		do {
			Autor a = new Autor();

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

			boolean agregarAutor = ga.agregar(a);
			if (agregarAutor) {
				System.out.println("El usuario se ha agregado correctamente");
			} else {
				System.out.println("El usuario no se ha agregado");
			}
			contador--;
			System.out.println("Autores por añadir: " + contador);

		} while (contador > 0);
		System.out.println("Los autores se han añadido a la BBDD");
		return true;
	}

	private static void addEditorial() {
		int contador = 2;
		do {
			Editorial e = new Editorial();

			System.out.println("Introduzca el nombre:");
			String nombreEditorial = sc.nextLine();

			System.out.println("Introduzca la direccion:");
			String direccion = sc.nextLine();

			e.setName(nombreEditorial);
			e.setDireccion(direccion);

			boolean agregarEditorial = ge.agregar(e);
			if (agregarEditorial) {
				System.out.println("La editorial se ha agregado correctamente");
			} else {
				System.out.println("La editorial no se ha agregado");
			}
			contador--;
			System.out.println("Editoriales por añadir " + contador);
		} while (contador > 0);

	}

	private static void addLibro() {
		// Obtener los autores y editoriales existentes de la base de datos
		Autor a1 = em.find(Autor.class, 1);
		Autor a2 = em.find(Autor.class, 2);
		Autor a3 = em.find(Autor.class, 3);
		Editorial e1 = em.find(Editorial.class, 1);
		Editorial e2 = em.find(Editorial.class, 2);

		// Crear libros y relacionarlos con autores y editoriales
		Libro libro1 = new Libro();
		System.out.println("Introduce el nombre:");
		String nombre = sc.nextLine();

		System.out.println("Introduce el precio");
		double precio = sc.nextDouble();
		sc.nextLine();

		libro1.setName(nombre);
		libro1.setPrice(precio);
		libro1.setAutor(a1);
		libro1.setEditorial(e1);

		boolean agregarLibro = gl.agregar(libro1);
		if (agregarLibro) {
			System.out.println("El libro 1 se ha agregado correctamente");
		} else {
			System.out.println("El libro 1 no se ha agregado");
		}

		Libro libro2 = new Libro();
		System.out.println("Introduce el nombre:");
		String nombre2 = sc.nextLine();

		System.out.println("Introduce el precio");
		double precio2 = sc.nextDouble();
		sc.nextLine();

		libro2.setName(nombre2);
		libro2.setPrice(precio2);
		libro2.setAutor(a1);
		libro2.setEditorial(e1);

		boolean agregarLibro2 = gl.agregar(libro2);
		if (agregarLibro2) {
			System.out.println("El libro 2 se ha agregado correctamente");
		} else {
			System.out.println("El libro 2 no se ha agregado");
		}

		Libro libro3 = new Libro();
		System.out.println("Introduce el nombre:");
		String nombre3 = sc.nextLine();

		System.out.println("Introduce el precio");
		double precio3 = sc.nextDouble();
		sc.nextLine();

		libro3.setName(nombre3);
		libro3.setPrice(precio3);
		libro3.setAutor(a2);
		libro3.setEditorial(e2);

		boolean agregarLibro3 = gl.agregar(libro3);
		if (agregarLibro3) {
			System.out.println("El libro 3 se ha agregado correctamente");
		} else {
			System.out.println("El libro 3 no se ha agregado");
		}

		Libro libro4 = new Libro();
		System.out.println("Introduce el nombre:");
		String nombre4 = sc.nextLine();

		System.out.println("Introduce el precio");
		double precio4 = sc.nextDouble();
		sc.nextLine();

		libro4.setName(nombre4);
		libro4.setPrice(precio4);
		libro4.setAutor(a2);
		libro4.setEditorial(e2);

		boolean agregarLibro4 = gl.agregar(libro4);
		if (agregarLibro4) {
			System.out.println("El libro 4 se ha agregado correctamente");
		} else {
			System.out.println("El libro 4 no se ha agregado");
		}

		Libro libro5 = new Libro();
		System.out.println("Introduce el nombre:");
		String nombre5 = sc.nextLine();

		System.out.println("Introduce el precio");
		double precio5 = sc.nextDouble();
		sc.nextLine();

		libro5.setName(nombre5);
		libro5.setPrice(precio5);
		libro5.setAutor(a3);
		libro5.setEditorial(e1);

		boolean agregarLibro5 = gl.agregar(libro5);
		if (agregarLibro5) {
			System.out.println("El libro 5 se ha agregado correctamente");
		} else {
			System.out.println("El libro 5 no se ha agregado");
		}

		Libro libro6 = new Libro();
		System.out.println("Introduce el nombre:");
		String nombre6 = sc.nextLine();

		System.out.println("Introduce el precio");
		double precio6 = sc.nextDouble();
		sc.nextLine();

		libro6.setName(nombre6);
		libro6.setPrice(precio6);
		libro6.setAutor(a3);
		libro6.setEditorial(e1);

		boolean agregarLibro6 = gl.agregar(libro6);
		if (agregarLibro6) {
			System.out.println("El libro 6 se ha agregado correctamente");
		} else {
			System.out.println("El libro 6 no se ha agregado");
		}

		Libro libro7 = new Libro();
		System.out.println("Introduce el nombre:");
		String nombre7 = sc.nextLine();

		System.out.println("Introduce el precio");
		double precio7 = sc.nextDouble();
		sc.nextLine();

		libro7.setName(nombre7);
		libro7.setPrice(precio7);
		libro7.setAutor(a1);
		libro7.setEditorial(e1);

		boolean agregarLibro7 = gl.agregar(libro7);
		if (agregarLibro7) {
			System.out.println("El libro 7 se ha agregado correctamente");
		} else {
			System.out.println("El libro 7 no se ha agregado");
		}

		Libro libro8 = new Libro();
		System.out.println("Introduce el nombre:");
		String nombre8 = sc.nextLine();

		System.out.println("Introduce el precio");
		double precio8 = sc.nextDouble();
		sc.nextLine();

		libro8.setName(nombre8);
		libro8.setPrice(precio8);
		libro8.setAutor(a1);
		libro8.setEditorial(e1);

		boolean agregarLibro8 = gl.agregar(libro8);
		if (agregarLibro8) {
			System.out.println("El libro 8 se ha agregado correctamente");
		} else {
			System.out.println("El libro 8 no se ha agregado");
		}

	}

	private static void addLibreria() {

		Libro l1 = em.find(Libro.class, 1);
		Libro l2 = em.find(Libro.class, 2);
		Libro l3 = em.find(Libro.class, 3);
		Libro l4 = em.find(Libro.class, 4);
		Libro l5 = em.find(Libro.class, 5);
		Libro l6 = em.find(Libro.class, 6);
		Libro l7 = em.find(Libro.class, 7);
		Libro l8 = em.find(Libro.class, 8);
		
		//Creamos los objetos
		Libreria lib1 = new Libreria(null, "l1", "d1", "dir1", null);
		Libreria lib2 = new Libreria(null, "l2", "d2", "dir2", null);
		
		List<Libro> librosLibreria1 = new ArrayList<Libro>();

		librosLibreria1.add(l1);
		librosLibreria1.add(l2);
		librosLibreria1.add(l3);
		librosLibreria1.add(l4);
		
		lib1.setLibros(librosLibreria1);


		boolean agregarLibreria = glibreria.agregar(lib1);
		if (agregarLibreria) {
			System.out.println("La libreria se ha agregado correctamente");
		} else {
			System.out.println("La libreria no se ha agregado");
		}

		System.out.println("Introduzca el nombre:");
		String nombre2 = sc.nextLine();

		System.out.println("Introduzca el nombre del dueño");
		String nombreDuenio2 = sc.nextLine();

		System.out.println("Introduzca la direccion:");
		String direccion2 = sc.nextLine();

		lib2.setName(nombre2);
		lib2.setNombreDuenio(nombreDuenio2);
		lib2.setDireccion(direccion2);

		List<Libro> librosLibreria2 = new ArrayList<Libro>();
		librosLibreria2.add(l5);
		librosLibreria2.add(l6);
		librosLibreria2.add(l7);
		librosLibreria2.add(l8);

		lib1.setLibros(librosLibreria2);

		boolean agregarLibreria2 = glibreria.agregar(lib2);
		if (agregarLibreria2) {
			System.out.println("La libreria se ha agregado correctamente");
		} else {
			System.out.println("La libreria no se ha agregado");
		}

	}

}
