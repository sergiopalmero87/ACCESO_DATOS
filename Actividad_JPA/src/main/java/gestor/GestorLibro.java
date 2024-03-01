package gestor;

import java.util.List;

import entidad.Libro;
import persistencia.DaoLibroJPA;
import persistencia.interfaz.DaoLibro;

public class GestorLibro {
	
	private DaoLibro daoLibro = new DaoLibroJPA();
	
	
	/**
	 * Método para agregar libros a la BBDD
	 * @param libro Objeto libro a agregar
	 * @return true si se ha agregado y false si no se puede agregar
	 */
	public boolean agregar(Libro libro) {
		
		boolean estaAgregado = daoLibro.agregar(libro);
		
		if(estaAgregado) {
			return true; 
		}else {
			return false;
		}
	}
	
	
	/**
	 * Método que devuelve una lista con los libros y la libreria a la que pertenecen
	 * @return Lista que contiene los libros y la libreria en la que están
	 */
	public List<Libro> getlibrosYLibreria(){
		return daoLibro.getlibrosYLibreria();
	}
	
	
	/**
	 * Método que devuelve una lista de los libros dados de alta con su editorial y autor asociados
	 * @return Lista que contiene los libros y su editorial y autor asociados
	 */
	public List<Libro> getlibrosConEditorialYAutor(){
		return daoLibro.getLibrosConEditoralYAutor();
	}

}
