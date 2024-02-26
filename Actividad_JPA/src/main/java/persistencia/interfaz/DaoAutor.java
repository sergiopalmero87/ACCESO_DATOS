package persistencia.interfaz;

import java.util.List;

import entidad.Autor;

public interface DaoAutor {
	
	public boolean agregar(Autor autor);
	
	public List<Autor> autoresLibros();

}
