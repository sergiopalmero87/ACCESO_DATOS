package gestor;

import entidad.Libro;
import persistencia.DaoLibroJPA;
import persistencia.interfaz.DaoLibro;

public class GestorLibro {
	
	private DaoLibro daoLibro = new DaoLibroJPA();
	
	public boolean agregar(Libro libro) {
		
		boolean estaAgregado = daoLibro.agregar(libro);
		
		if(estaAgregado) {
			return true; 
		}else {
			return false;
		}
	}

}
