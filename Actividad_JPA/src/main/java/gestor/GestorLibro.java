package gestor;

import java.util.List;

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
	
	public List<Libro> getlibrosYLibreria(){
		return daoLibro.getlibrosYLibreria();
	}
	
	public List<Libro> getlibrosConEditorialYAutor(){
		return daoLibro.getLibrosConEditoralYAutor();
	}

}
