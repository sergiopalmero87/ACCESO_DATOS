package persistencia;

import java.util.List;

import entidad.Libro;
import persistencia.interfaz.DaoLibro;

public class DaoLibroJPA implements DaoLibro{

	@Override
	public boolean agregar(Libro libro) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Libro> librosEditoralAutor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Libro> librosLibreria() {
		// TODO Auto-generated method stub
		return null;
	}

}
