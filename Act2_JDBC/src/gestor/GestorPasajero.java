package gestor;


import java.util.ArrayList;
import java.util.List;

import modelo.entidad.Coche;
import modelo.entidad.Pasajero;
import modelo.persistencia.DaoPasajeroMySql;
import modelo.persistencia.interfaces.DaoPasajero;

public class GestorPasajero {

	private DaoPasajero daoPasajero = new DaoPasajeroMySql();

	
	/**
	 * Método para crear un nuevo pasajero.
	 * 
	 * @param p Pasajero a crear.
	 * @return 0 si el pasajero es creado con éxito, 1 si no se ha podido crear.
	 */
	public int alta(Pasajero p) {
		boolean alta = daoPasajero.alta(p);
		if (alta) {
			return 0;
		} else {
			return 1;
		}

	}
	
	
	/**
	 * Método para borrar un pasajero.
	 * 
	 * @param id Id del pasajero a borrar.
	 * @return false si no se ha podido borrar, true si se ha borrado con éxito.
	 */
	public boolean baja(int id){
		boolean baja = daoPasajero.baja(id);
		return baja;
	}
	
	
	
	/**
	 * Método para obtener un pasajero a partir de su Id.
	 * 
	 * @param id Id del pasajero a consultar.
	 * @return p Pasajero
	 */
	public Pasajero obtenerPasajero(int id) {
		Pasajero p = daoPasajero.consultarPasajero(id);
		return p;
	}
	
	
	
	/**
	 * Método que devuelve una lista con todos los pasajeros.
	 * 
	 * @return listaPasajeros Lista de pasajeros.
	 */
	public List<Pasajero> listarTodosLosPasasjeros() {
		List<Pasajero> listaPasajeros = new ArrayList<>();
		listaPasajeros = daoPasajero.listarTodosPasajeros();
		return listaPasajeros;
	}
	
	/**
	 * Método que anade un pasajero a un coche según sus ID.
	 * 
	 * @param idCoche Id del coche al que se anade el pasajero.
	 * @param idPasajero Id del pasajero anadido.
	 * @return true si ha sido un éxito, false si no se ha completado.
	 */
	public boolean addPasajeroCoche(int idCoche, int idPasajero) {
		boolean add = daoPasajero.addPasajeroCoche(idCoche, idPasajero);
		return add;
	}
	
	
	
	/**
	 * Método para desasignar un pasajero de un coche.
	 * 
	 * @param idPasajero Id del pasajero que queremos desasignar.
	 * @return true si se completa y false si no.
	 */
	public boolean deletePasajeroCoche(int idPasajero) {
		boolean delete = daoPasajero.deletePasajeroCoche(idPasajero);
		return delete;
	}
	
	
	/**
	 * Método para listar todos los pasajeros que tiene asignado un coche.
	 * 
	 * @param idCoche ID del coche el cual queremos saber los pasajeros que tiene asignados.
	 * @return La lista de pasajeros que tiene el coche.
	 */
	public List<Pasajero> todosPasajerosCoche(int idCoche){
		List<Pasajero> listaPasajerosCoche = new ArrayList<Pasajero>();
		listaPasajerosCoche = daoPasajero.todosPasajerosCoche(idCoche);
		return listaPasajerosCoche;
	}

}
