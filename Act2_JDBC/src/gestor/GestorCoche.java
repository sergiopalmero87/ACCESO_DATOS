package gestor;

import java.util.ArrayList;
import java.util.List;

import modelo.entidad.Coche;
import modelo.persistencia.DaoCocheMySql;
import modelo.persistencia.interfaces.*;

//Aquí irian todas las reglas de negocio de nuestra aplicacion, se aplicarían
//antes de llamar a la BBDD. 
public class GestorCoche {

	// Aquí podemos jugar con cambiar el dao que queremos usar
	// podemos usar DaoCocheMySql o DaoPasajeroMySql segun nos convenga.
	// Gracias a las interfaces solo tenemos que cambiar el objeto
	private DaoCoche daoCoche = new DaoCocheMySql();
	
	
	
	/**
	 * Método para dar de alta un coche en la BBDD. Si la marca y el modelo no están vacios, se realiza el alta.
	 * 
	 * @param c Coche que damos de alta.
	 * @return true si el coche se da de alta, false si el coche no se da de alta.
	 */
	public boolean alta(Coche c) {
		if (!c.getMarca().isEmpty() && !c.getModelo().isEmpty()) {
			boolean alta = daoCoche.alta(c);
			return alta;
		}
		return false;

	}
	
	
	/**
	 * Método para dar de baja un coche de la BBDD.
	 * 
	 * @param id Id del coche a dar de baja.
	 * @return true si se da de baja, false si no se completa la operación.
	 */
	public boolean baja(int id){
		boolean baja = daoCoche.baja(id);
		return baja;
	}
	
	
	
	/**
	 * Método para consultar un coche de la BBDD a partir de su ID.
	 * 
	 * @param id Id del coche a consultar.
	 * @return El coche que queremos consultar.
	 */
	public Coche consultaCocheID(int id) {
		Coche c = daoCoche.listarUnCoche(id);
		return c;
	}
	
	
	/**
	 * Método para modificar un coche de la BBDD. Se solicita toda la información del nuevo coche y se modifica a partir de su ID.
	 * 
	 * @param c La información completa del coche que queremos modificar. 
	 * @return true si se ha modificado y false si no se ha podido modificar.
	 */
	public boolean modificarCoche (Coche c) {
		boolean modificado = daoCoche.modificarCoche(c);
		return modificado;
	}
	
	
	
	/**
	 * Método para listar todos los coches que tenemos en la BBDD.
	 * 
	 * @return La lista completa de coches almacenados en la BBDD.
	 */
	public List<Coche> listarTodosLosCoches() {
		List<Coche> listaCoches = new ArrayList<>();
		listaCoches = daoCoche.listarTodosLosCoches();
		return listaCoches;
	}

}
