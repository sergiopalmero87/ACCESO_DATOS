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

		autorAdd();
		editorialAdd();
		libroAdd();
		libreriaAdd();


	}

	private static void autorAdd() {

		Autor a1 = new Autor(null, "Sergio", "Palmero", null);
		String fechaNacimientoStr = "1996-09-22";
		Date fechaNacimiento = Date.valueOf(fechaNacimientoStr);
		a1.setBorn(fechaNacimiento);

		boolean agregarAutor = ga.agregar(a1);
		if (agregarAutor) {
			System.out.println("El usuario 1 se ha agregado correctamente");
		} else {
			System.out.println("El usuario 1 no se ha agregado");
		}
		
		Autor a2 = new Autor(null, "Iris", "De Vicente", null);
		String fechaNacimientoStr2 = "1997-11-27";
		Date fechaNacimiento2 = Date.valueOf(fechaNacimientoStr2);
		a2.setBorn(fechaNacimiento2);

		boolean agregarAutor2 = ga.agregar(a2);
		if (agregarAutor2) {
			System.out.println("El usuario 2 se ha agregado correctamente");
		} else {
			System.out.println("El usuario 2 no se ha agregado");
		}
		
		Autor a3 = new Autor(null, "India", "Palmero De Vicente", null);
		String fechaNacimientoStr3 = "2020-02-15";
		Date fechaNacimiento3 = Date.valueOf(fechaNacimientoStr3);
		a1.setBorn(fechaNacimiento3);

		boolean agregarAutor3 = ga.agregar(a3);
		if (agregarAutor3) {
			System.out.println("El usuario 3 se ha agregado correctamente");
		} else {
			System.out.println("El usuario 3 no se ha agregado");
		}

	}

	
	private static void editorialAdd() {

		Editorial e = new Editorial(null, "Editorial1", "Direccion1");
		e.setLibros(libros);

		boolean agregarEditorial = ge.agregar(e);
		if (agregarEditorial) {
			System.out.println("La editorial 1 se ha agregado correctamente");
		} else {
			System.out.println("La editorial 1 no se ha agregado");
		}

		Editorial e2 = new Editorial(null, "Editorial2", "Direccion2");
		e.setLibros(libros);

		boolean agregarEditorial2 = ge.agregar(e2);
		if (agregarEditorial2) {
			System.out.println("La editorial 2 se ha agregado correctamente");
		} else {
			System.out.println("La editorial 2 no se ha agregado");
		}
	}

	

	private static void libroAdd() {
		Autor a1 = em.find(Autor.class, 1);
		Autor a2 = em.find(Autor.class, 2);
		Autor a3 = em.find(Autor.class, 3);
		
		Editorial e1 = em.find(Editorial.class, 1);
		Editorial e2 = em.find(Editorial.class, 2);

		Libro l1 = new Libro(null, "Libro1", 12);
		l1.setAutor(a1);
		l1.setEditorial(e1);
		a1.setLibros(libros);
		e1.setLibros(libros);

		boolean agregarLibro1 = gl.agregar(l1);
		if (agregarLibro1) {
			System.out.println("El libro 1 se ha agregado correctamente");
		} else {
			System.out.println("El libro 1 no se ha agregado");

		}
		
		Libro l2 = new Libro(null, "Libro2", 12);
		l2.setAutor(a1);
		l2.setEditorial(e1);
		a1.setLibros(libros);
		e1.setLibros(libros);

		boolean agregarLibro2 = gl.agregar(l2);
		if (agregarLibro2) {
			System.out.println("El libro 2 se ha agregado correctamente");
		} else {
			System.out.println("El libro 2 no se ha agregado");

		}
		
		Libro l3 = new Libro(null, "Libro3", 12);
		l3.setAutor(a2);
		l3.setEditorial(e2);

		boolean agregarLibro3 = gl.agregar(l3);
		if (agregarLibro3) {
			System.out.println("El libro 3 se ha agregado correctamente");
		} else {
			System.out.println("El libro 3 no se ha agregado");

		}
		
		Libro l4 = new Libro(null, "Libro4", 12);
		l4.setAutor(a2);
		l4.setEditorial(e2);

		boolean agregarLibro4 = gl.agregar(l4);
		if (agregarLibro4) {
			System.out.println("El libro 4 se ha agregado correctamente");
		} else {
			System.out.println("El libro 4 no se ha agregado");

		}
		
		Libro l5 = new Libro(null, "Libro5", 12);
		l5.setAutor(a3);
		l5.setEditorial(e1);

		boolean agregarLibro5 = gl.agregar(l5);
		if (agregarLibro5) {
			System.out.println("El libro 5 se ha agregado correctamente");
		} else {
			System.out.println("El libro 5 no se ha agregado");

		}
		
		Libro l6 = new Libro(null, "Libro6", 12);
		l6.setAutor(a3);
		l6.setEditorial(e1);

		boolean agregarLibro6 = gl.agregar(l6);
		if (agregarLibro6) {
			System.out.println("El libro 6 se ha agregado correctamente");
		} else {
			System.out.println("El libro 6 no se ha agregado");

		}
		
		Libro l7 = new Libro(null, "Libro7", 12);
		l7.setAutor(a1);
		l7.setEditorial(e2);

		boolean agregarLibro7 = gl.agregar(l7);
		if (agregarLibro7) {
			System.out.println("El libro 7 se ha agregado correctamente");
		} else {
			System.out.println("El libro 7 no se ha agregado");

		}
		
		Libro l8 = new Libro(null, "Libro8", 12);
		l8.setAutor(a2);
		l8.setEditorial(e1);

		boolean agregarLibro8 = gl.agregar(l8);
		if (agregarLibro8) {
			System.out.println("El libro 8 se ha agregado correctamente");
		} else {
			System.out.println("El libro 8 no se ha agregado");

		}

	}

	

	private static void libreriaAdd() {
	    Libro l1 = em.find(Libro.class, 1);
	    Libro l2 = em.find(Libro.class, 2);
	    Libro l3 = em.find(Libro.class, 3);
	    Libro l4 = em.find(Libro.class, 4);
	    Libro l5 = em.find(Libro.class, 5);
	    Libro l6 = em.find(Libro.class, 6);
	    Libro l7 = em.find(Libro.class, 7);
	    Libro l8 = em.find(Libro.class, 8);

	    Libreria lib1 = new Libreria(null, "l1", "d1", "dir1", null);
	    Libreria lib2 = new Libreria(null, "l2", "d2", "dir2", null);

	    List<Libro> librosLibreria1 = new ArrayList<>();
	    librosLibreria1.add(l1);
	    librosLibreria1.add(l2);
	    librosLibreria1.add(l3);
	    librosLibreria1.add(l4);
	    lib1.setLibros(librosLibreria1);

	    List<Libro> librosLibreria2 = new ArrayList<>();
	    librosLibreria2.add(l5);
	    librosLibreria2.add(l6);
	    librosLibreria2.add(l7);
	    librosLibreria2.add(l8);
	    lib2.setLibros(librosLibreria2);

	    boolean agregarLibreria1 = glibreria.agregar(lib1);
	    if (agregarLibreria1) {
	        System.out.println("La libreria se ha agregado correctamente");
	    } else {
	        System.out.println("La libreria no se ha agregado");
	    }

	    boolean agregarLibreria2 = glibreria.agregar(lib2);
	    if (agregarLibreria2) {
	        System.out.println("La libreria se ha agregado correctamente");
	    } else {
	        System.out.println("La libreria no se ha agregado");
	    }
	}


}
