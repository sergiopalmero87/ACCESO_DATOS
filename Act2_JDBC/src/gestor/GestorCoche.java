package gestor;

import java.util.ArrayList;
import java.util.List;

import modelo.entidad.Coche;
import modelo.persistencia.DaoCocheMySql;
import modelo.persistencia.DaoPasajeroMySql;
import modelo.persistencia.interfaces.*;

//Aquí irian todas las reglas de negocio de nuestra aplicacion, se aplicarían
//antes de llamar a la BBDD. 
public class GestorCoche {

	// Aquí podemos jugar con cambiar el dao que queremos usar
	// podemos usar DaoCocheMySql o DaoPasajeroMySql
	// Gracias a las interfaces solo tenemos que cambiar el objeto
	private DaoCoche daoCoche = new DaoCocheMySql();
	
	
	
	/**
	 * Método para dar de alta un coche en la BBDD.
	 * 
	 * @param c Coche que damos de alta.
	 * @return true si el coche se da de alta, false si el coche no se da de alta.
	 */
	public boolean alta(Coche c) {
		if (!c.getMarca().isEmpty() || !c.getModelo().isEmpty()) {
			boolean alta = daoCoche.alta(c);
			if (alta) {
				return true;
			} else {
				return false;
			}
		}
		return false;

	}
	
	public boolean baja(int id){
		boolean baja = daoCoche.baja(id);
		return baja;
	}
	
	
	public Coche consultaCocheID(int id) {
		Coche c = daoCoche.listarUnCoche(id);
		return c;
	}
	
	
	public boolean modificarCoche (Coche c) {
		boolean modificado = daoCoche.modificarCoche(c);
		return modificado;
	}
	
	
	public List<Coche> listarTodosLosCoches() {
		List<Coche> listaCoches = new ArrayList<>();
		listaCoches = daoCoche.listarTodosLosCoches();
		return listaCoches;
	}

}
