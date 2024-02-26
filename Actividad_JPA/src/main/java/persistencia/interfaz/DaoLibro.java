package persistencia.interfaz;

import java.util.List;

import entidad.Libro;

public interface DaoLibro {
	
	public boolean agregar(Libro libro);
	
	public List<Libro> librosEditoralAutor();
	
	public List<Libro> librosLibreria();

}
