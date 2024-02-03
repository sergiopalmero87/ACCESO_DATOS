package gestor;

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
}
