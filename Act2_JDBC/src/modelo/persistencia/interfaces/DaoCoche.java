package modelo.persistencia.interfaces;

import java.util.List;

import modelo.entidad.Coche;

public interface DaoCoche {

	// Esta interfaz define un CRUD para el objeto coche
	// es decir, las operaciones basicas que podemos hacer con una entidad
	// Create
	// Read
	// Update
	// Delete

	public boolean alta(Coche c);

	public boolean baja(int idCoche);
	
	public Coche listarUnCoche(int idCoche);
	
	public Coche modificarCoche(Coche c);

	public List<Coche> listarTodosLosCoches();

}
