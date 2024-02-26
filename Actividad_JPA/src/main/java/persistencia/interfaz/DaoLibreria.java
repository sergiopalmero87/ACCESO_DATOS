package persistencia.interfaz;

import java.util.List;

import entidad.Libreria;

public interface DaoLibreria {
	
	public boolean agregar(Libreria libreria);
	
	public List<Libreria> libreriasLibro();

}
