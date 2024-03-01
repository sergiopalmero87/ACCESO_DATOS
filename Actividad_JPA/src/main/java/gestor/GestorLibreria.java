package gestor;

import java.util.List;

import entidad.Libreria;
import persistencia.DaoLibreriaJPA;
import persistencia.interfaz.DaoLibreria;

public class GestorLibreria {

	private DaoLibreria daoLibreria = new DaoLibreriaJPA();

	
	/**
	 * Método para agregar una libreria a la BBDD
	 * @param libreria Objeto libreria a agregar
	 * @return true si se agrega correctamente y false si no se ha podido agrgegar
	 */
	public boolean agregar(Libreria libreria) {

		boolean estaAgregado = daoLibreria.agregar(libreria);

		if (estaAgregado) {
			return true;
		} else {
			return false;
		}
	}
	
	
	/**
	 * Método que nos devuelde una lista con las libreria y sus libros asociados
	 * @return Lista de librerias con sus libros asociados
	 */
	public List<Libreria> libreriaYLibros(){
		return daoLibreria.libreriasLibro();
	}

}
