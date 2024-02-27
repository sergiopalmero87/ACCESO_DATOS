package gestor;

import entidad.Libreria;
import persistencia.DaoLibreriaJPA;
import persistencia.interfaz.DaoLibreria;

public class GestorLibreria {

	private DaoLibreria daoLibreria = new DaoLibreriaJPA();

	public boolean agregar(Libreria libreria) {

		boolean estaAgregado = daoLibreria.agregar(libreria);

		if (estaAgregado) {
			return true;
		} else {
			return false;
		}
	}

}
