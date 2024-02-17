package vista;

import java.time.LocalDate;

import entidad.Autor;
import gestor.GestorAutor;

public class Main {

	public static void main(String[] args) {
		
		LocalDate born = LocalDate.of(1995, 1, 31);
		
		Autor autor = new Autor(0, "Sergio", "Palmero", born);
		GestorAutor ga = new GestorAutor();
		boolean agregar = ga.agregar(autor);
		if(agregar) {
			System.out.println("Bienvenido a nuestro programa");
		}else {
			System.out.println("NO");
		}
		
		
		
	}

}
