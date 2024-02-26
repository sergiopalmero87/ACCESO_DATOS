package vista;



import entidad.Autor;
import gestor.GestorAutor;

public class Main {

	public static void main(String[] args) {
		
		
		
		Autor autor = new Autor();
		GestorAutor ga = new GestorAutor();
		boolean agregar = ga.agregar(autor);
		if(agregar) {
			System.out.println("Bienvenido a nuestro programa");
		}else {
			System.out.println("NO");
		}
		
		
		
	}

}
