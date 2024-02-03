package gestor;

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
	private DaoPasajero daoPasajero = new DaoPasajeroMySql();
	
	
	/**
	 * Método para dar de alta un coche en la BBDD.
	 * 
	 * @param c Coche que damos de alta.
	 * @return 0 Si la longitud de la marca es mayor o igual a 3 y el alta se completa exitosamente,
	 * 1 si hay algún fallo de conexión con la BBDD, 2 si no se ha podido completar el alta.
	 */
	public int alta(Coche c){
		if(c.getMarca().length() >= 3) {
			boolean alta = daoCoche.alta(c);
			if(alta) {
				return 0;
			}else {
				return 1;
			}
		}else {
			return 2;
		}
	}
	
	public boolean baja(int id){
		boolean baja = daoCoche.baja(id);
		return baja;
	}

}
