package modelo.persistencia.interfaces;

import java.util.List;

import modelo.entidad.Pasajero;

public interface DaoPasajero {

	//Esta interfaz define un CRUD para el objeto pasajero
	//es decir, las operaciones basicas que podemos hacer con una entidad
	//Create
	//Read
	//Update
	//Delete
	
		public boolean alta(Pasajero p);
		public boolean baja(int id);
		public List<Pasajero> listar();
		public boolean addPasajeroCoche(int idPasajero, int idCoche);
		public boolean deletePasajeroCoche(int idPasajero);
		public List<Pasajero> pasajerosCoche(int idCoche);
		
}
